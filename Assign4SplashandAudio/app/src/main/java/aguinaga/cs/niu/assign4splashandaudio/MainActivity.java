package aguinaga.cs.niu.assign4splashandaudio;
/*
name: Luis Aguinaga   CSCI322
due:  04/15/2019
purpose:    Assignment 4
this application shows six different images and when they are cliked a song corresponding to the
image starts to play
 */
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    //media player variables
    MediaPlayer avengersMP, starwarsMP, mipMP, simpsonsMP, gotMP, harryMP;
    MediaPlayer temp;
    //boolean current = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the corresponding mp3 with media player object
        avengersMP = new MediaPlayer();
        avengersMP = MediaPlayer.create(this, R.raw.avengers_theme);

        starwarsMP = new MediaPlayer();
        starwarsMP = MediaPlayer.create(this, R.raw.star_wars_theme);

        mipMP = new MediaPlayer();
        mipMP = MediaPlayer.create(this, R.raw.mission_imposible);

        simpsonsMP = new MediaPlayer();
        simpsonsMP = MediaPlayer.create(this, R.raw.theme_los_simpson);

        gotMP = new MediaPlayer();
        gotMP = MediaPlayer.create(this, R.raw.game_of_thrones);

        harryMP = new MediaPlayer();
        harryMP = MediaPlayer.create(this, R.raw.harry_potter);

        temp = new MediaPlayer();


    }
    //method to handle the got picture
    public void playGot(View view)
    {
        //calls the mehtod to start playing the song
       playingMP3(gotMP);
    }
    //method to handle the avengers picture
    public void playAvengers(View view)
    {
        //calls the method to start playing the song
        playingMP3(avengersMP);
    }
    //method to handle the simpsons picture
    public void playSimpsons(View view)
    {
        //calls the method to start playing the song
        playingMP3(simpsonsMP);
    }
    //method to handle the starwars picture
    public void playStarWars(View view)
    {
        //calls the method to start playing the song
        playingMP3(starwarsMP);
    }
    //method to handle the mission impposible picture
    public void playMIP(View view)
    {
        //calls the method to start playing the song
       playingMP3(mipMP);
    }
    //method to handle the harry potter picture
    public void playHarry(View view)
    {
        //calls the method to start playing the song
       playingMP3(harryMP);

    }
//this method takes in a media player object as an argumnet
    //checks if the sing is playing or pause
    //starts the song
    public void playingMP3(MediaPlayer mp)
    {
        if(mp.isPlaying()) {
            mp.pause();
        }
        else if(temp.isPlaying())
        {
            temp.pause();
            mp.start();
            temp = mp;

        }
        else{
            mp.start();
            temp = mp;
            }
    }

}
