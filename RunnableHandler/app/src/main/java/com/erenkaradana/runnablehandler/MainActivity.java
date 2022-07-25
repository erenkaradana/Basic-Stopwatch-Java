package com.erenkaradana.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        TextView textView;
        int number;
        Runnable runnable;
        Handler handler;
        Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        number =0;
        button = findViewById(R.id.button);
    }
    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time= "+number);
                number++;
                textView.setText("Time= "+number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);
    }

    public void stop(View view){
        handler.removeCallbacks(runnable);
        number=0;
    button.setEnabled(true);
    textView.setText("Time: "+number);
    }

}