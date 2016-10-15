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
                new Location("Grand Hyatt Jakarta", "Located on the central jakarta with luxuries hospitality.", R.drawable.hyatt)
                , new Location("Trans Studio Theme Park", "TRANS STUDIO BANDUNG THEME PARK is the second indoor theme park in Indonesia after Makassar. Trans Studio Bandung is much more spectacular and exciting than Trans Studio Makassar, but both have their own uniqueness that makes Trans Studio Bandung not only the biggest in Indonesia but also one of the biggest in the world.", R.drawable.trans)
                , new Location("Ciputra World", "Ciputra World Surabaya has enhanced the reputation of Surabaya into a more modern and international city. Built on a 3 hectare site, the 90,000 sqm shopping mall is completed with  apartment blocks, a 5-star Hotel managed by Swiss-Belhotel International which will be opened in August 2014, and a lifestyle SOHO (Small Office Home Office) to accommodate modern people needs.", R.drawable.ciputra)
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
