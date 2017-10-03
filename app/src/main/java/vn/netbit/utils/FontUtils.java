package vn.netbit.utils;

import android.graphics.Typeface;


/**
 * Created by truongnq on 10/3/2017.
 */

public class FontUtils {
    private Typeface bookerly;
    private Typeface literata;

    public void setBookerly(Typeface bookerly) {
        this.bookerly = bookerly;
    }

    public void setLiterata(Typeface literata) {
        this.literata = literata;
    }
//    public FontUtils(){
//        bookerly = Typeface.createFromAsset(getAssets(), "fonts/Bookerly-Regular.ttf");
//        literata = Typeface.createFromAsset(getAssets(), "fonts/literata-regular.otf");
//    }

    private static final class SingletonHolder {

        private static final FontUtils INSTANCE = new FontUtils();
    }

    public static FontUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Typeface getBookerly() {
        return bookerly;
    }

    public Typeface getLiterata() {
        return literata;
    }
}
