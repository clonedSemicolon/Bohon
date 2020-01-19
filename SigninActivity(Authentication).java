package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class sign_up extends AppCompatActivity implements View.OnClickListener{
    private EditText EMAILup,PASSWORDup,NAMEup,PHONENOup;
    private TextView msgin;
    private Button signupbutton;
    private FirebaseAuth mAuth;
    private ProgressBar progressupbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("SIGN UP ACTIVITY");


        mAuth = FirebaseAuth.getInstance();

        EMAILup =(EditText) findViewById(R.id.signupemailid);
        PASSWORDup =  (EditText) findViewById(R.id.signuppasswordid);
        NAMEup = (EditText) findViewById(R.id.signupnameid);
        PHONENOup = (EditText) findViewById(R.id.signupphonenoid);
        msgin =  (TextView) findViewById(R.id.signinmsgid);
        signupbutton =  (Button) findViewById(R.id.signupbuttonid);
        progressupbar =  (ProgressBar) findViewById(R.id.signupprogreesbarid);

        msgin.setOnClickListener(this);
        signupbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signupbuttonid:
                userRegister();
                break;
            case R.id.signinmsgid:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userRegister() {
        String email = EMAILup.getText().toString().trim();
        String password = PASSWORDup.getText().toString().trim();
        String phoneno = PHONENOup.getText().toString().trim();
        String  name = NAMEup.getText().toString().trim();

        if ( email.isEmpty()) {
            EMAILup.setError("Enter an Email Address");
            EMAILup.requestFocus();
            return ;
        }
        if ( !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EMAILup.setError("Enter A valid Email");
            EMAILup.requestFocus();
            return;
        }
        if ( password.isEmpty()) {
            PASSWORDup.setError("Enter a Password");
            PASSWORDup.requestFocus();
            return ;
        }
        progressupbar.setVisibility(View.VISIBLE);
        if ( password.length() < 6) {
             PASSWORDup.setError("MINIMUM LENGTH OF PASSWORD SHOULD BE 6");
             PASSWORDup.requestFocus();
             return;
        }
        if ( name.isEmpty()) {
            NAMEup.setError("Enter a Name");
            NAMEup.requestFocus();
            return ;
        }
        if ( phoneno.isEmpty()) {
            PHONENOup.setError("Enter a Phone no");
            PHONENOup.requestFocus();
            return ;
        }


      mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
              progressupbar.setVisibility(View.GONE);
              if (task.isSuccessful()) {
                  Toast.makeText(getApplicationContext(),"Registration is Successful",Toast.LENGTH_SHORT).show();

              } else {
                   if ( task.getException() instanceof FirebaseAuthUserCollisionException) {
                       Toast.makeText(getApplicationContext(),"User is Already Registered!!",Toast.LENGTH_SHORT).show();
                   }
                   else {
                       Toast.makeText(getApplicationContext(),"Exception : "+task.getException(),Toast.LENGTH_SHORT).show();
                   }
              }
          }
      });

    }

}
