package com.example.bouncingball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BounceSurfaceView extends SurfaceView implements SurfaceHolder.Callback
{
    private BounceThread bounceThread;

    public BounceSurfaceView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        //create surface holder
        SurfaceHolder surfaceHolder = getHolder();

        surfaceHolder.addCallback(this);

        bounceThread = new BounceThread(surfaceHolder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder)
    {
        //start the bounce thread
        bounceThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2)
    {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder)
    {
        //stop the execution of the surface thread
        bounceThread.endBounce();

        //nullify the thread
        Thread tempThread = bounceThread;

        bounceThread = null;

        tempThread.interrupt();

    }
}
