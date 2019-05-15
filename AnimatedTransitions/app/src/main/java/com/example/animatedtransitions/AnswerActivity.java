/*
     Luis Aguinaga z1811673 Portfolio 8  03/18/2019
        Animated Transitions

        this app moves from one background image to another one
        with effects.
 */

package com.example.animatedtransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnswerActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
    }
    //on click method to handle button
    public void showQuestion(View view)
    {
        finish();
        overridePendingTransition(R.anim.question_on, R.anim.question_off);
    }

}
