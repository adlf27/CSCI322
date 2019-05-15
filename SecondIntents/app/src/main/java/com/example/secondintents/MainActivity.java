package com.example.secondintents;
/*
Name Luis Aguinaga z1811673
Portfolio number 4 part 2
Design a simple application that will demonstrate explicit intents that return a result.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView nameTV;
    static final int REQUEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTV = findViewById(R.id.nameEditTxt);
    }
    //handle the btn click
    public void getName(View view)
    {
        //create getName
        Intent nameIntent = new Intent(MainActivity.this, NameActivity.class);
        startActivityForResult(nameIntent,REQUEST_CODE);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String returnedName;
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            returnedName = data.getStringExtra("nameID");
            nameTV.setText("Youre name is " + returnedName);
        }
    }
}
