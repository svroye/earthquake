package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Steven on 25/10/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(@NonNull Context context, @NonNull ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if existing view is being reused, otherwise inflate view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Eartquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude_textview
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_textview);
        // Get the magnitude from the earthquake and set this text on the TextView
        magnitudeTextView.setText(""+ currentEarthquake.getMagnitude());

        // Find the TextView in the list_item.xml layout with the ID location_textview
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_textview);
        // Get the lcoation from the earthquake and set it to the textview
        locationTextView.setText(currentEarthquake.getLocation());

        // Find the TextView in the list_item.xml layout with the ID location_textview
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_textview);
        // Get the lcoation from the earthquake and set it to the textview
        timeTextView.setText(currentEarthquake.getTime());

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
