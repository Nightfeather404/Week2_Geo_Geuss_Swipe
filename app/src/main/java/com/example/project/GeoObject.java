package com.example.project;

public class GeoObject {

    private String geoName;
    private int geoImageName;

    public static final String[] GEO_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };

    public static final int[] GEO_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public GeoObject(String mGeoName, int mGeoImageName) {
        this.geoName = mGeoName;
        this.geoImageName = mGeoImageName;
    }


    public String getGeoName() {
        return geoName;
    }

    public int getGeoImageName() {
        return geoImageName;
    }
}



