
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText nameText,emailText,phoneText;
    String name,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (EditText) findViewById(R.id.signupnameid);
        emailText = (EditText)findViewById(R.id.signupemailid);
        phoneText = (EditText) findViewById(R.id.signupphonenoid);


    }
    
   public void userReg(View view) {
        name = nameText.getText().toString();
        email = emailText.getText().toString();
        phone = phoneText.getText().toString();

        if ( name.isEmpty() || email.isEmpty() || phone.isEmpty()) { Toast.makeText(this,"Fields Are Empty !! Please insert carefully",Toast.LENGTH_SHORT).show();
        }
        else {
            String method = "register";
            BackgroundTask backgroundTask = new BackgroundTask(this);
             backgroundTask.execute(method, email, name, phone);
        }

    }
}
