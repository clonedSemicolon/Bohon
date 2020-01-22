package com.example.bohon_final__001;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SqlitemainActivity extends AppCompatActivity {
    Spinner pickupspinner1,pickupspinner2,destspinner1,destspinner2;
    Button selectbtn;
    EditText inputLabel;


    String pickdistrict,pickarea,destdistrict,destarea,vehicletype;

    ArrayList<String>disarray;
    ArrayAdapter<String>disarray_adapter;

    ArrayList<String>sylhet,moulovibazar,sunamgonj,habiganj;
    ArrayAdapter<String>area;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlitemain);


        pickupspinner1 = (Spinner)findViewById(R.id.pickupspinner1);
        pickupspinner2 = (Spinner)findViewById(R.id.pickupspinner2);

        destspinner1=(Spinner)findViewById(R.id.destinationspinner1);
        destspinner2=(Spinner)findViewById(R.id.destinationspinner2);

        selectbtn=findViewById(R.id.selectbutton);

        String vehicletype=getIntent().getStringExtra("vehicleType");
        String phoneno=getIntent().getStringExtra("phoneno");

        disarray=new ArrayList<>();
        disarray.add("Sylhet");
        disarray.add("Sunamgonj");
        disarray.add("Moulovibazar");
        disarray.add("Habiganj");

        disarray_adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,disarray);
        pickupspinner1.setAdapter(disarray_adapter);
        destspinner1.setAdapter(disarray_adapter);


        sylhet=new ArrayList<>();
        sylhet.add("Sylhet Sadar");
        sylhet.add("Dakshin Surma");
        sylhet.add("Moglabazar");
        sylhet.add("Kanaighat");
        sylhet.add("Bishwanath");


        sunamgonj=new ArrayList<>();
        sunamgonj.add("Sunamganj Sadar");
        sunamgonj.add("Chhatak");
        sunamgonj.add("Jagannathpur");
        sunamgonj.add("Jamalganj");
        sunamgonj.add("Derai");



        moulovibazar=new ArrayList<>();
        moulovibazar.add("Barlekha");
        moulovibazar.add("Kulawra");
        moulovibazar.add("Moulovibazar Sadar");
        moulovibazar.add("Rajnagar");
        moulovibazar.add("Sreemongol");




        habiganj=new ArrayList<>();
        habiganj.add("Ajmiriganj");
        habiganj.add("Baniachang");
        habiganj.add("Bahubal");
        habiganj.add("Chunarughat");
        habiganj.add("Habiganj Sadar");




        pickupspinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0)
                {
                    area=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,sylhet);

                }

                if(i==1)
                {
                    area=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,sunamgonj);

                }

                if(i==2)
                {
                    area=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,moulovibazar);

                }

                if(i==3)
                {
                    area=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,habiganj);

                }


                pickupspinner2.setAdapter(area);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        destspinner1.setOnItemSelectedListener(
        new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    area=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,sylhet);
                }

                if(i==1)
                {
                    area=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,sunamgonj);
                }

                if(i==2)
                {
                    area=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,moulovibazar);
                }

                if(i==3)
                {
                    area=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,habiganj);
                }


                destspinner2.setAdapter(area);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });








        selectbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                pickdistrict=pickupspinner1.getSelectedItem().toString();
                pickarea=String.valueOf(pickupspinner2.getSelectedItem());
                destdistrict=destspinner1.getSelectedItem().toString();
                destarea=destspinner2.getSelectedItem().toString();
                Intent submissionintent=new Intent(SqlitemainActivity.this,FinalRequestActivity.class);
                submissionintent.putExtra("pickd",pickdistrict);
                submissionintent.putExtra("picka",pickarea);
                submissionintent.putExtra("desd",destdistrict);
                submissionintent.putExtra("desa",destarea);
                submissionintent.putExtra("vtype",vehicletype);
                submissionintent.putExtra("ptype",phoneno);
                startActivity(submissionintent);
            }
        });








    }



}