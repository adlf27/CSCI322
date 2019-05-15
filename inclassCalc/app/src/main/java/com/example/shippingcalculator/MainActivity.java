package com.example.shippingcalculator;
/********************************************************************
 CSCI 322 - Portfolio 2 Shipping Calculator - Semester (Spring) Year 2019

 Programmer(s): Luis Aguinaga  z1811673
 Section: 1

 Purpose: this app is a shipping calculator that changes to amount on
 real time. it calculates the shipping amount based on amount set before
 hand.
 *********************************************************************/
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    //instance variables
    ShippingItem item;
    EditText weightEDT;
    TextView baseTV, addedTV, totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calls the shipping constructort
        item = new ShippingItem();
        //connect the class variables with app names
        weightEDT = findViewById(R.id.weightEditText);
        baseTV = findViewById(R.id.baseCostTextView);
        addedTV = findViewById(R.id.addedCostTextView);
        totalTV = findViewById(R.id.totalCostTextView);
        //sets the focus on the edit text view bar to enter the weight
        weightEDT.requestFocus();
        //creates a text change lisitener
        weightEDT.addTextChangedListener(weightWatcher);
    }

    TextWatcher weightWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            try{
                item.setWeight(Integer.parseInt(charSequence.toString()));
            }
            catch (NumberFormatException nfe)
            {
                item.setWeight(0);
            }
            DecimalFormat df = new DecimalFormat("#0.00");

            //put the various cost to the textviews
            baseTV.setText("$" + df.format(item.getBaseCost()));
            addedTV.setText("$" + df.format(item.getAddedCost()));
            totalTV.setText("$" + df.format(item.getTotalCost()));

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    public void helpButton(View view)
    {
        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(intent);

    }

}
