package aguinaga.cs.niu.assign5database;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity
{
    private DatabaseHelper db;
    private EditText addData;
    private Button BTNadd;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //get
        db = new DatabaseHelper(this);

        BTNadd = findViewById(R.id.buttonADD);

        addData = findViewById(R.id.addET);

        addData.requestFocus();

        //onclick listener to add data to the list
        BTNadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String item = addData.getText().toString();
                //check if the user enter something in the data field
                if(item.length() != 0)
                {
                    Intent intent = new Intent();
                    intent.putExtra("result_item", item);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else
                {
                    Toast.makeText(AddActivity.this, "Please Enter Item into text field", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void goBack(View view)
    {
        finish();
    }

}
