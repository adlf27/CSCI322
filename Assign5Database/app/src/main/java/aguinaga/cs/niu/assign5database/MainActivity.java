/*          Assignment 5
name: Luis Aguinaga z1811673  csci322

purpose: this application simulates a to do list.
you can add or remove a item or a to-do task to a database.
prints out the current list on to the screen when an item is
added or remove
 */
package aguinaga.cs.niu.assign5database;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    private ArrayAdapter<String> mAdapter;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        //get data from the database
        updateUI();

    }

    //set up the menu with the add and delete buttons
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    //get with button the user pressed
    //opens the add activity or the delete activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //opens the add activity
        if(id == R.id.menu_add)
        {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivityForResult(intent,1);

        }
        //opens the delete activity
        if(id == R.id.menu_delete)
        {
            Intent intent3 = new Intent(MainActivity.this, DeleteActivity.class);
            startActivityForResult(intent3,2);

        }
        if(id == R.id.menu_delete_all)
        {
            if(db.deleteEverything())
            {
                Toast.makeText(MainActivity.this, "Deleted All the Items in the List", Toast.LENGTH_LONG).show();
                updateUI();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Could Not Delete Items in the List", Toast.LENGTH_LONG).show();

            }
        }
        return super.onOptionsItemSelected(item);
    }

    //getting the item for the user that was entered
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
                //getting the string from the add intent
                String item = data.getStringExtra("result_item");

                //adding item to the list
                addItem(item);
            }
        }
        if(requestCode == 2)
        {
            if(resultCode == RESULT_OK)
            {
                String item = data.getStringExtra("delete_item");
                //deleting the item from the list
                deleteItem(item);

            }
        }
    }
    //method to add item to the list
    public void addItem(String item)
    {
        boolean isInserted = db.insertData(item);
        //checking if the item was added to the list
        if(isInserted)
        {
            Toast.makeText(MainActivity.this, "Item: "+item+" Added to the List Successfully", Toast.LENGTH_LONG).show();
            updateUI();

        }
        else
        {
            Toast.makeText(MainActivity.this, "Item: "+item+" Could Not be added to the List", Toast.LENGTH_LONG).show();
            updateUI();
        }
    }

    //method to delete item from the list
    public void deleteItem(String item)
    {
        //deleting item from the list
        //printing success message
        if(db.delete(new String[] {item}))
        {
            Toast.makeText(MainActivity.this, "Item Deleted : " + item, Toast.LENGTH_LONG).show();
            updateUI();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Item Could not be Deleted : " + item, Toast.LENGTH_LONG).show();
            updateUI();

        }
    }
    //method to update the list with new entries
    public void updateUI()
    {
        //get the array list with the values in the database
        DatabaseHelper db = new DatabaseHelper(this);
        //get the listview to print the data
        ListView listView = findViewById(R.id.list_todo);

        if(mAdapter == null)
        {
            mAdapter = new ArrayAdapter<>(this, R.layout.item_todo, R.id.task_title, db.getData());
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
