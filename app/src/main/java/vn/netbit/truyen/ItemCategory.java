package vn.netbit.truyen;

import android.graphics.Bitmap;

/**
 * Created by lufiv on 10/1/2017.
 */

public class ItemCategory {
    private String cover;
    private String title;
    private String latelyUpdate;
    private String shortDetail;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLatelyUpdate() {
        return latelyUpdate;
    }

    public void setLatelyUpdate(String latelyUpdate) {
        this.latelyUpdate = latelyUpdate;
    }

    public String getShortDetail() {
        return shortDetail;
    }

    public void setShortDetail(String shortDetail) {
        this.shortDetail = shortDetail;
    }
}
