package com.example.bouncingball;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class BounceThread extends Thread
{
    private SurfaceHolder surfaceHolder;

    private AnimationArena animationArena;

    private boolean isRunnig;

    public BounceThread(SurfaceHolder sh)
    {
        surfaceHolder = sh;
        //initialize isRunningboolean
        isRunnig = true;
        //create a animation arean object
        animationArena = new AnimationArena();
    }

    public void run()
    {
        try
        {
            while(true)
            {
                //create a canvas object and lock it. nothing else can change it
                Canvas canvas = surfaceHolder.lockCanvas();
                //update the ball location
                animationArena.update(canvas.getWidth(), canvas.getHeight());
                animationArena.draw(canvas);

                //unlock the canvas to update
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
        catch(NullPointerException n)
        {
            n.printStackTrace();
        }
    }
    public void endBounce()
    {
        isRunnig = false;
    }
}
