package com.example.lifestyleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String SA_TAG = "2nd Activity LifeCycle";

    private String createMsg, startMsg, resumeMsg, pauseMsg,
            stopMsg, restartMsg, destroyMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        createMsg = (String)getResources().getText(R.string.createMsg2);
        startMsg = (String)getResources().getText(R.string.startMsg2);
        resumeMsg = (String)getResources().getText(R.string.resumeMsg2);
        pauseMsg = (String)getResources().getText(R.string.pauseMsg2);
        stopMsg = (String)getResources().getText(R.string.stopMsg2);
        restartMsg = (String)getResources().getText(R.string.restartMsg2);
        destroyMsg = (String)getResources().getText(R.string.destroyMsg2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(SA_TAG, startMsg);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(SA_TAG, resumeMsg);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(SA_TAG, pauseMsg);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(SA_TAG, stopMsg);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(SA_TAG, restartMsg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(SA_TAG, destroyMsg);
    }

    public void btnClick(View view)
    {
        finish();

    }

}
