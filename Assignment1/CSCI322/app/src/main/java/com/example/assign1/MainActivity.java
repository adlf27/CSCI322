/*         Assignment 1
Name: Luis Agiunaga z1811673
Due:  02/08/2019
Purpose:  this App displays a message and when the user clicks on
         a button it switches back and forth between messages

 */
package com.example.assign1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    //instance variables
    private TextView myText1;
    private Button myButton;
    private boolean hasCliked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connecting the variables to the widgets in the app
        myButton = findViewById(R.id.button);
        myText1 = findViewById(R.id.introMsg);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking if the button has been clicked
                if(!hasCliked) {
                    //displays the message
                    myText1.setText(getResources().getString(R.string.byeMsg));
                    hasCliked = true;
                }
                else
                {
                    //displays the other message
                    myText1.setText(getResources().getString(R.string.introMsg));
                    hasCliked = false;
                }
            }
        });



    }
}
