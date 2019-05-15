/*
    Assignment 3 Using Widgets and Intents
name: Luis Aguinaga z1811673
due : 03/20/2019
puropose: Android application that can be used to display
information about 5 (at the least) related topics. The application
will consist of two Activities. The main activity will present the 5
topics that the user can choose from. When the user selects a topic the
image for that topic should be displayed. If the user wants to see the
information for that topic, they will click a button to start the second activity.
 */
package com.example.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class InfoScreenActivity extends AppCompatActivity
{
    //global variabless
    String teamName;
    String teamDes;
    TextView teamView, teamInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);
        //sets up the variabels to the widgets of the app
        teamView = findViewById(R.id.teamName);
        teamInformation = findViewById(R.id.teamInformation);

        //intent for the parameter sent by the first activity
        Intent info = getIntent();
        teamName = info.getStringExtra("team");
        Intent des = getIntent();
        teamDes = des.getStringExtra("des");

        //sets the textviews based on the parameters sent
        teamView.setText(teamName);
        teamInformation.setText(teamDes);

    }
    //onclick method for the button. it just exits the second avtivity
    public void backChoices(View view)
    {
        finish();
    }
}
