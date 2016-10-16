package com.example.android.udacity_project6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by NUSNAFIF on 10/13/2016.
 */

public class HospitalityFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Hostpitality List
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                new Location(getResources().getString(R.string.hyatt_header), getResources().getString(R.string.hyatt_desc), R.drawable.hyatt)
                , new Location(getResources().getString(R.string.trans_header), getResources().getString(R.string.trans_desc), R.drawable.trans)
                , new Location(getResources().getString(R.string.ciputra_header), getResources().getString(R.string.ciputra_desc), R.drawable.ciputra)
        ));

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), locations);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(locationAdapter);

        // Pass Name, Description, Image
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location currentLocation = locations.get(position);
                Intent goIntent = new Intent(getActivity(), LocationActivity.class);
                goIntent.putExtra("location_name", currentLocation.getLocationName());
                goIntent.putExtra("location_desc", currentLocation.getLocationDescription());
                goIntent.putExtra("location_img", currentLocation.getImageResource());
                startActivity(goIntent);
            }


        });
        return rootView;
    }
}
