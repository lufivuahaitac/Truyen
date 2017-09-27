package vn.netbit.truyen;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.netbit.utils.EbookTextView;
import vn.netbit.utils.JustifyTextView;
import vn.netbit.utils.Utils;

public class MainActivity extends AppCompatActivity {
    //@BindView(R.id.chapContent) String chapContent;

    @BindView(R.id.rlReadAaSet)
    LinearLayout rlReadAaSet;
    private EbookTextView tv;
    private EbookTextView tv2;
    private Button bt;
    LinearLayout settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tv = (EbookTextView) findViewById(R.id.chapContent);
        tv2 = (EbookTextView) findViewById(R.id.chapContent2);
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

    public void increase(View v){
//        float curSize = tv.getTextSize()  + 1;
//        tv.setTextSize(pixelsToSp(this, curSize));
       // gone(rlReadAaSet);
//        settings.setVisibility(View.VISIBLE);
        if(Utils.isVisible(rlReadAaSet)){
            gone(rlReadAaSet);
        } else {
            visible(rlReadAaSet);
        }
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
}