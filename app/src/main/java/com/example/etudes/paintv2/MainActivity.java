package com.example.etudes.paintv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    //custom drawing view
    private CustomView customView;
    //paint color
    private ImageButton currPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = (CustomView)findViewById(R.id.customView);




        final AttributeSet attrs = null;
        final CustomView customView = new CustomView(getApplicationContext(),attrs);





        @SuppressLint("WrongViewCast")
        final Button buttonBlue = findViewById(R.id.buttonBlue);
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setColor("blue");
            }
        });
        @SuppressLint("WrongViewCast")
        final Button buttonRed = findViewById(R.id.buttonRed);
        buttonRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setColor("red");
            }
        });
        @SuppressLint("WrongViewCast")
        final Button buttonBlack = findViewById(R.id.buttonBlack);
        buttonBlack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setColor("black");
            }
        });
        @SuppressLint("WrongViewCast")
        final Button buttonGreen = findViewById(R.id.buttonGreen);
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setColor("green");
            }
        });
        @SuppressLint("WrongViewCast")
        final Button buttonPurple = findViewById(R.id.buttonPurple);
        buttonPurple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setColor("purple");
            }
        });
        @SuppressLint("WrongViewCast")
        final Button buttonPink = findViewById(R.id.buttonPink);
        buttonPink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setColor("pink");
            }
        });
        @SuppressLint("WrongViewCast")
        final Button buttonGrey = findViewById(R.id.buttonGrey);
        buttonGrey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setColor("grey");
            }
        });




        final ImageButton buttonNemo = findViewById(R.id.imageButtonNemo);
        buttonNemo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setFigure(0);
            }
        });
        final ImageButton buttonDory = findViewById(R.id.imageButtonDory);
        buttonDory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setFigure(1);
            }
        });
        final ImageButton buttonStars = findViewById(R.id.imageButtonStars);
        buttonStars.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setFigure(2);
            }
        });
        final ImageButton buttonOlaf = findViewById(R.id.imageButtonOlaf);
        buttonOlaf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setFigure(3);
            }
        });
        final ImageButton buttonFrozen = findViewById(R.id.imageButtonFrozen);
        buttonFrozen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.customView.setFigure(4);
            }
        });





    }




}
