package com.kimhyojung.android.materialdesign_propertyanimation_windmile;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button windmileButton;

    ImageButton imagebutton1;
    ImageButton imagebutton2;
    ImageButton imagebutton3;
    ImageButton imagebutton4;

    RelativeLayout ground;

    int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        windmileButton = (Button)findViewById(R.id.windmilebutton);

        imagebutton1 = (ImageButton)findViewById(R.id.imageButton1);
        imagebutton2 = (ImageButton)findViewById(R.id.imageButton2);
        imagebutton3 = (ImageButton)findViewById(R.id.imageButton3);
        imagebutton4 = (ImageButton)findViewById(R.id.imageButton4);


        ground = (RelativeLayout)findViewById(R.id.ground);
    }

    public void windMile(View v){
        if(flag==1) {
            move(imagebutton1, -imagebutton1.getWidth() / 2, -imagebutton1.getHeight() / 2);
            move(imagebutton2, imagebutton2.getWidth() / 2, -imagebutton2.getHeight() / 2);
            move(imagebutton3, -imagebutton3.getWidth() / 2, imagebutton3.getHeight() / 2);
            move(imagebutton4, imagebutton4.getWidth() / 2, imagebutton4.getHeight() / 2);
            spin(ground, 360);
            windmileButton.setText("Combine");
            flag=0;
        }else{
            spin(ground, 0);
            combine(imagebutton1,0,0);
            combine(imagebutton2,0,0);
            combine(imagebutton3,0,0);
            combine(imagebutton4,0,0);
            flag=1;
            windmileButton.setText("Windmile");
        }

    }

    public void move(View player, int distancex, int distancey){
        ObjectAnimator ani1 = ObjectAnimator.ofFloat(player,"translationX", distancex);
        ObjectAnimator ani2 = ObjectAnimator.ofFloat(player,"translationY", distancey);

        AnimatorSet aniset = new AnimatorSet();
        aniset.setDuration(2000);
        aniset.playTogether(ani1, ani2);
        aniset.start();
    }


    public void spin(View player, int rotateAngle){
        ObjectAnimator ani = ObjectAnimator.ofFloat(player, "rotation", rotateAngle);
        ani.setDuration(3000);
        ani.start();
    }

    public void combine(View player, int distancex, int distancey) {
        move(imagebutton1, 0, 0);
        move(imagebutton2, 0, 0);
        move(imagebutton3, 0, 0);
        move(imagebutton4, 0, 0);
    }
}
