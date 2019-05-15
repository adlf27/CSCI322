package com.example.inclasscalculatorapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    //instamce variables
    private EditText number1;
    private EditText number2;
    private TextView answerTV;
    private Button addButtton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button clearButton;
    private Button divideButton;

    private Integer num1,num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the java variable to the widgets on the screen
        number1 = findViewById(R.id.num1);
        number2 = findViewById(R.id.num2);
        addButtton = findViewById(R.id.addBtn);
        clearButton = findViewById(R.id.clearBtn);
        answerTV = findViewById(R.id.result);
        subtractButton = findViewById(R.id.subtractBtn);
        multiplyButton = findViewById(R.id.multiplyBtn);
        divideButton = findViewById(R.id.divideBtn);

        //handle the division button
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check for empty fields
                if(number1.getText().toString().matches("") || number2.getText().toString().matches(""))
                {
                    //display the error msg and exit the onClick lisitener
                    Toast.makeText(view.getContext(), "Fields Cannot be Empty",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(number2.getText().toString().matches("0"))
                {
                    Toast.makeText(view.getContext(),"Cannot Divide by Zero", Toast.LENGTH_LONG).show();
                    return;
                }
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());

                //add the two values
                result = num1 / num2;

                //print the result to the screen
                answerTV.setText(result.toString());
            }
        });
        //handle the multiply button
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check for empty fields
                if(number1.getText().toString().matches("") || number2.getText().toString().matches(""))
                {
                    //display the error msg and exit the onClick lisitener
                    Toast.makeText(view.getContext(), "Fields Cannot be Empty",Toast.LENGTH_LONG).show();
                    return;
                }
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());

                //add the two values
                result = num1 * num2;

                //print the result to the screen
                answerTV.setText(result.toString());
            }
        });

        //lisinet for the subtract button
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check for empty fields
                if(number1.getText().toString().matches("") || number2.getText().toString().matches(""))
                {
                    //display the error msg and exit the onClick lisitener
                    Toast.makeText(view.getContext(), "Fields Cannot be Empty",Toast.LENGTH_LONG).show();
                    return;
                }
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());

                //add the two values
                result = num1 - num2;

                //print the result to the screen
                answerTV.setText(result.toString());
            }
        });

        //handle the addition to be clicked

        addButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //check for empty fields
                if(number1.getText().toString().matches("") || number2.getText().toString().matches(""))
                {
                    //display the error msg and exit the onClick lisitener
                    Toast.makeText(view.getContext(), "Fields Cannot be Empty",Toast.LENGTH_LONG).show();
                    return;
                }
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());

                //add the two values
                result = num1 + num2;

                //print the result to the screen
                answerTV.setText(result.toString());
            }
        });
        //function for the clear button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number1.setText("");
                number2.setText("");
                answerTV.setText("");
            }
        });

    }
}
