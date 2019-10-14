package com.example.bohon003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button signupbutton;
    private Button forgotpasswordbutton,loginbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        signupbutton=(Button) findViewById(R.id.Signupbutton);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistrationActivity();
            }
        });

        forgotpasswordbutton=(Button) findViewById(R.id.ForgetPasswordButton);
        forgotpasswordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgetPasswordActivity();
            }
        });

        loginbutton=(Button)findViewById(R.id.Loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapActivity();
            }
        });
    }

    public void openRegistrationActivity()
    {
        Intent intent=new Intent(this,RegistrationActivity.class);
        startActivity(intent);

    }

    public void openForgetPasswordActivity()
    {
        Intent intent1=new Intent(this,ForgetPasswordActivity.class);
        startActivity(intent1);

    }

    public void openMapActivity()
    {
        Intent mapintent=new Intent(this,mapviewActivity.class);
        startActivity(mapintent);
    }

    FirebaseDatabase database=FirebaseDatabase.getInstance();
}


