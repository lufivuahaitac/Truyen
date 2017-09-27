package vn.netbit.utils;

import android.view.View;

/**
 * Created by lufiv on 9/28/2017.
 */

public class Utils {
    public static boolean isVisible(View v){
        return v.getVisibility() == View.VISIBLE;
    }
}
