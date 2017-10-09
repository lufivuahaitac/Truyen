package vn.netbit.truyen;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.netbit.utils.EbookTextView;

/**
 * Created by truongnq on 10/3/2017.
 */

public class DetailActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @BindView(R.id.detailTitle)
    TextView detailTitle;
    @BindView(R.id.detailCover)
    ImageView detailCover;
    @BindView(R.id.detailInfo)
    TextView detailInfo;
    @BindView(R.id.detailSummary)
    EbookTextView detailSummary;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        unbinder = ButterKnife.bind(this);

        detailTitle.setText("Thí Thiên Đao");
        Picasso.with(this).load("http://goctruyen.com/public/frontend/images/thithiendao4nFIiAejbK.jpg").into(detailCover);
        detailInfo.setText("Tác giả:Tiểu Đao Phong Lợi\n" +
                "Thể loại:Truyện Tiên Hiệp\n" +
                "Nguồn:Goctruyen.com\n" +
                "Tình trạng:Hoàn Thành");
        detailInfo.setTextColor(Color.argb(255,77,77,77));
        detailInfo.setLineSpacing(10,10);
        detailSummary.setText("Giang hồ vô đạo, bạt đao tương trợ, đao xuất ngang trời, không thẹn với lương tâm.\n" +
                "\n" +
                "Chúng sinh vô đạo, đao phong thí. Lãnh nhãn tinh không, trì đao bễ nghễ.\n" +
                "\n" +
                "Thông thiên đại lộ, nhất lộ kinh cức, một đao chém ra, duy ngã độc tôn!\n" +
                "\n" +
                "Một thiếu niên xuất thân cô nhi, được người nhặt nuôi. Thiên phú trác tuyệt, huyết thống hùng mạnh bí ẩn, từng bước vượt qua sóng gió, gặp gỡ cơ duyên, rèn luyện, trưởng thành.\n" +
                "\n" +
                "Con đường lên đến đỉnh cao trải đầy những cánh hoa màu hồng thấm đẫm máu và nước mắt. Phấn đấu hết mình để đạt được mục tiêu cao nhất nhưng đôi khi cũng cần biết buông bỏ. Khó khăn tuyệt lộ sẽ là động lực mạnh nhất khiến con người bứt phá. Thói đời bon chen lừa lọc gian dối, đối mặt với những dục vọng sâu thẳm nhất của người đời mới khiến ta cảm nhận được tình thân, tình bạn, tình yêu… chân thực nhất, sâu sắc nhất.\n" +
                "\n" +
                "Ngay từ đầu truyện tác giả đã “vạch sẵn” con đường theo dõi cốt truyện từ thân phận bí ẩn của Sở Mặc liên quan đến ngọc bội thần kỳ cùng với đó là “map truyện” rõ ràng Nhân gian – Linh Giới – Tiên Giới – Thiên Giới. Sở Mặc cần trở nên mạnh mẽ không phải vì hắn là nhân vật chính và phải đạp lên đầu những kẻ khác để tỏ ra hùng mạnh, mà hắn cần phải mạnh mẽ để bước lên một vũ đài lớn hơn, đối mặt với sứ mạng của chính mình. Chính thân phận bí ẩn và sứ mệnh của hắn đã buộc hắn phải trưởng thành, phải mãnh mẽ để đương đầu!\n" +
                "\n" +
                "Vậy thân phận của Sở Mặc là gì? Sứ mệnh của hắn ra sao? Mời các bạn theo dõi và khám phá.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
