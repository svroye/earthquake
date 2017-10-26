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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Steven on 25/10/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

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

        // find all Views that need to be populated, i.e. the magnitude, offset, location,
        // time and date
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_textview);
        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset_textview);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_textview);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_textview);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textview);

        // Get the magnitude from the earthquake and set this text on the TextView
        magnitudeTextView.setText(""+ currentEarthquake.getMagnitude());

        String totalLocation = currentEarthquake.getLocation();
        String offset = "";
        String location = "";

        if(totalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts =  totalLocation.split(LOCATION_SEPARATOR);
            offset = parts[0] + LOCATION_SEPARATOR;
            location = parts[1];
        } else{
            offset = getContext().getResources().getString(R.string.near_the);
            location = totalLocation;
        }

        offsetTextView.setText(offset);
        locationTextView.setText(location);

        // convert the unix timestamp to a Date instance
        long time = currentEarthquake.getTime();
        Date dateObject = new Date(time);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("DD MMM, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        String dateToDisplay = dateFormatter.format(dateObject);
        String timeToDisplay = timeFormatter.format(dateObject);


        // Get the lcoation from the earthquake and set it to the textview
        timeTextView.setText(timeToDisplay);
        dateTextView.setText(dateToDisplay);
        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
