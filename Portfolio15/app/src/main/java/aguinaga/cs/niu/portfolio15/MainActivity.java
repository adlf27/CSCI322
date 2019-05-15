package aguinaga.cs.niu.portfolio15;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private Button downloadBTN;
    private ProgressBar downloadPB;
    private TextView downloasTV, callbackTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the data members to the screen widgets
        downloadBTN = findViewById(R.id.downloadButton);

        downloadPB = findViewById(R.id.downloadProgressBar);

        downloasTV = findViewById(R.id.downloadTextView);

        callbackTV = findViewById(R.id.callbackTextView);
    }

    private class DownloadAsyncTask extends AsyncTask<Void, Integer, Void>
    {
        int progress;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            //append a message to the current content of the media textview

            callbackTV.setText(callbackTV.getText() + "\n\nLock the screen orientation");

            //lock the screen orentation
            //this allows you to ge the current screen orentation
            int currentOrientattion = getResources().getConfiguration().orientation;

            if(currentOrientattion == Configuration.ORIENTATION_PORTRAIT)
            {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            else
            {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            //append another message
            callbackTV.setText(callbackTV.getText()+"\nInvole onPreExecute");

            //init the progress
            progress = 0;

            downloasTV.setText(R.string.download_start_label);

            //append some
            callbackTV.setText(callbackTV.getText()+"\nCompleted onPreExecute");

            callbackTV.setText(callbackTV.getText()+"\nInvoke doInBackgroud");

            callbackTV.setText(callbackTV.getText()+"\nDoing Background work.....");
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            while(progress < 100)
            {
                progress += 2;

                //display the progress
                publishProgress(progress);

                //delay
                SystemClock.sleep(300);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);

            //update the progress bar
            downloadPB.setProgress(values[0]);

            //update the text view for downloading
            downloasTV.setText("downloading " + values[0] + "%");

        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            callbackTV.setText(callbackTV.getText() + "\nCompleted Background work");
            callbackTV.setText(callbackTV.getText() + "\ninvoke onPosExecute");

            //complete the download message
            downloasTV.setText("Download Completed");
        }
    }

    //download button
    public  void startDownload(View view)
    {
        //disable the download button
        downloadBTN.setEnabled(false);

        //create the asynctask object
        DownloadAsyncTask task = new DownloadAsyncTask();

        //star the asynctask
        task.execute();
    }
    //reset button
    public void doReset(View view)
    {
        downloasTV.setText(R.string.download_start_label);
        callbackTV.setText(R.string.callbacks_label);

        //reset the progress bar
        downloadPB.setProgress(0);

        //unlock the screen orentation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

    }

}



