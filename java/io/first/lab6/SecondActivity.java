package io.first.lab6;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends AppCompatActivity {

    final String[] options = {"Перша activity", "Третя activity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this)
                        .setTitle("Оберіть потрібний варіант")
                        .setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(which==0) {
                                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                                    startActivity(intent);
                                } else{
                                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                                    startActivity(intent);
                                }
                            }
                            });
                final AlertDialog dialog = builder.create();
                dialog.show();
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        dialog.dismiss();
                        timer.cancel();
                    }
                }, 5000);
            }
        });
    }
}
