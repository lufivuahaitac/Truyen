package vn.netbit.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/**
 * Created by lufiv on 9/28/2017.
 */

public class Utils {
    public static boolean isVisible(View v){
        return v.getVisibility() == View.VISIBLE;
    }

    public static View createViewFromXml(Context context, int id){
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(id, null, false);
    }
}
