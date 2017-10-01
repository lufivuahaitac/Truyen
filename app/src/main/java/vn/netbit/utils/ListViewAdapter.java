package vn.netbit.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.netbit.truyen.ItemCategory;
import vn.netbit.truyen.R;

/**
 * Created by lufiv on 10/1/2017.
 */


public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<ItemCategory> mCategoryItem;

    //Constructor

    public ListViewAdapter(Context mContext, List<ItemCategory> mCategoryItem) {
        this.mContext = mContext;
        this.mCategoryItem = mCategoryItem;
    }


    public void addListItemToAdapter(List<ItemCategory> list) {
        //Add list to current array list of data
        mCategoryItem.addAll(list);
        //Notify UI
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mCategoryItem.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategoryItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.item_category, null);
        ImageView cover = (ImageView) v.findViewById(R.id.itemCover);
        TextView title = (TextView) v.findViewById(R.id.itemTitle);
        TextView latelyUpdate = (TextView) v.findViewById(R.id.itemLatelyUpdate);
        TextView shortDetail = (TextView) v.findViewById(R.id.itemShortDetail);

        Glide.with(mContext).load(mCategoryItem.get(position).getCover()).into(cover);
        title.setText(mCategoryItem.get(position).getTitle());
        latelyUpdate.append(mCategoryItem.get(position).getLatelyUpdate());
        shortDetail.append(mCategoryItem.get(position).getShortDetail());
        //Save product id to tag
        v.setTag(mCategoryItem.get(position).getLatelyUpdate());

        return v;
    }
}