package com.example.lifestyleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static final String MA_TAG = "Lifecycle";

    private String createMsg, startMsg, resumeMsg, pauseMsg,
                    stopMsg, restartMsg, destroyMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //populate the strings from the string .xml file
        createMsg = (String)getResources().getText(R.string.createMsg);
        startMsg = (String)getResources().getText(R.string.startMsg);
        resumeMsg = (String)getResources().getText(R.string.resumeMsg);
        pauseMsg = (String)getResources().getText(R.string.pauseMsg);
        stopMsg = (String)getResources().getText(R.string.stopMsg);
        restartMsg = (String)getResources().getText(R.string.restartMsg);
        destroyMsg = (String)getResources().getText(R.string.destroyMsg);

        Toast.makeText(getApplicationContext(),createMsg, Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG, createMsg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),startMsg,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG, startMsg);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),resumeMsg,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG, resumeMsg);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),pauseMsg,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG, pauseMsg);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),stopMsg,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG, stopMsg);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),restartMsg,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG, restartMsg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),destroyMsg,Toast.LENGTH_SHORT).show();
        Log.d(MA_TAG, destroyMsg);
    }
    public void nextActivity(View view)
    {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);

    }
}

