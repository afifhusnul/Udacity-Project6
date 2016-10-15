package com.example.android.udacity_project6;

/**
 * Created by NUSNAFIF on 10/13/2016.
 */

public class Location {
    private String LocationName;
    private String LocationDescription;
    private int ImageResource = NO_IMAGE;

    public static final int NO_IMAGE = -1;

    private double latitude;
    private double longitude;

    /**
     *  Contrutor with Image
     * @param locationName
     * @param locationDescription
     * @param imageResource
     */
    public Location(String locationName, String locationDescription, int imageResource) {
        LocationName = locationName;
        LocationDescription = locationDescription;
        ImageResource = imageResource;
    }

    /**
     *  Contrutor WITHOUT Image
     * @param locationName
     * @param locationDescription
     */
    public Location(String locationName, String locationDescription) {
        LocationName = locationName;
        LocationDescription = locationDescription;
    }

    public String getLocationName() { return LocationName; }

    public String getLocationDescription() { return LocationDescription; }

    public int getImageResource() { return ImageResource;  }
    /**
     * Check if location instance has an image
     * @return "this instance has an image"
     */
    public boolean hasImage(){
        return ImageResource != NO_IMAGE;
    }

    /**
     * Print instance information
     * @return
     */

    @Override
    public String toString() {
        return "Location{" +
                "LocationName='" + LocationName + '\'' +
                ", LocationDescription='" + LocationDescription + '\'' +
                ", ImageResource=" + ImageResource +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
