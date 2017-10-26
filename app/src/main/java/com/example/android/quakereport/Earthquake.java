package com.example.android.quakereport;

/**
 * Created by Steven on 25/10/2017.
 */

public class Earthquake {

    // magnitude of the earthquake
    private String mMagnitude;

    // location of the earthquake
    private String mLocation;

    // time when the earthquake took place
    private String mTime;

    public Earthquake(String magnitude, String location, String time){
        mMagnitude = magnitude;
        mLocation = location;
        mTime = time;
    }

    /**
     * get the magnitude of the earthquake
     * @return magnitude
     */
    public String getMagnitude(){
        return mMagnitude;
    }

    /**
     * get the location of the earthquake
     * @return earthquake
     */
    public String getLocation(){
        return mLocation;
    }

    /**
     * get the time when the earthquake took place
     * @return time when it took place
     */
    public String getTime(){
        return mTime;
    }
}
