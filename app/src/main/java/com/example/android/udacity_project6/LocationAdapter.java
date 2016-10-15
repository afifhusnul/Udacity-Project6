package com.example.android.udacity_project6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NUSNAFIF on 10/13/2016.
 */

public class LocationAdapter extends ArrayAdapter<Location> {
    // Pass variable context to BitMapWorkerTask
    Context context;

    public LocationAdapter(Context context, List<Location> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get location at this list position
        Location location = getItem(position);

        // Set layout to location_activity.xml
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_item, parent, false);
        }

        // Setup name and desc (text)
        TextView locationName = (TextView) convertView.findViewById(R.id.location_name);
        TextView locationDesc = (TextView) convertView.findViewById(R.id.location_desc);
        locationName.setText(location.getLocationName());
        locationDesc.setText(location.getLocationDescription());

        // Setup image view;
        ImageView iconImage = (ImageView) convertView.findViewById(R.id.location_img);
        if (location.hasImage()) {
            BitmapWorkerTask bitmapWorkerTask = new BitmapWorkerTask(iconImage, context);
            bitmapWorkerTask.execute(location.getImageResource());
            return convertView;
        } else {
            iconImage.setVisibility(View.GONE);
            return convertView;
        }
    }
}
