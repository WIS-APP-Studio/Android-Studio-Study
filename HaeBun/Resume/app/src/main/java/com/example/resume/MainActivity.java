package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("gilbut", "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("gilbut", "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("gilbut", "onDestroy");
    }
}