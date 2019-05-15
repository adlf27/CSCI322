package com.example.splashandaudio;
/*
name Luis Aguinaga Splash Screens and Audio

this app shows a splash screen for about 2 seconds then it goes to the main
page to show which song you want to hear. the song plays based on a button click.
it starts to play and pauses the other song
 */
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button ukeleleBtn, drumsBtn;
    private MediaPlayer ukeleleMP, drumsMP;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect the buttons to the screen
        ukeleleBtn = findViewById(R.id.ukeleBTN);
        drumsBtn = findViewById(R.id.drumsBTN);

        //create the media player and connect with the audio file
        ukeleleMP = new MediaPlayer();
        ukeleleMP = MediaPlayer.create(this, R.raw.ukulele);

        drumsMP = new MediaPlayer();
        drumsMP = MediaPlayer.create(this, R.raw.drums);

    }
    public void playDrums(View view)
    {
          if(drumsMP.isPlaying())
          {
              drumsMP.pause();
              drumsBtn.setText("Play the Drums");
          }
          else if(ukeleleMP.isPlaying())
              {
                  ukeleleMP.pause();
                  ukeleleBtn.setText("Play the Ukelele");
              }
          else
              {
              drumsMP.start();
              drumsBtn.setText("Pause the Drums");
          }

    }

    public void playUkele(View view)
    {
        if(ukeleleMP.isPlaying())
        {
            ukeleleMP.pause();
            ukeleleBtn.setText("Play the Ukelele");
        }
        else if(drumsMP.isPlaying())
            {
                drumsMP.pause();
                drumsBtn.setText("Play the Drums");
            }
        else
            {
            //play the ukelele mp3
            ukeleleMP.start();
            ukeleleBtn.setText("Pause the ukelele");
        }
    }



}
