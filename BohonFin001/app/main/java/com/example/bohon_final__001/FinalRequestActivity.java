package com.example.bohon_final__001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalRequestActivity extends AppCompatActivity {


    ArrayList<String>weightarray;
    ArrayAdapter<String>weight_adapter;

    ArrayList<String>footarray;
    ArrayAdapter<String>footarrayadapter;

    Spinner wspinner,fspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_request);

        weightarray=new ArrayList<>();
        weightarray.add("3 tons");
        weightarray.add("5 tons");
        weightarray.add("10 tons");



        footarray=new ArrayList<>();
        footarray.add("3 feets");
        footarray.add("5 feets");
        footarray.add("7 feets");



        wspinner=findViewById(R.id.weightspinner);
        fspinner=findViewById(R.id.feetspinner);




        TextView sourceloc;
        sourceloc=findViewById(R.id.sourceloc);
        String pickupdis=getIntent().getStringExtra("pickd");
        String pickuparea=getIntent().getStringExtra("picka");
        sourceloc.setText(pickupdis+",\n"+pickuparea);

        TextView desloc;
        desloc=findViewById(R.id.destinationloc);
        String desdis=getIntent().getStringExtra("desd");
        String desarea=getIntent().getStringExtra("desa");
        desloc.setText(desdis+",\n"+desarea);

        TextView transport;
        transport=findViewById(R.id.typevehicle);
        String transporttype=getIntent().getStringExtra("vtype");
        transport.setText(transporttype);


        weight_adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,weightarray);
        wspinner.setAdapter(weight_adapter);

        footarrayadapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,footarray);
        fspinner.setAdapter(footarrayadapter);







    }
}
