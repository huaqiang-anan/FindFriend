package com.mj.findfriend.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by huaqiang
 * on 2016-05-16.
 */
public class TestUtils {
    public static String getJSONFromAsset(Context context, String jsonFileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
