package vn.netbit.truyen;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.netbit.utils.EbookTextView;
import vn.netbit.utils.Utils;

public class Backup extends AppCompatActivity {
    //@BindView(R.id.chapContent) String chapContent;

    @BindView(R.id.rlReadAaSet)
    LinearLayout rlReadAaSet;
    @BindView(R.id.main_content)
    LinearLayout main_content;
    @BindView(R.id.seekbarFontSize)
    SeekBar seekbarFontSize;

    @BindView(R.id.contentScrollView)
    ScrollView contentScrollView;

    @BindView(R.id.llBookReadBottom)
    LinearLayout llBookReadBottom;
    @BindView(R.id.chapContent)
    EbookTextView tv;
    @BindView(R.id.chapContent2)
    EbookTextView tv2;

    LinearLayout settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);
        ButterKnife.bind(this);


        hideSystemUI();
        //main_content.getHeight();
        seekbarFontSize.setProgress(30);
        seekbarFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        settings = (LinearLayout) View.in(R.id.rlReadAaSet);
        loadChap();

    }

    private void loadChap() {
        String s = "line line  - Giết! Giết!\n" +
                "\n" +
                "Nhìn thấy người này, nghe được người ấy quát lớn, Nhiếp Vân cũng không phản cảm, ngược lại đôi mắt bắt đầu đỏ ửng.\n" +
                "\n" +
                "Cha hắn Nhiếp Khiếu Thiên, từng đã là đệ nhất thiên tài của gia tộc. Người mở ra bảy đại huyết thống nhân tử Vương tộc đỉnh phong, không đến hai mươi lăm tuổi đã là cảnh giới Khí Hải Cửu Trọng Thiên tầng thứ bảy Binh Giáp cảnh . Năm đó hắn là quán quân của cuộc thi tài ở thành Lạc Thủy, là người đoạt giải Lạc Thủy kim thuẫn. \n" +
                "\n" +
                "Ngay tại lúc tất cả mọi người cho là hắn có thể đột phá gông cùm xiềng xích tầng thứ bảy tiến giai Khí Tông trở thành một đại tông sư, hắn lại đột nhiên tẩu hỏa nhập ma! Khí Hải tổn hại, tất cả công lực hủy hoại chỉ trong chốc lát!\n" +
                "\n" +
                "Khí Hải tổn hại thì không có cách nào tiếp tục tu luyện. Đối với một người được xưng là siêu cấp thiên tài trăm năm khó gặp mà nói, đả kích thật sự quá lớn. Phụ thân từ nay về sau không gượng dậy nổi, cả ngày mượn rượu tiêu sầu.\n" +
                "\n" +
                "Từ thiên tài biến thành phế vật, đối thủ trước kia nhao nhao xa lánh, địa vị chi nhánh ở gia tộc cũng lập tức ngày càng tuột dốc, đến bây giờ đã bị phái đến khu vực biên giới thành Lạc Thủy , ngay cả gia tộc phủ đệ đều không được cho phép tiến vào!!\n" +
                "\n" +
                "Sinh ra trong hoàn cảnh ấy, vừa chào đời hắn đã phải chịu đủ mọi loại khi dễ cũng cười nhạo. Bởi vậy, hắn ghét mọi thứ liên quan đến phụ thân, thậm chí ghét luôn cả cái nhà hắn đang sống.\n" +
                "\n" +
                "Nếu như không phải do phụ thân, hắn hoàn toàn có thể mở ra huyết thống nhân tử sớm hơn, đạt được nhiều tài nguyên tu luyện hơn. Như vậy, thực lực của hắn sẽ tăng lên nhanh hơn, nói không chừng còn trở thành đệ tử thiên tài mà mỗi người trong gia tộc phải sùng bái mà không phải ở tại nơi này bị người người khinh bỉ, người người xem thường!\n" +
                "\n" +
                "Nếu như không phải phụ thân, hắn cũng không phải chịu nhiều vũ nhục khinh bỉ như thế, làm chuyện gì cũng khó khăn, cuộc sống bần hàn thiếu thốn!\n" +
                "\n" +
                "Từ những nguyên nhân đó, hắn càng ngày càng chán ghét đối phương, giữa hai bên cũng không có bao nhiêu thân tình đáng nói.\n" +
                "\n" +
                "Tình huống này kéo dài đến ngày đó...\n" +
                "\n" +
                "Ngày đó tràn ngập huyết sắc, đại quân Yêu tộc đột kích thành Lạc Thủy, phụ thân che ở trước người hắn, bị đầu lưỡi một đầu lĩnh yêu tộc đâm xuyên!\n" +
                "\n" +
                "Lúc đối phương sắp chết hắn mới hiểu ra rằng, người mà hắn thầm ghét kia chỉ vì để cho hắn có cơ hội mở ra huyết thống nhân tử mà không tiếc cùng người khác trao đổi, bán đi Vấn Lân bảo đao vốn được coi như là tính mạng của mình!\n" +
                "\n" +
                "Vì để hắn có thể tu luyện nhanh chóng, phụ thân không tiếc quỳ trước tộc trưởng, thừa nhận khuất nhục để có được Linh Cốc đan mang về đưa cho mẫu thân giả vờ nhặt được đưa cho hắn!\n" +
                "\n" +
                "Vì để hắn không bị thanh danh của mình liên lụy mà không tiếc nhẫn tâm giả vờ lạnh lùng trước mặt con mình...\n" +
                "\n" +
                "Thế nhưng mà... Lúc đó biết rõ thì sao đâu? Phụ thân đã đi rồi, triệt để rời khỏi hắn!\n" +
                "\n" +
                "Cây muốn lặng mà gió chẳng muốn ngừng, tử dục dưỡng mà thân không đợi!\n" +
                "\n" +
                "Bản thân hắn quá ngu muội không nhận ra. Nếu như biết sớm thì cũng không khốn nạn như vậy. Mẫu thân mất, sau khi hắn tự mình chưởng quản chi nhánh đã nhục mạ phụ thân khiến hắn không dám về nhà!";

            //.setMovementMethod(new ScrollingMovementMethod());
            tv.setText(s);
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(15);
        //tv.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Bookerly-Regular.ttf"));
        tv.setTypeface(Typeface.SERIF);
        tv.setLineSpacing(10,1);
           //tv.get(20);
            //chapContent = s;
        tv2.setText(s);
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(20);
    }
    int actiondownX = 0;
    int actiondownY = 0;
    boolean center = false;
    @Override
    public boolean dispatchTouchEvent(MotionEvent e) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:

                int dx = (int) e.getX();
                int dy = (int) e.getY();
                actiondownX = dx;
                actiondownY = dy;


                if (actiondownX >= width / 3 && actiondownX <= width * 2 / 3
                        && actiondownY >= height / 3 && actiondownY <= height * 2 / 3) {
                    center = true;
                } else {
                    center = false;
                }
            case MotionEvent.ACTION_MOVE:
                return super.dispatchTouchEvent(e);
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:

                long t = System.currentTimeMillis();
                int ux = (int) e.getX();
                int uy = (int) e.getY();

                if (center) {
                    if (Math.abs(ux - actiondownX) < 5 && Math.abs(uy - actiondownY) < 5) {
                        changer();
                    }
                    break;
                }
        }
        boolean ret = super.dispatchTouchEvent(e);
        return ret;
    }
    public void changer(){

        Intent myIntent = new Intent(Backup.this, Read.class);
        myIntent.putExtra("key", "Test"); //Optional parameters
        Backup.this.startActivity(myIntent);

//        float curSize = tv.getTextSize()  + 1;
//        tv.setTextSize(pixelsToSp(this, curSize));
       // gone(rlReadAaSet);
//        settings.setVisibility(View.VISIBLE);
        if(Utils.isVisible(llBookReadBottom)){
            gone(llBookReadBottom);
            hideSystemUI();
        } else {
            visible(llBookReadBottom);
            showSystemUI();
        }
    }


    @OnClick(R.id.tvBookReadSettings)
    protected void readSettings(){

        if(Utils.isVisible(rlReadAaSet)){
            gone(rlReadAaSet);
        } else {
            visible(rlReadAaSet);
        }
    }

    @OnClick(R.id.tvBookMark)
    protected void showBar(){
    }

    public static float pixelsToSp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px/scaledDensity;
    }

    protected void gone(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.GONE);
                }
            }
        }
    }

    protected void visible(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void setFullscreen(boolean fullscreen)
    {
        if(fullscreen){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        } else{
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_LAYOUT_FLAGS);
        }

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//
//        WindowManager.LayoutParams attrs = getWindow().getAttributes();
//        if (fullscreen)
//        {
//            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
//            attrs.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
//        }
//        else
//        {
//            attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
//            attrs.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
//        }
//        getWindow().setAttributes(attrs);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus) {
            hideSystemUI();
        }
    }

    protected void enableImmersiveMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }

    // This snippet hides the system bars.
    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    // This snippet shows the system bars. It does this by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }


}
