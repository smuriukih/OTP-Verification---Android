package com.example.kingajamii;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=1500;

    //variables for animation

    Animation topAnim, bottomAnim;

    //calling text and image variables
    ImageView image;
    TextView kinga, tagline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // code to hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
//calling top and bottom animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //calling the variables in main activity
        image = findViewById(R.id.logo);
        kinga=findViewById(R.id.Kinga);
        tagline=findViewById(R.id.tagline);

        //setting animation for the respective variables i.e image, kinga and tagline

        image.setAnimation(topAnim);

        kinga.setAnimation(bottomAnim);
        tagline.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //calling the next activity
                Intent intent= new Intent(MainActivity.this, Dashboard.class);

                //calling variables in activity main

                Pair[] pairs = new Pair[3];
                pairs[0]= new Pair<View,String>(image, "logo_image");
                pairs[1]= new Pair<View,String>(kinga, "kinga_text");
                pairs[2] =new Pair <View, String> (tagline, "signIn_text");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);

                    startActivity(intent,options.toBundle());
                }

                finish();


            }
        },SPLASH_SCREEN);


    }
}
