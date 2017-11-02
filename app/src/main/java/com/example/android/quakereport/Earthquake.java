package com.example.android.quakereport;

/**
 * Created by Steven on 25/10/2017.
 */

public class Earthquake {

    // magnitude of the earthquake
    private double mMagnitude;

    // location of the earthquake
    private String mLocation;

    // time when the earthquake took place
    private long mTime;

    // url for more information of the earthquake
    private String mUrl;

    public Earthquake(double magnitude, String location, long time, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mTime = time;
        mUrl = url;
    }

    /**
     * get the magnitude of the earthquake
     * @return magnitude
     */
    public double getMagnitude(){
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
    public long getTime(){
        return mTime;
    }

    /**
     * get the URL of the earthquake for more information
     * @return the url
     */
    public String getUrl(){
        return mUrl;
    }
}
