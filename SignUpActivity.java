import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myloginapp.R;

public class sign_up2 extends AppCompatActivity implements View.OnClickListener {

    public EditText nameID,emailID,phonenoID,passwordID;
    public Button button;
    MyDatabaseHelper mydatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getWritableDatabase();

        nameID = (EditText) findViewById(R.id.signupnameid);
        emailID = (EditText) findViewById(R.id.signupemailid);
        phonenoID = (EditText) findViewById(R.id.signupphonenoid);
        passwordID = (EditText) findViewById(R.id.signuppasswordid);
        button = (Button) findViewById(R.id.signupbuttonid);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameID.getText().toString();
        String email1 = emailID.getText().toString();
        String phoneno = phonenoID.getText().toString();
        String password = passwordID.getText().toString();

        if  ( v.getId() == R.id.signupbuttonid) {
            long rowID =  mydatabaseHelper.insertdata(name,email1,phoneno,password);
            if ( rowID == -1 ) {
                Toast.makeText(getApplicationContext(),"Unsuccessfully Inserted",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Row"+rowID+" is successfully inserted",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
