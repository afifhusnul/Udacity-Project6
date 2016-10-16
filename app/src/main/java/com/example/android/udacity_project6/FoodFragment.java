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

public class FoodFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Foods List
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                new Location(getResources().getString(R.string.gudeg_header), getResources().getString(R.string.gudeg_desc), R.drawable.gudeg)
                , new Location(getResources().getString(R.string.pecel_header), getResources().getString(R.string.pecel_desc), R.drawable.pecel)
                , new Location(getResources().getString(R.string.soto_header), getResources().getString(R.string.soto_desc), R.drawable.soto)
                , new Location(getResources().getString(R.string.bakso_header), getResources().getString(R.string.bakso_desc), R.drawable.bakso)
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
