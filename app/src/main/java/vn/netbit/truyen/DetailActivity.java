package vn.netbit.truyen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by truongnq on 10/3/2017.
 */

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.detailTitle)
    TextView detailTitle;
    @BindView(R.id.detailCover)
    ImageView detailCover;
    



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
