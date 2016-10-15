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

public class CityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // City List
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll(Arrays.asList(
                new Location("Jakarta", "Located on the northwest coast of the world's most populous island of Java, Jakarta is the country's economic, cultural and political center, with a population of 10,075,310 as of 2014.[5][6] The official metropolitan area, known as Jabodetabek (a name formed by combining the initial syllables of Jakarta, Bogor, Depok, Tangerang and Bekasi), is the second largest in the world, yet the metropolis' suburbs still continue beyond it. Its unofficial built-up (metropolitan) area covers Bogor, Tangerang, Bekasi, Karawang, Serang, Purwakarta, Sukabumi and Subang regencies (123 districts), also including Tangerang, Bekasi, Tangerang Selatan, Depok, Serang and Cilegon Municipalities, which in total were home to 30,214,303 inhabitants as of 2010 census.", R.drawable.jakarta)
                , new Location("Surabaya", "Surabaya (Indonesian pronunciation: [surəˈbaja]) (formerly Dutch: Soerabaja/Soerabaia Javanese: ꦱꦸꦫꦧꦪ (Surabaya)), is the capital of Jawa Timur (East Java), located on northeastern Java island and along the edge of the Madura Strait and the second-largest-city in Indonesia. At the 2010 census, the city had a population over 2.8 million and an 'extended metropolitan area', with more than 9 million inhabitants in several cities and approximately 50 districts spread over non-contigous urban areas including Gresik, Sidoarjo, Mojokerto and Pasuruan regencies, and locally known as Gerbangkertosusila[1] The national government recognizes only the continuous core metropolitan area (Surabaya, Gresik and Sidarjo) as Greater Surabaya (Zona Surabaya Raya) with a population of 6,484,2060 (2010), making Surabaya now the third largest metropolitan area in Indonesia, after Greater Jakarta and Greater Bandung.", R.drawable.surabaya)
                , new Location("Bali", "Bali (Balinese: ᬩᬮᬶ) is an island and province of Indonesia. The province includes the island of Bali and a few smaller neighbouring islands, notably Nusa Penida, Nusa Lembongan, and Nusa Ceningan. It is located at the westernmost end of the Lesser Sunda Islands, between Java to the west and Lombok to the east. Its capital, Denpasar, is located in the southern part of the island", R.drawable.bali)
                , new Location("Medan", "Medan (Indonesian pronunciation: [meˈdan]; Indonesian: Kota Medan) is the capital of North Sumatra province in Indonesia. Located on the northern coast, and with 2,097,610 inhabitants at the 2010 census, Medan is third largest city in Indonesia (behind Jakarta and Surabaya), and the largest Indonesian city outside Java.[2][3][4]Its built-up (or metro) area made of 18 municipalities or districts was home to 4,103,696 inhabitants at the 2010 census.[5] The city is bordered by the Deli Serdang Regency to the east, south and west, and the Strait of Malacca to the north.", R.drawable.medan)
                , new Location("Makassar", "Makassar (Buginese-Makassar language: ᨀᨚᨈ ᨆᨀᨔᨑ) – sometimes spelled Macassar, Mangkasara' – is the provincial capital of South Sulawesi, Indonesia. It is the largest city on Sulawesi Island in terms of population, and the fifth largest city in Indonesia after Jakarta, Surabaya, Bandung, and Medan.[1][2] From 1971 to 1999, the city was named Ujung Pandang, after a precolonial fort in the city, and the two names are often used interchangeably. The city is located on the southwest coast of the island of Sulawesi, facing the Makassar Strait", R.drawable.makassar)
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


