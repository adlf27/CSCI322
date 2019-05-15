package com.example.secondintents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends Activity {

    private EditText nameET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        nameET = findViewById(R.id.nameEditTxt);
    }
    public void goBack(View view)
    {
        String nameInput;
        //get the date from thr terxt fild
        nameInput = nameET.getText().toString();

        // get the inten that was used to name activty
        Intent intent;
        intent = getIntent();

        //put the name from the edittext into the intne obj
        intent.putExtra("nameID", nameInput);

        //set a good result
        ((Activity)view.getContext()).setResult(RESULT_OK, intent);

        //go back to the main activiy
        finish();

    }
}
