package com.example.registrationandsigninforbohon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db ;
    EditText nameText, emailText, phonenoText;
    Button SignUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        nameText = (EditText) findViewById(R.id.signupnameid);
        emailText = (EditText) findViewById(R.id.signupemailid);
        phonenoText = (EditText) findViewById(R.id.signupphonenoid);
        SignUpText = (Button) findViewById(R.id.signupbuttonid);
        SignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String email = emailText.getText().toString();
                String phone = phonenoText.getText().toString();
                if (name.equals("") || email.equals("") || phone.equals("") ) {
                    Toast.makeText(getApplicationContext(), "fields Are Empty", Toast.LENGTH_SHORT).show();
                } else {
                        Boolean chkemail = db.chkemail(email);
                        if (chkemail == true) {
                            //Toast.makeText(getApplicationContext(),"check oise email",Toast.LENGTH_SHORT).show();
                            Boolean insert = db.insert(email, name, phone);
                            //Toast.makeText(getApplicationContext(),"function o duksil" + insert,Toast.LENGTH_SHORT).show();
                            if (insert == true) {
                                Intent intent = new Intent(getApplicationContext(),verificationactivity.class);
                                startActivity(intent);
                            }
                        } else
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
