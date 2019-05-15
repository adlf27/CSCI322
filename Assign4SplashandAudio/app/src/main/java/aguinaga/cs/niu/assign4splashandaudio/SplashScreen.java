package aguinaga.cs.niu.assign4splashandaudio;
/*
splash screen. shows an intro screen for about 4 seconds them it opens main Activity
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //timer task
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        };
        //create new timer object
        Timer timer = new Timer();

        //create the scheduele
        timer.schedule(task, 4000);
    }
}
