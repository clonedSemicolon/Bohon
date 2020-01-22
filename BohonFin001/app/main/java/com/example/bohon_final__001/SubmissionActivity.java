package com.example.bohon_final__001;



import android.app.Activity;
import android.content.Intent;
import com.example.bohon_final__001.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SubmissionActivity extends AppCompatActivity {

    String[] spinnerTitles;
    String[] spinnerPopulation;
    int[] spinnerImages;
    Spinner mSpinner;
    private boolean isUserInteracting;
    Button vehicleselectbutton;
    String VehicleType,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        vehicleselectbutton=findViewById(R.id.vehicleselectbutton);

        mSpinner = (Spinner) findViewById(R.id.spinner);
        spinnerTitles = new String[]{"Pickup", "Truck"};
        spinnerPopulation = new String[]{"2 tons","10 tons"};
        spinnerImages = new int[]{R.drawable.pickup
                , R.drawable.truck
                };

        CustomAdapter mCustomAdapter = new CustomAdapter(SubmissionActivity.this, spinnerTitles, spinnerImages, spinnerPopulation);
        mSpinner.setAdapter(mCustomAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isUserInteracting) {
                    Toast.makeText(SubmissionActivity.this, spinnerTitles[i], Toast.LENGTH_SHORT).show();
                    VehicleType=spinnerTitles[i];
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        phone=getIntent().getStringExtra("phoneno");

        vehicleselectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationactivityintent = new Intent(SubmissionActivity.this, SqlitemainActivity.class);
                locationactivityintent.putExtra("vehicleType", VehicleType);
                locationactivityintent.putExtra("phoneno",phone);
                startActivity(locationactivityintent);
            }
        });




    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        isUserInteracting = true;
    }


}