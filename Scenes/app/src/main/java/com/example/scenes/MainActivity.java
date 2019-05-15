package com.example.scenes;
/*
Name Luis Aguinaga portfolio 9 scenes
    this app hides the image but shows pieces by piece
    with a button click until the whole image is revealed
 */
import android.app.Activity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity
{
    private ViewGroup paintings;
    private Transition paintTransition;
    private Scene activeScene, passiveScene1, passiveScene2, passiveScene3;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect the viewgroup and the relative from main activitiy.xml
        paintings = findViewById(R.id.paintingLayout);

        //inflate the transition
        paintTransition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        //populate the scene
        activeScene = Scene.getSceneForLayout(paintings, R.layout.scene1, this);
        passiveScene1 = Scene.getSceneForLayout(paintings, R.layout.scene2, this);
        passiveScene2 = Scene.getSceneForLayout(paintings, R.layout.scene3, this);
        passiveScene3 = Scene.getSceneForLayout(paintings, R.layout.scene4, this);

        //make the active scene visiable
        activeScene.enter();

    }
    public void changeScene(View view)
    {

        Scene temp;
        temp = activeScene;
        activeScene = passiveScene1;
        passiveScene1 = passiveScene2;
        passiveScene2 = passiveScene3;
        passiveScene3 = temp;

        //make the new active scene visiable
        TransitionManager.go(activeScene, paintTransition);

    }
}
