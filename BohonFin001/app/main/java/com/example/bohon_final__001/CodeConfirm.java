package com.example.bohon_final__001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class CodeConfirm extends AppCompatActivity {


    EditText Otpverify;
    int s;
    private String VerificationCode;
    Button confirmbutton,test;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_confirm);

        Otpverify = (EditText) findViewById(R.id.ConfirmCode);
        test=(Button)findViewById(R.id.testbutton);
        mAuth= FirebaseAuth.getInstance();
        String PhoneNumber = getIntent().getStringExtra("PhoneNumber");


        SendVerificationCode(PhoneNumber);
        
        confirmbutton=(Button)findViewById(R.id.ConfirmButton);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CodeConfirm.this,SubmissionActivity.class));
            }
        });


        
        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code=Otpverify.getText().toString().trim();

                if(code.isEmpty() || code.length()<6)
                {
                    Otpverify.setError("Enter the OTP properly");
                    Otpverify.requestFocus();
                    return;
                }
                Verifycode(code);
            }
        });
        
        



    }

    private void Verifycode(String code) {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(VerificationCode,code);
        Signin(credential);

    }

    private void Signin(PhoneAuthCredential credential) {

        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Intent WorkingSwitch=new Intent(CodeConfirm.this,Current_Location.class);
                    WorkingSwitch.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(WorkingSwitch);
                }

            }
        });

    }

    private void SendVerificationCode(String Number) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                Number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code=phoneAuthCredential.getSmsCode();
            if(code!=null)
            {
                Verifycode(code);
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(CodeConfirm.this,e.getMessage(),Toast.LENGTH_LONG).show();

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            VerificationCode=s;
        }
    };

}

