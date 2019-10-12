package com.example.bohon003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button confirmationcodebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        confirmationcodebutton= (Button)findViewById(R.id.SendVerificationCodeButton);
        confirmationcodebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfirmationActivity();
            }
        });

    }

    public void openConfirmationActivity()
    {
        Intent confirmationintent=new Intent(this,ConfirmationCodeActivity.class);
        startActivity(confirmationintent);
    }
}

