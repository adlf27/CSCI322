package com.example.exam1;
/*             Exam 1
 Name: Luis Aguinaga z1811673
 Due : 03/25/2019
 Purpose: this application will be able to calculate the area of various shapes.
 the user selects which shape to calculate the area based on radio buttons.
 then is opens up another activity where the user can enter the variables to calculate
 with the corresponding formula
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CircleActivity extends AppCompatActivity {
    EditText cirRadius;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        cirRadius = findViewById(R.id.circleRadius);

    }
    public void circleResult(View view)
    {
        //if the fields are empty
        if(cirRadius.getText().toString().matches(""))
        {
            Toast.makeText(view.getContext(),"Field Cannot be Empty", Toast.LENGTH_LONG).show();
            return;
        }

        //calculate result
        result = (3.14159) * Math.pow(Double.parseDouble(cirRadius.getText().toString()),2);
        //sending back result to main activity
        Intent myInten = new Intent(CircleActivity.this, MainActivity.class);
        myInten.putExtra("result", result);
        ((Activity)view.getContext()).setResult(RESULT_OK, myInten);
        //exiting this activity
        finish();

    }

}
