package io.first.lab6;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    final String[] radioOptions = {"Питання", "Відповідь"};
    final String[] checkOptions = {"Прізвище", "Ім'я", "Група"};
    boolean surnameSelected;
    boolean nameSelected;
    boolean groupSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this)
                        .setTitle("Програма хоче поставити запитання")
                        .setSingleChoiceItems(radioOptions, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(which==0){
                                    Toast.makeText(getApplicationContext(),"Хто стукає в наші ворота?",Toast.LENGTH_LONG).show();
                                } else{
                                    Toast.makeText(getApplicationContext(),"Той, хто скуштував плід і пізнав його таємниці",Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setCancelable(true);
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this)
                        .setTitle("Оберіть потрібну інформацію про студента")
                        .setMultiChoiceItems(checkOptions, new boolean[]{false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if(which==0){
                                    surnameSelected = isChecked;
                                } else if(which==1){
                                    nameSelected = isChecked;
                                } else{
                                    groupSelected = isChecked;
                                }
                            }
                        }).setPositiveButton("Показати", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                TextView tv = findViewById(R.id.textView2);
                                tv.setText("");
                                if(groupSelected){
                                    tv.setText(tv.getText().toString().concat("ІПЗ-17-1 "));
                                }
                                if(surnameSelected){
                                    tv.setText(tv.getText().toString().concat("Романчук "));
                                }
                                if(nameSelected){
                                    tv.setText(tv.getText().toString().concat("Сергій"));
                                }
                            }
                        });
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button rankBtn = (Button) findViewById(R.id.rate_button);
        rankBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog rankDialog = new Dialog(ThirdActivity.this);
                rankDialog.setContentView(R.layout.rank_dialog);
                rankDialog.setCancelable(true);
                final RatingBar ratingBar = (RatingBar)rankDialog.findViewById(R.id.dialog_ratingbar);
                ratingBar.setRating(0);

                Button updateButton = (Button) rankDialog.findViewById(R.id.rank_dialog_button);
                updateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rankDialog.dismiss();
                        Toast.makeText(getApplicationContext(),
                                "Оцінка: "+ ratingBar.getRating(),Toast.LENGTH_LONG).show();
                    }
                });
                rankDialog.show();
            }
        });

    }
}
