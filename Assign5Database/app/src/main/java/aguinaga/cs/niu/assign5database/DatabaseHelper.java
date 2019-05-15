package aguinaga.cs.niu.assign5database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "ItemDatabase.db";
    private static final String TABLE_NAME = "item_data";
    private static final String COL0 = "ID";
    private static final String COL1 = "NAME";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //query builder to create table in the database
        String query = "create table " +TABLE_NAME+ " ("+ COL0+" INTEGER primary Key autoincrement, " + COL1+ " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String queryUpdate = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(queryUpdate);

    }

    //method to insert an item to the database
    public boolean insertData(String name)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1, name);

        long result = db.insert(TABLE_NAME, null , contentValues);
        db.close();

        if(result == -1) {

            return false;
        }
        else
            return true;


    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return  res;

    }

    //gets the data from the database and populates it in the arraylist
    //prints the list out on the main activity
    public ArrayList<String> getData()
    {
        ArrayList<String> myItems = new ArrayList<>();
        Cursor res = getAllData();
        if(res.getCount() == 0)
        {
            //show the empty database
        }
        else
        {
            //add the items in the database to the array list

            while(res.moveToNext()) {
                myItems.add(res.getString(1));

            }

        }
        res.close();
        return myItems;
    }

    public boolean delete(String[] name)
    {
        //open database connection
        SQLiteDatabase db = this.getWritableDatabase();
        //delete query
        long id = db.delete(TABLE_NAME, "NAME = ?", name);
        db.close();

        if(id == -1)
            return false;
        else
            return true;
    }

    public boolean deleteEverything()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //deleting all the records from the database
        long id = db.delete(TABLE_NAME, null, null);
        db.close();

        if(id == -1 )
            return false;
        else
            return true;

    }



}
