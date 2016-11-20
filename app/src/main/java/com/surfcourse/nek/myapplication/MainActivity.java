package com.surfcourse.nek.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import interfaces.OnCustomViewClickListener;

public class MainActivity extends AppCompatActivity {

    private String tag = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "onCreate");
        final TextView textView = (TextView) findViewById(R.id.activity_main_text_view);
        final CounterView  counterView = (CounterView) findViewById(R.id.counter_view);
        counterView.setOnClickListener(new OnCustomViewClickListener(){
            @Override
            public void onClick() {
                textView.setText(String.valueOf(counterView.getValue()));
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", "sfd!");
    }

}
