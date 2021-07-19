package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Log.i("gilbut", "onCreate");
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(getApplicationContext(),
                MainActivity2.class);
        startActivity(intent);
    }

    /*
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("gilbut","onResume");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("gilbut", "onDestroy");
    }
     */

}