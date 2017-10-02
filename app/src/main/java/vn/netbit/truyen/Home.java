package vn.netbit.truyen;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import vn.netbit.utils.ListViewAdapter;
import vn.netbit.utils.Utils;

/**
 * Created by truongnq on 9/30/2017.
 */

public class Home extends Fragment {
    private Context mContext;
    private View homeView;
    private ListViewAdapter adapter;
    private static Gson GSON = new Gson();
    private View loading;
    private ListView homeList;
    private boolean isLoading = false;
    private Handler mHandler;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        homeView = inflater.inflate(R.layout.home,container, false);
        loading = inflater.inflate(R.layout.loading_layout, null);
        mHandler = new MyHandler();
        return homeView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeList = (ListView) homeView.findViewById(R.id.homeList);

        String test = "[{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/baylanthatthancuatophanguyetkusnSMeoLu.jpg\",\"latelyUpdate\":\"Chương 36\",\"title\":\"Bảy Lần Thất Thân Của Tô Phá Nguyệt\",\"shortDetail\":\"Bảy Lần Thất Thân Của Tô Phá Nguyệt\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/chongngoanngoanngheloiri76lApUo8.jpg\",\"latelyUpdate\":\"Chương 23\",\"title\":\"Chồng, Ngoan Ngoãn Nghe Lời!\",\"shortDetail\":\"Chồng, Ngoan Ngoãn Nghe Lời!\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/santimnang2SYSYIQdHi.jpg\",\"latelyUpdate\":\"Chương 154\",\"title\":\"Săn Tim Nàng\",\"shortDetail\":\"Săn Tim Nàng\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/tongtailyhondiC9lbZVJoto.png\",\"latelyUpdate\":\"Chương 289\",\"title\":\"Tổng Tài, Ly Hôn Đi!\",\"shortDetail\":\"Tổng Tài, Ly Hôn Đi!\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/hellonguoithuakeVl5DjmfSmk.jpg\",\"latelyUpdate\":\"Chương 16\",\"title\":\"Hello, Người Thừa Kế\",\"shortDetail\":\"Hello, Người Thừa Kế\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/lenhvoso1chongtonggiamdocotrencaoBzyQpmuKQQ.jpg\",\"latelyUpdate\":\"Chương 262\",\"title\":\"Lệnh Vợ Số 1! Chồng Tổng Giám Đốc, Ở Trên Cao\",\"shortDetail\":\"Lệnh Vợ Số 1! Chồng Tổng Giám Đốc, Ở Trên Cao\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/cachphattaicuathuongphuJkULHibWnL.jpg\",\"latelyUpdate\":\"Chương 54\",\"title\":\"Cách Phát Tài Của Thương Phụ\",\"shortDetail\":\"Cách Phát Tài Của Thương Phụ\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/baxangotngaohangtiamapkethonngaythu7vBLEMhmQJP.jpg\",\"latelyUpdate\":\"Chương 397\",\"title\":\"Bà Xã Ngọt Ngào: Hàng Tỉ Ấm Áp Kết Hôn Ngày Thứ 7\",\"shortDetail\":\"Bà Xã Ngọt Ngào: Hàng Tỉ Ấm Áp Kết Hôn Ngày Thứ 7\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/ngocmanhtieuthanhmaiyeunghiettrucmaquaphuchac6UKcqFwjYe.jpg\",\"latelyUpdate\":\"Chương 570\",\"title\":\"Tiểu Thanh Mai Ngốc Nghếch: Trúc Mã Yêu Nghiệt Quá Phúc Hắc\",\"shortDetail\":\"Tiểu Thanh Mai Ngốc Nghếch: Trúc Mã Yêu Nghiệt Quá Phúc Hắc\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/moitinhdanhmoncuccungtramtycuadethieuPc6NB8bHtG.jpg\",\"latelyUpdate\":\"Chương 322\",\"title\":\"Mối Tình Danh Môn: Cục Cưng Trăm Tỷ Của Đế Thiếu\",\"shortDetail\":\"Mối Tình Danh Môn: Cục Cưng Trăm Tỷ Của Đế Thiếu\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/hangtycungchieuvonamthanhonsau1016vnwahmR27.jpg\",\"latelyUpdate\":\"Chương 458\",\"title\":\"Hàng Tỷ Cưng Chiều Vợ: Nam Thần Hôn Sâu 101℃\",\"shortDetail\":\"Hàng Tỷ Cưng Chiều Vợ: Nam Thần Hôn Sâu 101℃\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/haomonanhonphuchactongtainuongchieubaxayhlf4V6AUk.jpg\",\"latelyUpdate\":\"Chương 398\",\"title\":\"Hào Môn Ẩn Hôn: Phúc Hắc Tổng Tài Nuông Chiều Bà Xã\",\"shortDetail\":\"Hào Môn Ẩn Hôn: Phúc Hắc Tổng Tài Nuông Chiều Bà Xã\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/thieuphunhanvolaiI1Kg9qAmpL.jpg\",\"latelyUpdate\":\"Chương 692\",\"title\":\"Thiếu Phu Nhân Vô Lại\",\"shortDetail\":\"Thiếu Phu Nhân Vô Lại\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/manhmeyeunhau100ngaysKZlERKeXI.jpg\",\"latelyUpdate\":\"Chương 1041\",\"title\":\"Mạnh Mẽ Yêu Nhau 100 Ngày\",\"shortDetail\":\"Mạnh Mẽ Yêu Nhau 100 Ngày\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/tonggiamdocdoattinhgianhlaivoyeuhmA6aDmqgf.jpg\",\"latelyUpdate\":\"Chương 730\",\"title\":\"Tổng Giám Đốc Đoạt Tình - Giành Lại Vợ Yêu\",\"shortDetail\":\"Tổng Giám Đốc Đoạt Tình - Giành Lại Vợ Yêu\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/namthancaolanhosatvachhonsai55lanmzHF1RD36D.jpg\",\"latelyUpdate\":\"Chương 892\",\"title\":\"Nam Thần Cao Lãnh Ở Sát Vách: Hôn Sai 55 Lần\",\"shortDetail\":\"Nam Thần Cao Lãnh Ở Sát Vách: Hôn Sai 55 Lần\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/savaotreugheovoyeutonggiamdocvocungcungchieuNMfUBgT7cD.jpg\",\"latelyUpdate\":\"Chương 1336\",\"title\":\"Sa Vào Trêu Ghẹo Vợ Yêu: Tổng Giám Đốc Vô Cùng Cưng Chiều\",\"shortDetail\":\"Sa Vào Trêu Ghẹo Vợ Yêu: Tổng Giám Đốc Vô Cùng Cưng Chiều\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/100ngayepyeusB6CbKzEC3.jpg\",\"latelyUpdate\":\"Chương 1041\",\"title\":\"Ép Yêu 100 Ngày\",\"shortDetail\":\"Ép Yêu 100 Ngày\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/amyenwo4IHM99AW.jpg\",\"latelyUpdate\":\"Chương 34\",\"title\":\"Ám Yến\",\"shortDetail\":\"Ám Yến\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/voquytdaycomongtaynhonthienphamquatanyTyv6XnHjV.jpg\",\"latelyUpdate\":\"Chương 25\",\"title\":\"Vỏ Quýt Dày Có Móng Tay Nhọn - Thiên Phàm Quá Tẫn\",\"shortDetail\":\"Vỏ Quýt Dày Có Móng Tay Nhọn - Thiên Phàm Quá Tẫn\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/nuquanvansu31Vz71Rhai.jpg\",\"latelyUpdate\":\"Chương 23\",\"title\":\"Nữ Quan Vận Sự\",\"shortDetail\":\"Nữ Quan Vận Sự\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/yeuemhontatcanhunggianhcomrpsnKaI2q.jpg\",\"latelyUpdate\":\"Chương 77\",\"title\":\"Yêu Em Hơn Tất Cả Những Gì Anh Có\",\"shortDetail\":\"Yêu Em Hơn Tất Cả Những Gì Anh Có\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/nguoidanongbuocratungonluaZHZgVnSJLu.jpg\",\"latelyUpdate\":\"Chương 12\",\"title\":\"Người Đàn Ông Bước Ra Từ Ngọn Lửa\",\"shortDetail\":\"Người Đàn Ông Bước Ra Từ Ngọn Lửa\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/trachnucuaanhDV9SBsY2tt.jpg\",\"latelyUpdate\":\"Chương 5\",\"title\":\"Trạch Nữ Của Anh\",\"shortDetail\":\"Trạch Nữ Của Anh\"}]";

        List<ItemCategory> list = GSON.fromJson(test, new TypeToken<List<ItemCategory>>(){}.getType());
//        for(int i= 0; i< 10; i ++){
//            ItemCategory item = new ItemCategory();
//            item.setLatelyUpdate(String.valueOf(i + 1900));
//            item.setTitle("Title " + i);
//            item.setShortDetail("Short " + i);
//            list.add(item);
//        }


        adapter = new ListViewAdapter(mContext, list);
        homeList.setAdapter(adapter);


        homeList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                //Check when scroll to last item in listview, in this tut, init data in listview = 10 item
                if(view.getLastVisiblePosition() == totalItemCount-1 && homeList.getCount() >=10 && isLoading == false) {
                    isLoading = true;
                    Thread thread = new ThreadGetMoreData();
                    //Start thread
                    thread.start();
                }

            }
        });
    }




    public class ThreadGetMoreData extends Thread {
        @Override
        public void run() {
            //Add footer view after get data
            mHandler.sendEmptyMessage(0);
            //Search more data
            ArrayList<ItemCategory> lstResult = getMoreData();
            //Delay time to show loading footer when debug, remove it when release
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Send the result to Handle
            Message msg = mHandler.obtainMessage(1, lstResult);
            mHandler.sendMessage(msg);

        }
    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    //Add loading view during search processing
                    homeList.addFooterView(loading);
                    break;
                case 1:
                    //Update data adapter and UI
                    adapter.addListItemToAdapter((ArrayList<ItemCategory>)msg.obj);
                    //Remove loading view after update listview
                    homeList.removeFooterView(loading);
                    isLoading=false;
                    break;
                default:
                    break;
            }
        }
    }

    private ArrayList<ItemCategory> getMoreData() {
        String test = "[{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/baylanthatthancuatophanguyetkusnSMeoLu.jpg\",\"latelyUpdate\":\"Chương 36\",\"title\":\"Bảy Lần Thất Thân Của Tô Phá Nguyệt\",\"shortDetail\":\"Bảy Lần Thất Thân Của Tô Phá Nguyệt\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/chongngoanngoanngheloiri76lApUo8.jpg\",\"latelyUpdate\":\"Chương 23\",\"title\":\"Chồng, Ngoan Ngoãn Nghe Lời!\",\"shortDetail\":\"Chồng, Ngoan Ngoãn Nghe Lời!\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/santimnang2SYSYIQdHi.jpg\",\"latelyUpdate\":\"Chương 154\",\"title\":\"Săn Tim Nàng\",\"shortDetail\":\"Săn Tim Nàng\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/tongtailyhondiC9lbZVJoto.png\",\"latelyUpdate\":\"Chương 289\",\"title\":\"Tổng Tài, Ly Hôn Đi!\",\"shortDetail\":\"Tổng Tài, Ly Hôn Đi!\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/hellonguoithuakeVl5DjmfSmk.jpg\",\"latelyUpdate\":\"Chương 16\",\"title\":\"Hello, Người Thừa Kế\",\"shortDetail\":\"Hello, Người Thừa Kế\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/lenhvoso1chongtonggiamdocotrencaoBzyQpmuKQQ.jpg\",\"latelyUpdate\":\"Chương 262\",\"title\":\"Lệnh Vợ Số 1! Chồng Tổng Giám Đốc, Ở Trên Cao\",\"shortDetail\":\"Lệnh Vợ Số 1! Chồng Tổng Giám Đốc, Ở Trên Cao\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/cachphattaicuathuongphuJkULHibWnL.jpg\",\"latelyUpdate\":\"Chương 54\",\"title\":\"Cách Phát Tài Của Thương Phụ\",\"shortDetail\":\"Cách Phát Tài Của Thương Phụ\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/baxangotngaohangtiamapkethonngaythu7vBLEMhmQJP.jpg\",\"latelyUpdate\":\"Chương 397\",\"title\":\"Bà Xã Ngọt Ngào: Hàng Tỉ Ấm Áp Kết Hôn Ngày Thứ 7\",\"shortDetail\":\"Bà Xã Ngọt Ngào: Hàng Tỉ Ấm Áp Kết Hôn Ngày Thứ 7\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/ngocmanhtieuthanhmaiyeunghiettrucmaquaphuchac6UKcqFwjYe.jpg\",\"latelyUpdate\":\"Chương 570\",\"title\":\"Tiểu Thanh Mai Ngốc Nghếch: Trúc Mã Yêu Nghiệt Quá Phúc Hắc\",\"shortDetail\":\"Tiểu Thanh Mai Ngốc Nghếch: Trúc Mã Yêu Nghiệt Quá Phúc Hắc\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/moitinhdanhmoncuccungtramtycuadethieuPc6NB8bHtG.jpg\",\"latelyUpdate\":\"Chương 322\",\"title\":\"Mối Tình Danh Môn: Cục Cưng Trăm Tỷ Của Đế Thiếu\",\"shortDetail\":\"Mối Tình Danh Môn: Cục Cưng Trăm Tỷ Của Đế Thiếu\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/hangtycungchieuvonamthanhonsau1016vnwahmR27.jpg\",\"latelyUpdate\":\"Chương 458\",\"title\":\"Hàng Tỷ Cưng Chiều Vợ: Nam Thần Hôn Sâu 101℃\",\"shortDetail\":\"Hàng Tỷ Cưng Chiều Vợ: Nam Thần Hôn Sâu 101℃\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/haomonanhonphuchactongtainuongchieubaxayhlf4V6AUk.jpg\",\"latelyUpdate\":\"Chương 398\",\"title\":\"Hào Môn Ẩn Hôn: Phúc Hắc Tổng Tài Nuông Chiều Bà Xã\",\"shortDetail\":\"Hào Môn Ẩn Hôn: Phúc Hắc Tổng Tài Nuông Chiều Bà Xã\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/thieuphunhanvolaiI1Kg9qAmpL.jpg\",\"latelyUpdate\":\"Chương 692\",\"title\":\"Thiếu Phu Nhân Vô Lại\",\"shortDetail\":\"Thiếu Phu Nhân Vô Lại\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/manhmeyeunhau100ngaysKZlERKeXI.jpg\",\"latelyUpdate\":\"Chương 1041\",\"title\":\"Mạnh Mẽ Yêu Nhau 100 Ngày\",\"shortDetail\":\"Mạnh Mẽ Yêu Nhau 100 Ngày\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/tonggiamdocdoattinhgianhlaivoyeuhmA6aDmqgf.jpg\",\"latelyUpdate\":\"Chương 730\",\"title\":\"Tổng Giám Đốc Đoạt Tình - Giành Lại Vợ Yêu\",\"shortDetail\":\"Tổng Giám Đốc Đoạt Tình - Giành Lại Vợ Yêu\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/namthancaolanhosatvachhonsai55lanmzHF1RD36D.jpg\",\"latelyUpdate\":\"Chương 892\",\"title\":\"Nam Thần Cao Lãnh Ở Sát Vách: Hôn Sai 55 Lần\",\"shortDetail\":\"Nam Thần Cao Lãnh Ở Sát Vách: Hôn Sai 55 Lần\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/savaotreugheovoyeutonggiamdocvocungcungchieuNMfUBgT7cD.jpg\",\"latelyUpdate\":\"Chương 1336\",\"title\":\"Sa Vào Trêu Ghẹo Vợ Yêu: Tổng Giám Đốc Vô Cùng Cưng Chiều\",\"shortDetail\":\"Sa Vào Trêu Ghẹo Vợ Yêu: Tổng Giám Đốc Vô Cùng Cưng Chiều\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/100ngayepyeusB6CbKzEC3.jpg\",\"latelyUpdate\":\"Chương 1041\",\"title\":\"Ép Yêu 100 Ngày\",\"shortDetail\":\"Ép Yêu 100 Ngày\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/amyenwo4IHM99AW.jpg\",\"latelyUpdate\":\"Chương 34\",\"title\":\"Ám Yến\",\"shortDetail\":\"Ám Yến\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/voquytdaycomongtaynhonthienphamquatanyTyv6XnHjV.jpg\",\"latelyUpdate\":\"Chương 25\",\"title\":\"Vỏ Quýt Dày Có Móng Tay Nhọn - Thiên Phàm Quá Tẫn\",\"shortDetail\":\"Vỏ Quýt Dày Có Móng Tay Nhọn - Thiên Phàm Quá Tẫn\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/nuquanvansu31Vz71Rhai.jpg\",\"latelyUpdate\":\"Chương 23\",\"title\":\"Nữ Quan Vận Sự\",\"shortDetail\":\"Nữ Quan Vận Sự\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/yeuemhontatcanhunggianhcomrpsnKaI2q.jpg\",\"latelyUpdate\":\"Chương 77\",\"title\":\"Yêu Em Hơn Tất Cả Những Gì Anh Có\",\"shortDetail\":\"Yêu Em Hơn Tất Cả Những Gì Anh Có\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/nguoidanongbuocratungonluaZHZgVnSJLu.jpg\",\"latelyUpdate\":\"Chương 12\",\"title\":\"Người Đàn Ông Bước Ra Từ Ngọn Lửa\",\"shortDetail\":\"Người Đàn Ông Bước Ra Từ Ngọn Lửa\"},{\"cover\":\"http://goctruyen.com/public/frontend/images/medium/trachnucuaanhDV9SBsY2tt.jpg\",\"latelyUpdate\":\"Chương 5\",\"title\":\"Trạch Nữ Của Anh\",\"shortDetail\":\"Trạch Nữ Của Anh\"}]";

        ArrayList<ItemCategory> list = GSON.fromJson(test, new TypeToken<ArrayList<ItemCategory>>(){}.getType());
        return list;
    }
}
