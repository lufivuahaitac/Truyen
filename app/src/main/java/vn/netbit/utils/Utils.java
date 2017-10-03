package vn.netbit.utils;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import java.util.List;
import java.util.Map;

import static vn.netbit.utils.AppUtils.getAssets;

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

    public static Map<String, Typeface> getListFont(){

        Typeface bookerly = Typeface.createFromAsset(getAssets(), "fonts/Bookerly-Regular.ttf");
        Typeface literata = Typeface.createFromAsset(getAssets(), "fonts/literata-regular.otf");

        return null;
    }
}
