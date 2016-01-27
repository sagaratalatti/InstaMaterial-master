package io.github.froger.instamaterial.ui.activity;


import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.ParseFile;


/**
 * Created by Siddharth on 1/25/16.
 */
@ParseClassName("Posts")
public class Instapost extends ParseObject {

    private String image;

    public ParseGeoPoint getLocation() {
        return getParseGeoPoint("location");
    }
    public void setLocation(ParseGeoPoint value) {
        put("location", value);

    }

    public ParseFile getPhotoFile() {
        return getParseFile("photo");
    }

    public void setPhotoFile(ParseFile file) {
        put("photo", file);
    }


}














