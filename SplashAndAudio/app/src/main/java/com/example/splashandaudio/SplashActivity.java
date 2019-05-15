package com.example.splashandaudio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //create the TimerTask
        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                //finish the activity
                finish();
            }
        };

        //create the timer object
        Timer timer = new Timer();

        //create the schedule
        timer.schedule(task, 5000);



    }//end of onCreate
}
