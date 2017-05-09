package comic_practice.mycomic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import comic_practice.mycomic.Bean.Classify;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.JsonUtil;
import comic_practice.mycomic.activity.Main3Activity;
import comic_practice.mycomic.adapter.Xlv_adapter;
import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * 作者：Administrator Sulei 2017/2/16 14:46
 * <p>
 * 邮箱：211779494@qq.com
 */
public  class Fragclassify extends Fragment{

    private XListView xlv;
    private Classify csif;

    private String path="http://japi.juhe.cn/comic/category?key=bcac705b5f36c31f4101413b0f1e527d";
    private ArrayList<String> arr=new ArrayList();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  vi=inflater.inflate(R.layout.classify,container,false);
        xlv = (XListView) vi.findViewById(R.id.xlv);


        return vi;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addImage();
        try {
          new JsonUtil() {
              @Override
              public void post(String jsonData) {
                 csif = new Gson().fromJson(jsonData,Classify.class);
                 csif.setImapath(arr);
                 xlv.setAdapter(new Xlv_adapter(getActivity(), csif));
                  XListViewListener();
              }
          }.execute(path);


        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    private void XListViewListener() {
     xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
        xlv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                xlv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xlv.stopRefresh();
                        xlv.setRefreshTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    }

                },2000);
            }

            @Override
            public void onLoadMore() {
                xlv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xlv.stopLoadMore();
                    }
                },2000);
            }
        });
        xlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(getActivity(), Main3Activity.class);
                if(position==0)
                    position++;
                int positions=position-1;
                it.putExtra("name", csif.getResult().get(positions));

                getActivity().startActivity(it);
            }
        });
    }

    private void addImage() {
        arr.add( "http://www.zazhipu.com/bookpic/201012/2010127212538.jpg");
        arr.add( "http://i02.pic.sogou.com/86fc21dab8aef1c1");
        arr.add(  "http://i03.pic.sogou.com/b99885920abfd941");
        arr.add( "http://www.txtbaby.com/attachment/Fid_132/132_463599_c355e0f38028848.jpg");
    }


}
