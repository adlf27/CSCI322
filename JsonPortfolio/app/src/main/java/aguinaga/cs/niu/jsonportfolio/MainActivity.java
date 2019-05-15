package aguinaga.cs.niu.jsonportfolio;

import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<State> stateList = new ArrayList<>();
    private ArrayAdapter stateArrayAdapter;
    private ListView stateLV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stateLV = findViewById(R.id.stateListView);

        stateArrayAdapter = new StateArrayAdapter(this, stateList);
        //associate the adapter with the list
        stateLV.setAdapter(stateArrayAdapter);

    }

    public void getData(View view)
    {
        String urlString = getString(R.string.web_url);
        try
        {
            URL url = new URL(urlString);
            //create the async task
            StateTask st = new StateTask();

            //start the asynctask
            st.execute(url);
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }

    //method to convert JSon into a spinner
    private void convertToJSon(JSONObject states)
    {
        //clear the list
        stateList.clear();

        try
        {
            JSONArray list = states.getJSONArray("places");
            //loop to parse the json into the list
            for(int i = 0; i < list.length(); i++)
            {
                //retrieve a single state object from the object
                JSONObject stateObj = list.getJSONObject(i);

                //add the state to the list
                stateList.add(new State(stateObj.getString("Place"), stateObj.getInt("Number")));
            }

        }
        catch(JSONException jse)
        {
            jse.printStackTrace();
        }

    }
    //inner class asynctask
    private class StateTask extends AsyncTask<URL, String, JSONObject>
    {
        @Override
        protected JSONObject doInBackground(URL... urls)
        {
            HttpURLConnection connect = null;

            try
            {
                //try to connect to the specified url
                connect = (HttpURLConnection)urls[0].openConnection();

                int requestCode = connect.getResponseCode();
                //check if the connection was a success
                if(requestCode == HttpURLConnection.HTTP_OK)
                {
                    //read the information from the webpage - line by line
                    StringBuilder builder = new StringBuilder();
                    try
                    {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                        String line;
                        while((line = reader.readLine()) != null)
                        {
                            builder.append(line);
                        }
                    }
                    catch(IOException e)
                    {
                        publishProgress("Connection Error: input");
                        e.printStackTrace();

                    }
                    return new JSONObject((builder.toString()));
                }
                else
                {
                    publishProgress("Connection Error: bad URL");
                }
            }
            catch(Exception e)
            {

                publishProgress("Connection Error: Bad URL 2");
                e.printStackTrace();
            }
            finally
            {
                connect.disconnect();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values)
        {
            Toast.makeText(MainActivity.this, values[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject)
        {
            convertToJSon(jsonObject);

            //set up the array adapter
            stateArrayAdapter.notifyDataSetChanged();

            stateLV.smoothScrollByOffset(0);
        }
    }

}
