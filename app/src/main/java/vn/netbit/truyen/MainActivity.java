package vn.netbit.truyen;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.OnClick;
import vn.netbit.utils.FontUtils;
import vn.netbit.utils.SectionsPageAdapter;

public class MainActivity extends AppCompatActivity {


    //@BindView(R.id.tabs)
    TabLayout tabs;

    private SectionsPageAdapter mSectionsPageAdapter;
    private int[] tabIcons = {
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_view_list_black_24dp
    };

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.dank_blue));
        this.getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.dank_blue));
        FontUtils.getInstance().setBookerly(Typeface.createFromAsset(getAssets(), "fonts/Bookerly-Regular.ttf"));
        FontUtils.getInstance().setLiterata(Typeface.createFromAsset(getAssets(), "fonts/literata-regular.otf"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);


        setupTabIcons();
    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home(), "");
        adapter.addFragment(new CategoryList(), "");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(tabIcons[0]);
        tabs.getTabAt(1).setIcon(tabIcons[1]);

        tabs.getTabAt(tabs.getSelectedTabPosition()).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //for removing the color of first icon when switched to next tab
                tabs.getTabAt(0).getIcon().clearColorFilter();
                //for other tabs
                tab.getIcon().clearColorFilter();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
