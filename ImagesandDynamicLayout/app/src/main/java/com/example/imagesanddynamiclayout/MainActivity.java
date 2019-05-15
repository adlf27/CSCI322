/*
luis aguinaga protfolio 7 Images and Dynamic Layout
03/18/2019

this app shows imagaes of characters and are scrollable
 */
package com.example.imagesanddynamiclayout;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.characterLayout);

        fillLayout();
    }

    private void fillLayout()
    {
        ImageButton imageBtn;
        for(int i = 0; i < CharacterInfo.description.length; i++)
        {
            //create the image button
            imageBtn = new ImageButton(this);
            //creat a cartoon objets
            Character cartoon = new Character(CharacterInfo.description[i], CharacterInfo.id[i]);
            imageBtn.setContentDescription(Character.getCharacterDescription());

            imageBtn.setImageDrawable(ResourcesCompat.getDrawable(getResources(), Character.getCharacterID(), null));

            imageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    String descrip = (String) view.getContentDescription();

                    Toast.makeText(getApplicationContext(), descrip, Toast.LENGTH_LONG).show();

                }
            });
            layout.addView(imageBtn);
        }
    }
}
