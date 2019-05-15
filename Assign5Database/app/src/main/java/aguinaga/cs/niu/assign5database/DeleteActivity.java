package aguinaga.cs.niu.assign5database;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class DeleteActivity extends AppCompatActivity
{
    private DatabaseHelper db;
    private ArrayAdapter<String> mAdapter;
    private ListView listView;
    private RadioButton radiobutton;
    private ArrayList<String> values;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        values = new ArrayList<>();
        //initialize database
        db = new DatabaseHelper(this);

        //connect the radio button
        radiobutton = findViewById(R.id.delete_select);
        //connect the list view
        listView = findViewById(R.id.list_delete);
        //print out the list to the screen
        updateUI();


    }

    public void deleteItem(View view)
    {
        View parent = (View) view.getParent();
        TextView data = parent.findViewById(R.id.task_delete);
        String item = String.valueOf(data.getText());
        Toast.makeText(DeleteActivity.this, "Item Deleted : " + item, Toast.LENGTH_LONG).show();
        //passing back the item to delete
        Intent intent = new Intent();
        intent.putExtra("delete_item", item);
        setResult(RESULT_OK,intent);
        //updateUI();
        finish();

    }
    //exits the activity with click of the back button
    public void goBack(View view)
    {
        finish();
    }

    //updates the screen with all the entries in the list
    public void updateUI()
    {
        values = db.getData();
        //get the array list with the values in the database

        if(mAdapter == null)
        {
            mAdapter = new ArrayAdapter<>(this, R.layout.item_delete, R.id.task_delete, values);
            listView.setAdapter(mAdapter);
        }
       else
        {
            mAdapter.clear();
            mAdapter.addAll(db.getData());
            mAdapter.notifyDataSetChanged();
        }
    }
}
