package vn.netbit.truyen;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import vn.netbit.base.BaseActivity;
import vn.netbit.utils.EbookTextView;
import vn.netbit.utils.ScreenUtils;
import vn.netbit.utils.Utils;

public class Read extends BaseActivity implements View.OnTouchListener {

    @BindView(R.id.topSettingPannel)
    LinearLayout topSettingPannel;
    @BindView(R.id.rlReadAaSet)
    LinearLayout rlReadAaSet;
    @BindView(R.id.main_content)
    LinearLayout main_content;
    @BindView(R.id.btnFontsizeMinus)
    Button btnFontsizeMinus;

    @BindView(R.id.btnFontsizePlus)
    Button btnFontsizePlus;

    @BindView(R.id.contentScrollView)
    ScrollView contentScrollView;

    @BindView(R.id.llReadTopSetting)
    LinearLayout llReadTopSetting;

    @BindView(R.id.content)
    LinearLayout content;

    @BindView(R.id.fontType)
    Spinner fontType;

    private int fontSize = 16;

    private List<EbookTextView> textViewList = new ArrayList<>();

    @Override
    public int getLayoutId() {

        return R.layout.activity_read;
    }

    @Override
    public void initToolBar() {
        showSystemUI();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hideSystemUI();
        //main_content.getHeight();
        contentScrollView.setOnTouchListener(this);
        rlReadAaSet.setOnTouchListener(this);
        llReadTopSetting.setOnTouchListener(this);

    }

    @Override
    public void initDatas() {
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
        EbookTextView textView = new EbookTextView(this);
        textViewList.add(textView);
        textView.setText(s);
        textView.setTextSize(fontSize);
        textView.setTextColor(Color.BLACK);
        textView.setTypeface(Typeface.SERIF);
        content.addView(textView);

    }

    @Override
    public void configViews() {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) topSettingPannel.getLayoutParams();
        params.topMargin = ScreenUtils.getStatusBarHeight(this) - 2;
        topSettingPannel.setLayoutParams(params);

        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) rlReadAaSet.getLayoutParams();
        params2.leftMargin = ScreenUtils.getScreenWidth(this) * 1/4;
        rlReadAaSet.setLayoutParams(params2);

        String[] items = new String[]{"1", "2", "three"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_read_settings, items);
//set the spinners adapter to the previously created one.
        fontType.setAdapter(adapter);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus) {
            hideSystemUI();
        } else {
            if(isVisible(llReadTopSetting)){
                gone(llReadTopSetting);
                gone(rlReadAaSet);
            }
        }
    }

    @OnClick(R.id.tvBookReadSettings)
    protected void readSettings(){

        if(isVisible(rlReadAaSet)){
            gone(rlReadAaSet);
        } else {
            visible(rlReadAaSet);
        }
    }

    @OnClick(R.id.btnFontsizePlus)
    protected void plusFont(){
        fontSize += 1;
        setFontSize(fontSize);
    }

    @OnClick(R.id.btnFontsizeMinus)
    protected void minusFont(){
        fontSize -= 1;
        setFontSize(fontSize);
    }

    private void setFontSize(int size){
        for(EbookTextView tv:textViewList){
            tv.setTextSize(size);
        }
    }


    int actiondownX = 0;
    int actiondownY = 0;
    boolean center = false;

    public void toggleSettings(){

        if(isVisible(llReadTopSetting)){
            gone(llReadTopSetting);
            gone(rlReadAaSet);
            hideSystemUI();
        } else {
            visible(llReadTopSetting);
            showSystemUI();
        }
    }



    @Override
    public boolean onTouch(View v, MotionEvent e) {
        switch (v.getId()){
            case R.id.contentScrollView:
                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        int dx = (int) e.getX();
                        int dy = (int) e.getY();
                        actiondownX = dx;
                        actiondownY = dy;
                    case MotionEvent.ACTION_MOVE:
                        return super.onTouchEvent(e);
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:

                        long t = System.currentTimeMillis();
                        int ux = (int) e.getX();
                        int uy = (int) e.getY();

                        if (Math.abs(ux - actiondownX) < 10 && Math.abs(uy - actiondownY) < 10) {
                            toggleSettings();
                        }
                        break;
                }
            default:
                break;

        }


        boolean ret = super.onTouchEvent(e);
        return ret;
    }
}
