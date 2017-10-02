package vn.netbit.truyen;

import android.graphics.Bitmap;

/**
 * Created by lufiv on 10/1/2017.
 */

public class ItemCategory {

    private String id;
    private String cover;
    private String title;
    private String latelyUpdate;
    private String author;
    private String readed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReaded() {
        return readed;
    }

    public void setReaded(String readed) {
        this.readed = readed;
    }
}
