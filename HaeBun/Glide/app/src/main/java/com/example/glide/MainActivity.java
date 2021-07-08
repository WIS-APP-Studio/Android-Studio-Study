package com.example.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView target = (ImageView) findViewById(R.id.imageView);
        String url = "https://raw.githubusercontent.com/gilbutITbook/080219/master/images/6-10.jpg";
        Glide.with(context).load(url).into(target);
    }
}