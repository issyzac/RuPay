package hackathon.gsma.com.rupay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import hackathon.gsma.com.rupay.MainActivity;
import hackathon.gsma.com.rupay.R;

public class Splash extends AppCompatActivity {


    ImageView mLogo;

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mLogo = (ImageView)findViewById(R.id.img_logo);

        Glide.with(this)
                .load(R.drawable.ru_logo)
                .animate(R.anim.blink_anim)
                .into(mLogo);



        new Handler().postDelayed(new Runnable(){

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                //This method will be executed once the timer is over
                //Start your app main activity
                //check if LanguagePreference has anything if YES then we use the saved value to select the Language

                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);

                //Close the Activity
                finish();

            }
        }, SPLASH_TIME_OUT);



    }

}
