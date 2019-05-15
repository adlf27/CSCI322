package aguinaga.cs.niu.portfolio15b;

import android.os.AsyncTask;
import android.util.Log;

import aguinaga.cs.niu.portfolio15b.MainActivity;

public class TestTask extends AsyncTask<Integer, Void, String>
{
    private MainActivity activity;

    public TestTask(MainActivity activity)
    {
        Log.w("MainActivty", "Inside the Constructor");

        this.activity = activity;
    }

    @Override
    protected String doInBackground(Integer... integers)
    {
        Log.w("MainActivity", "Inside the DoInBackgour method");

        String displayStr = new String("Youre favorite number is " + integers[0] + "\nChanged by asyncatsk");

        return displayStr;
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        activity.updateView(s);
    }
}
