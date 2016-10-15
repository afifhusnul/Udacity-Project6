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

public class AdventureFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Adventure List
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                new Location("Raja Ampat", "Located off the northwest tip of Bird's Head Peninsula on the island of New Guinea, in Indonesia's West Papua province, Raja Ampat, or the Four Kings, is an archipelago comprising over 1,500 small islands, cays, and shoals surrounding the four main islands of Misool, Salawati, Batanta, and Waigeo, and the smaller island of Kofiau. The Raja Ampat archipelago is the part of Coral Triangle which contains the richest marine biodiversity on earth.", R.drawable.raja_ampat)
                , new Location("Bunaken", "Bunaken is an island of 8 km², part of the Bunaken National Marine Park. Bunaken is located at the northern tip of the island of Sulawesi, Indonesia. It belongs administratively to the municipality of Manado. Scuba diving attracts many visitors to the island.\n" +
                        "\n" +
                        "\n" +
                        "Other sides of Bunaken.\n" +
                        "Bunaken National Park extends over an area of 890.65 km² of which only 3% is terrestrial, including Bunaken Island, as well as the islands of Manado Tua, Mantehage, Nain and Siladen.", R.drawable.bunaken)
                , new Location("Mount Bromo", "Mount Bromo (Indonesian: Gunung Bromo), is an active volcano and part of the Tengger massif, in East Java, Indonesia. At 2,329 metres (7,641 ft) it is not the highest peak of the massif, but is the most well known. The massif area is one of the most visited tourist attractions in East Java, Indonesia. The volcano belongs to the Bromo Tengger Semeru National Park. The name of Bromo derived from Javanese pronunciation of Brahma, the Hindu creator god. Sulfur is collected from inside the caldera by workers.", R.drawable.bromo)
                , new Location("Kawah Ijen", "The Ijen volcano complex is a group of composite volcanoes in the Banyuwangi Regency of East Java, Indonesia.\n" +
                        "\n" +
                        "It is inside a larger caldera Ijen, which is about 20 kilometres wide. The Gunung Merapi stratovolcano is the highest point of that complex. The name \"Gunung Merapi\" means \"mountain of fire\" in the Indonesian language (api being \"fire\"); Mount Merapi in central Java and Marapi in Sumatra have the same etymology.\n" +
                        "\n" +
                        "West of Gunung Merapi is the Ijen volcano, which has a one-kilometre-wide turquoise-coloured acidic crater lake. The lake is the site of a labour-intensive sulfur mining operation, in which sulfur-laden baskets are carried by hand from the crater floor. The work is paid well considering the cost of living in the area, but is very onerous.[2] Workers earn around Rp 50,000 - 75,000 ($5.50-$8.30) per day and once out of the crater, still need to carry their loads of sulfur chunks about three kilometers to the nearby Paltuding Valley to get paid.", R.drawable.kawah_ijen)
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
