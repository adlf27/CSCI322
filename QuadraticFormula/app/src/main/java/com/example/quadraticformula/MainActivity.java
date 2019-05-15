package com.example.quadraticformula;
/******************************************************************
 *            Assignment 2 Quadratic Function Calculator
 *    Name: Luis Aguinaga z1811673
 *   Class: CSCI322
 *Due Date: 2/27/2019
 *Purpouse: this app takes in 3 values from the user, representoing
 * the a, b, and c coefficient from the quadratic fucntion. it then
 * takes them and applies them to the formula and solves them for the
 * intersecting value of x.
 *
 ********************************************************************/

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    //instance variables
    TextView displayResult, displayDiscr;
    EditText aValue, bValue, cValue;
    private Double a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect the names of the class variable with the app variables
        displayResult = findViewById(R.id.resultTV);
        displayDiscr = findViewById(R.id.disc);
        aValue = findViewById(R.id.valueA);
        bValue = findViewById(R.id.valueB);
        cValue = findViewById(R.id.valueC);
        //start the app with the A value having focus
        aValue.requestFocus();
    }
    // this function is the lisiner for the clear button. it clear any content of the app that is shown
    public void clearContent(View view)
    {
        aValue.setText("");
        bValue.setText("");
        cValue.setText("");
        displayDiscr.setText("");
        displayResult.setText("");
    }
    //this function is the lisiner for the solve button. it checks if a is zero and if there is
    //no values enter for a, b, and c. it also calls the calculate discriminat function and the
    //calculate quadratic function.
    public void solveEquation(View view)
    {
        //check for emppty values
        if(aValue.getText().toString().matches("") || bValue.getText().toString().matches("") || cValue.getText().toString().matches(""))
        {
            //display the error msg and exit
            Toast.makeText(view.getContext(), "Fields Cannot be Empty",Toast.LENGTH_LONG).show();
            return;
        }
        //check if value A is a zero value
        else if(aValue.getText().toString().matches("0"))
        {
            //promt the user cannot divide by zero
            Toast.makeText(view.getContext(),"Value 'A' Cannot Zero", Toast.LENGTH_LONG).show();
            return;
        }
        //get values enter by the user of the app
        a = Double.parseDouble(aValue.getText().toString());
        b = Double.parseDouble(bValue.getText().toString());
        c = Double.parseDouble(cValue.getText().toString());

        //call the calculate quadratic function with the values passed in
        calculateQuadratic(a, b, c);
    }

    //this function takes in 3 parameters, the vlaues of a, b, and c
    //it the calculate the discriminant based on those values
    //returns a double which represents the discriminat
    public Double calculateDiscrim(Double aV, Double bV, Double cV)
    {
        double discr;
        return discr = ((Math.pow(bV,2)) - (4*aV*cV));
    }

    //this function takes 3 arguments the values for a, b, c
    //it then calculate the values witht the quadratic formula.
    public void calculateQuadratic(Double aV, Double bV, Double cV)
    {
        //variables to hold the result
        Double result1 = 0.0, result2 = 0.0;
        //return values of the function
        Double discriminant = calculateDiscrim(aV, bV, cV);
        //decimal format for to decimal places after the decimal point
        DecimalFormat df = new DecimalFormat("#.00");

        //if the discriminant is positive, there is two real answeres
        if(discriminant > 0)
        {
            displayDiscr.setText("The Discriminant > 0 so, there is two real roots.");

            result1 = ((-bV) + Math.sqrt(discriminant)) / (2*aV);
            result2 = ((-bV) - Math.sqrt(discriminant)) / (2*aV);

            displayResult.setText("x= " + df.format(result1) + " and " + df.format(result2));

        }
        //if discriminant is equal to zero. only one answer
        else if(discriminant == 0)
        {
            displayDiscr.setText("The Discriminant = 0 so, there is one real root.");
            result1 = ((-bV) + Math.sqrt(discriminant)) / (2*aV);
            displayResult.setText("x= " + result1);

        }
        //if the discriminant is negative, only imaginary answers
        else if(discriminant < 0)
        {

            displayDiscr.setText("The Discriminant < 0 so, there is no real roots.");
            displayResult.setText("Imaginary");

        }

    }

}


