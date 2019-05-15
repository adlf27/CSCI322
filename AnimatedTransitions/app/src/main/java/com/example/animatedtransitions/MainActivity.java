/*
     Luis Aguinaga z1811673 Portfolio 8  03/18/2019
        Animated Transitions

        this app moves from one background image to another one
        with effects.
 */
package com.example.animatedtransitions;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showAnswer(View view)
    {
        Intent myIntent = new Intent(this, AnswerActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.answer_on, R.anim.answer_off);
    }
}
