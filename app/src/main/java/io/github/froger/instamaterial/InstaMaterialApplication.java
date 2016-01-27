package io.github.froger.instamaterial;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.parse.Parse;
import com.parse.ParseObject;

import io.github.froger.instamaterial.ui.activity.ConfigHelper;
import io.github.froger.instamaterial.ui.activity.Instapost;
import timber.log.Timber;

/**
 * Created by froger_mcs on 05.11.14.
 */






public class InstaMaterialApplication extends Application {
    // Debugging switch
    public static final boolean APPDEBUG = false;

    // Debugging tag for the application
    public static final String APPTAG = "AnyWall";

    // Used to pass location from MainActivity to PostActivity
    public static final String INTENT_EXTRA_LOCATION = "location";

    // Key for saving the search distance preference
    private static final String KEY_SEARCH_DISTANCE = "searchDistance";

    private static final float DEFAULT_SEARCH_DISTANCE = 250.0f;

    private static SharedPreferences preferences;

    private static ConfigHelper configHelper;

    public InstaMaterialApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());


        ParseObject.registerSubclass(Instapost.class);
        Parse.initialize(this, "N62AqXgYxJGI5JXVZpKBYpfB5ImWEjz2KSAKC531",
                "LHGNZmSM7frS7s4jnXcrs3K9JiANWY25kCjcSg2b");

        preferences = getSharedPreferences("com.parse.anywall", Context.MODE_PRIVATE);

        configHelper = new ConfigHelper();
        configHelper.fetchConfigIfNeeded();

    }

    public static float getSearchDistance() {
        return preferences.getFloat(KEY_SEARCH_DISTANCE, DEFAULT_SEARCH_DISTANCE);
    }

    public static ConfigHelper getConfigHelper() {
        return configHelper;
    }

    public static void setSearchDistance(float value) {
        preferences.edit().putFloat(KEY_SEARCH_DISTANCE, value).commit();
    }

}
