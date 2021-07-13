package com.example.travelfigma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation titleAnimation = new AlphaAnimation(0.0f, 1.0f);
        final Animation subTitleAnimation = new AlphaAnimation(0.0f, 1.0f);
        final Animation subTitle2Animation = new AlphaAnimation(0.0f, 1.0f);
        final Animation subTitle3Animation = new AlphaAnimation(0.0f, 1.0f);
        final Animation subTitle4Animation = new AlphaAnimation(0.0f, 1.0f);

        subTitleAnimation.setStartOffset(1000);
        subTitle2Animation.setStartOffset(2100);
        subTitle3Animation.setStartOffset(3500);
        subTitle4Animation.setStartOffset(5200);
        titleAnimation.setStartOffset(8000);

        subTitleAnimation.setDuration(2000);
        subTitle2Animation.setDuration(2000);
        subTitle3Animation.setDuration(2000);
        subTitle4Animation.setDuration(2000);
        titleAnimation.setDuration(2000);

        TextView title = (TextView) findViewById(R.id.title);
        TextView subTitle = (TextView) findViewById(R.id.subTitle);
        TextView subTitle2 = (TextView) findViewById(R.id.subTitle2);
        TextView subTitle3 = (TextView) findViewById(R.id.subTitle3);
        TextView subTitle4 = (TextView) findViewById(R.id.subTitle4);

        title.startAnimation(titleAnimation);
        subTitle.startAnimation(subTitleAnimation);
        subTitle2.startAnimation(subTitle2Animation);
        subTitle3.startAnimation(subTitle3Animation);
        subTitle4.startAnimation(subTitle4Animation);
    }
}