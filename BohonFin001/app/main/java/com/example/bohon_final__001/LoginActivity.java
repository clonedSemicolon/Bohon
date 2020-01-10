package com.example.bohon_final__001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    private EditText LoginPhone;
    private Button LoginConfirmButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginPhone = (EditText) findViewById(R.id.PhoneNumberLogin);
        LoginConfirmButton = (Button) findViewById(R.id.Loginbutton);
        Button registerbutton=(Button)findViewById(R.id.buttontest);
        Button test=(Button)findViewById(R.id.buttontest);

        LoginConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=LoginPhone.getText().toString();
                if(number.isEmpty() || number.length()<11)
                {
                    LoginPhone.setError("Valied Number Required");
                    LoginPhone.requestFocus();
                }

                String PhoneNumber="+88"+number;
                Intent firstintent=new Intent(LoginActivity.this,CodeConfirm.class);
                firstintent.putExtra("PhoneNumber",PhoneNumber);
                startActivity(firstintent);
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,User_Registration.class));
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,Current_Location.class));
            }
        });




    }
}
