package com.example.caloriecalculator;
/********************************************************************
 CSCI 322 - Portfolio 3 Calorie Calculator - Semester (Spring) Year 2019

 Programmer(s): Luis Aguinaga  z1811673
 Section: 1

 Purpose: this app demonstrate widgets such as radio buttons, check boxes,
 seek bars, and image views. The application will count calories for custom burgers
 *********************************************************************/
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    //instance variables
    RadioGroup group1;
    CalorieInfo myburger;
    CheckBox bacon;
    RadioGroup group2;
    SeekBar sauce;
    TextView result;
    private int total;
    int progressValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myburger = new CalorieInfo();
        total = 0;
        //set the variables to the widget variables
        group1 = findViewById(R.id.pattyGroup);
        group2 = findViewById(R.id.chesseGroup);
        bacon = findViewById(R.id.baconCB);
        sauce = findViewById(R.id.specialSauce);
        result = findViewById(R.id.totalCalorie);

        //oncheck listener for the burger radio group
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //checks which radio button was checked
                if(R.id.beefRadio == i)
                {
                    total = myburger.getBuggerPatty();
                    result.setText("" + total);
                }
                if(R.id.turkeyRadio == i)
                {
                    total = myburger.getTurkeyPatty();
                    result.setText("" + total);
                }
                if(R.id.veggieRadio == i)
                {
                    total = myburger.getVeggiePatty();
                    result.setText("" + total);
                }
            }
        });
        //on click listener for the check box
        bacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //adds the bacon calories to the total calorie
                if(bacon.isChecked())
                {
                    total += myburger.getBacon();
                    result.setText(" " + total);
                }
            }
        });

        //on checked listener for the group for the chesse
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                //finds which chesse was pressed and adds it to the total
                if(R.id.noChesseRadio == i)
                {
                    total += myburger.getNoChesse();
                    result.setText(" " + total);
                }

                if(R.id.cheddarRadio == i)
                {
                    total += myburger.getCheddar();
                    result.setText(" " + total);
                }

                if(R.id.mozareRadio == i)
                {
                    total += myburger.getMoza();
                    result.setText(" " + total);
                }
            }
        });
        sauce.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                total += i;
                result.setText(" " + total);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
