package com.badjoras.nfctest.utils;

import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

/**
 * Created by baama on 21/02/2017.
 */

public class Utils {

    public static Locale getCurrentLocale(Resources resources){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return resources.getConfiguration().getLocales().get(0);
        } else{
            return resources.getConfiguration().locale;
        }
    }
}
