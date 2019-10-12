package com.example.bohon003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    private static int splashTime=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable(){
            @Override
                    public void run()
            {
                Intent mainIntent=new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(mainIntent);
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                finish();
            }
        },splashTime);
    }
}
