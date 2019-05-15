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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    //global variables
    String record;
    String info;
    ImageView teamImage;
    Spinner teamSpinner;
    ArrayAdapter<String> adapter;
    final static int REQUES_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //list to hold options for the spinner
        List<String> teams = new ArrayList<String>();
        teams.add("Chicago Bulls");
        teams.add("Boston Celtics");
        teams.add("Los Angeles Lakers");
        teams.add("Miami Heat");
        teams.add("Golden State Warriors");

        //spinner element
        teamSpinner = findViewById(R.id.pickTeam);
        teamImage = findViewById(R.id.teamLogo);

        //set spinner click listener
        teamSpinner.setOnItemSelectedListener(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teams );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        teamSpinner.setAdapter(adapter);

    }
    //method for the spinners. which option the choose
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
    {
        switch(position)
        {
            case 0:
                record = "Chicago Bulls";
                teamImage.setImageResource(R.drawable.bulls);
                info = getString(R.string.bulls);
                break;
            case 1:
                record = "Boston Celtics";
                teamImage.setImageResource(R.drawable.boston);
                info = getString(R.string.celtics);
                break;
            case 2:
                record = "Los Angeles Lakers";
                teamImage.setImageResource(R.drawable.lakers);
                info = getString(R.string.lakers);
                break;
            case 3:
                record = "Miami Heat";
                teamImage.setImageResource(R.drawable.miami);
                info = getString(R.string.heat);
                break;
            case 4:
                record = "Golden State Warriors";
                teamImage.setImageResource(R.drawable.golden);
                info = getString(R.string.warriors);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    //onclick method for the button. starts the second activity
    public void showTeam(View view)
    {
        Intent teamIntern = new Intent(MainActivity.this, InfoScreenActivity.class);
        teamIntern.putExtra("team", record);
        teamIntern.putExtra("des", info);
        startActivity(teamIntern);
    }

}
