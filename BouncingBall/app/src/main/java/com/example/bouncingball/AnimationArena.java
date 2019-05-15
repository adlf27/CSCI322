package com.example.bouncingball;

import android.graphics.Canvas;

public class AnimationArena
{
    private Ball myBall;
    //contructor creates a new ball object
    public AnimationArena()
    {
        myBall = new Ball();
    }
    //method to update the location if the ball
    public void update(int width, int height)
    {
        myBall.move(0,0,width,height);
    }

    //method to draw
    public void draw(Canvas canvas)
    {
        //set the background color of the canvas
        canvas.drawRGB(156,174,216);

        myBall.draw(canvas);
    }
}
