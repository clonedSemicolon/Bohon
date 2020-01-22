package com.example.bohon_final__001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_Registration extends AppCompatActivity {


    EditText name, email, phone;
    Button rbutton;
    String Sqlitequery;
    SQLiteDatabase userdatabase;
    String sname, semail, sphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__registration);

        name = findViewById(R.id.NameReg);
        email = findViewById(R.id.EmailReg);
        phone = findViewById(R.id.phonereg);
        rbutton = findViewById(R.id.UserRegbutton);



        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserReg(view);
                Intent logintent=new Intent(User_Registration.this,LoginActivity.class);
                startActivity(logintent);
            }
        });

    }

    public void UserReg(View view)
    {
        sname = name.getText().toString().trim();
        semail = email.getText().toString().trim();
        sphone = phone.getText().toString().trim();

        if ( sname.isEmpty() || semail.isEmpty() || sphone.isEmpty()) { Toast.makeText(this,"Fields Are Empty !! Please insert carefully",Toast.LENGTH_SHORT).show();
        }
        else {
            String method = "register";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, semail, sname, sphone);
        }


    }
}

