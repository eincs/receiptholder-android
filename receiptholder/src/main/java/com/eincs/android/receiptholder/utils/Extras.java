package com.eincs.android.receiptholder.utils;

import android.app.Activity;
import android.os.Bundle;

public final class Extras {
    private Extras() {}

    public static String getString(Activity activity, String key) {
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            return extras.getString(key);
        }
        return null;
    }
}