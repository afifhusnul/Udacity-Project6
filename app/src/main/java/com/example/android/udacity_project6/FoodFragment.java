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
                new Location("Gudeg", "Gudeg is a traditional Javanese cuisine from Yogyakarta and Central Java, Indonesia. Gudeg is made from young unripe jack fruit (Javanese: gori, Indonesian: nangka muda) boiled for several hours with palm sugar, and coconut milk.[3][4] Additional spices include garlic, shallot, candlenut, coriander seed, galangal, bay leaves, and teak leaves, the latter giving a reddish brown color to the dish.[5] It is often described as \"green jack fruit sweet stew\".", R.drawable.gudeg)
                , new Location("Pecel", "Pecel is a traditional Javanese salad, consisting of a mixed vegetables in peanut sauce dressing, usually served with steamed rice or sometimes with lontong or ketupat compressed rice cake.[1][2] The peanut sauce used in pecel is also similar to gado-gado. Peanut sauce for pecel has no coconut milk.[1] However pecel has been strongly associated with Javanese cuisine, while gado-gado is usually associated with Betawi and Sundanese cuisine. In Malaysia, it is called as pecal[3] which is introduced by the Javanese immigrants. Pecel is also very popular in Suriname, where it was introduced by the Javanese Surinamese", R.drawable.pecel)
                , new Location("Soto Ayam", "Soto ayam is a yellow spicy chicken soup[3] with lontong or nasi himpit or ketupat (all compressed rice that is then cut into small cakes) and/or vermicelli[4] or noodles, commonly found in Indonesia,[1][2] Singapore,[5] Malaysia [6][7] and Suriname. Turmeric is added as one of its ingredients to get yellow chicken broth. It is probably the most popular variant of soto, a traditional soup commonly found in Indonesian cuisine. Besides chicken and vermicelli, it can also be served with hard-boiled eggs, slices of fried potatoes, Chinese celery leaves, and fried shallots. Occasionally, people will add \"koya\", a powder of mixed prawn crackers with fried garlic or orange colored spicy sambal, krupuk or emping is a very common topping.", R.drawable.soto)
                , new Location("Bakso", "Bakso or baso is Indonesian meatball,[2] or meat paste made from beef surimi.[3] Its texture is similar to the Chinese beef ball, fish ball, or pork ball. The term bakso could refer to a single meatball or the whole bowl of meatballs soup.\n" +
                        "\n" +
                        "Bakso can be found all across Indonesia; from the traveling cart street vendors to restaurants. Next to soto, satay and siomay, bakso is one of the popular street food in Indonesia.[4] Today, various types of ready to cook bakso also available as frozen food commonly sold in supermarkets in Indonesia.", R.drawable.bakso)
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
