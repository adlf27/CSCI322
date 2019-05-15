package com.example.intentsporfotlio;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView myImage;
    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set the image to the instance variable
        myImage = findViewById((R.id.imgToChange));
    }
    public void openBowser(View view)
    {
        Intent bowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(bowserIntent);
    }
    public void takePicture(View view)
    {
        Intent picture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //check if the device has a camara available
        if(picture.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(picture, REQUEST_CODE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            //retrieve the image
            Bundle extras = data.getExtras();
            Bitmap bitObj = (Bitmap)extras.get("data");

            //put the bitmap to the image variable
            myImage.setImageBitmap(bitObj);
        }
    }

    public void dialNumber(View view)
    {
        Intent number = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:12345678909"));

        startActivity(number);

    }


}
