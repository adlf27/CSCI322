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
import android.widget.Toast;

import java.text.DecimalFormat;

public class TriangleActivity extends AppCompatActivity {

    EditText triBase, triHeight;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        triBase = findViewById(R.id.triangleBase);
        triHeight = findViewById(R.id.triangleHeight);


    }
    public void triangleResult(View view)
    {
        //check if the fields are empty
        if(triBase.getText().toString().matches("") || triHeight.getText().toString().matches(""))
        {
            Toast.makeText(view.getContext(), "Fields Cannot be Empty",Toast.LENGTH_LONG).show();
            return;
        }

        //calculate result for the variables
        result = (0.5)*( Double.parseDouble(triBase.getText().toString())) * (Double.parseDouble(triHeight.getText().toString()));
        //start the intent to send the result back
        Intent myInten = new Intent(TriangleActivity.this, MainActivity.class);
        myInten.putExtra("result", result);
        ((Activity)view.getContext()).setResult(RESULT_OK, myInten);
        //exit the current activity
        finish();
    }

}
