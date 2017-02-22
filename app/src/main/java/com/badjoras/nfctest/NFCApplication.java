package com.badjoras.nfctest;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by baama on 22/02/2017.
 */

public class NFCApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Timber.i("Timber in debug mode");
        }
    }
}
