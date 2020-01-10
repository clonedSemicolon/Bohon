package com.example.bohon_final__001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.varunest.sparkbutton.SparkButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SparkButton sparkButton=(SparkButton)findViewById(R.id.spark_button);


        sparkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Runnable r=new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    }
                };

                view.postDelayed(r,3000);
            }
        });



    }



}
