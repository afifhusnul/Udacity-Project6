package com.example.android.udacity_project6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by NUSNAFIF on 10/13/2016.
 */

public class LocationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_activity);

        // Get Name, Desc, Image views
        TextView locationName = (TextView)findViewById(R.id.location_name);
        TextView locationDesc = (TextView)findViewById(R.id.location_desc);
        ImageView locationImg = (ImageView)findViewById(R.id.location_img);

        // Passed data in from Fragment
        Intent goIntent = getIntent();

        // Set Name and Description text
        locationName.setText(goIntent.getStringExtra("location_name"));
        locationDesc.setText(goIntent.getStringExtra("location_desc"));

        // Set Image on page
        final int imageResource = goIntent.getIntExtra("location_img", -1);
        if (imageResource!=-1){
            locationImg.setImageResource(imageResource);
        } else {
            locationImg.setVisibility(View.GONE);
        }
    }
}
