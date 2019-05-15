package com.example.bouncingball;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create a frame layout and connect it to the screen
        FrameLayout layout = findViewById(R.id.frameLayout);
        //create bounce surface view
        BounceSurfaceView bounceSurfaceView = new BounceSurfaceView(this, null);

        layout.addView(bounceSurfaceView);


    }
}
