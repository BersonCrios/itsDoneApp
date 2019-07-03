package io.github.berson.itsdone.Application;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.jakewharton.threetenabp.AndroidThreeTen;

import io.github.berson.itsdone.Utils.CustomSharedPreference;

public class App extends Application {
    public static App instance = null;
    private static Context mContext;

    private static final String TAG = App.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AndroidThreeTen.init(this);
        mContext = getApplicationContext();
        CustomSharedPreference.init(this);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    public static Context getContext() {
        return mContext;
    }

    public static App getInstance() {
        return instance;
    }
}
