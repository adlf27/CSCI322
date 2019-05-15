package com.example.portfolio12threads;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView countTV;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTV = findViewById(R.id.countID);
        //initialize counter
        counter = 0;

        //creating the thread, pass a runnable object
        Thread myThread = new Thread(countNumber);
        //start execute
        myThread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        counter = 0;
    }

    private Runnable countNumber = new Runnable() {
        private static final int DELAY = 1000;
        @Override
        public void run()
        {
            while(true)
            {
                //increment the counter
                counter++;

                try
                {
                    Thread.sleep(DELAY);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                threadHandler.sendEmptyMessage(0);
            }
        }
    };

    public Handler threadHandler = new Handler()
    {
        //code the handlr message so the UI thread knows what to do
         public void handleMessage(Message message)
         {
             countTV.setText(counter.toString());
         }


    };
}
