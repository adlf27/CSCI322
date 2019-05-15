package com.example.exam1;
/*             Exam 1
 Name: Luis Aguinaga z1811673
 Due : 03/25/2019
 Purpose: this application will be able to calculate the area of various shapes.
 the user selects which shape to calculate the area based on radio buttons.
 then is opens up another activity where the user can enter the variables to calculate
 with the corresponding formula
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    RadioGroup areaGroup;
    double triangleResult;
    int REQUEST_CODE =  1;
    TextView resultTV;
    String resultString = "";
    boolean selectedTri = false,
            selectedCir = false,
            selectedEllip = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = findViewById(R.id.areaTextView);
        areaGroup = findViewById(R.id.shapeGroup);

        //set on property to get which radio button the user clicked
        areaGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                if(R.id.circleRadioButton == i)
                {
                    selectedCir = true;
                }
                else if(R.id.ellipseRadioButton == i)
                {
                    selectedEllip = true;

                }
                else if(R.id.triangleRadioButton == i)
                {
                    selectedTri = true;

                }

            }
        });

    }

    //on click method for the button
    public void calculateShape(View view)
    {
        //depending of which radio button the user pressed
        //it opens the activity base on the selection
        if(selectedCir)
        {
            Intent CircleInten = new Intent(MainActivity.this, CircleActivity.class);
            startActivityForResult(CircleInten, REQUEST_CODE);
            selectedCir = false;
        }
        else if(selectedEllip)
        {
            Intent ellipseInten = new Intent(MainActivity.this, EllipseActivity.class);
            startActivityForResult(ellipseInten, REQUEST_CODE);
            selectedEllip = false;
        }
        else if(selectedTri)
        {
            Intent triangleInten = new Intent(MainActivity.this, TriangleActivity.class);
            startActivityForResult(triangleInten, REQUEST_CODE);
            selectedTri = false;
        }
        else   //else if no option was selected toast message will appear prompting to select shape
        {
            Toast.makeText(view.getContext(), "Please select a Shape to Calculate: ", Toast.LENGTH_LONG).show();
            return;
        }
    }
    //method to get the returned result from the activities
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            triangleResult = data.getDoubleExtra("result", REQUEST_CODE);
            resultTV.setText(String.format("%.4f",triangleResult));

        }
    }

}
