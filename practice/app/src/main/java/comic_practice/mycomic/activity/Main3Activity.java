package comic_practice.mycomic.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Random;

import comic_practice.mycomic.Bean.Chapter;
import comic_practice.mycomic.Bean.ChapterList;
import comic_practice.mycomic.Bean.Classify;
import comic_practice.mycomic.Bean.numberBook;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.SqUtil;
import comic_practice.mycomic.adapter.gv_adapter;
import okhttp3.Call;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, ViewPager.OnPageChangeListener {

    private String name,tpye,path;
    private Classify cl;
    private Cursor select;
    private GridView gv;
    public static numberBook book;
    private ArrayList<Chapter> arr;
    private ArrayList<ImageView> arrim;
    private RadioButton ra;
    private ViewPager vp;
    private LinearLayout lin;
    private String [] imageurl=new String[6];
    private int count;
   private Handler  han=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           count =vp.getCurrentItem()+1;
           if(count==imageurl.length)
               count =0;
           vp.setCurrentItem(count);
           han.sendEmptyMessageDelayed(0,4000);
       }
   };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        arrim=new ArrayList<>();
        ra = (RadioButton) findViewById(R.id.bt_fanhui);
        ra.setOnClickListener(this);
        name = getIntent().getStringExtra("name");
        initview();
        try {
            addDbUtils();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addDbUtils() throws Exception {
        SqUtil db = new SqUtil(this, "book");
        select = db.select("select * from book where type=? ", new String[]{name});
        addData();


    }

    private void addData() {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> url = new ArrayList<>();
        arr=new ArrayList<>();

        while (select.moveToNext()) {
            name.add(select.getString(1));
            url.add(select.getString(2));
        }
        cl = new Classify(name, url);
        for (int i = 0; i <imageurl.length ; i++) {
            View vi=new View(Main3Activity.this);
            vi.setBackgroundResource(R.drawable.selector);
            LinearLayout.LayoutParams  la=new LinearLayout.LayoutParams(10,10);
            la.rightMargin=10;
            lin.addView(vi,la);
           int  position= new Random().nextInt(cl.getResult().size()-1);
          imageurl[i]=cl.getImapath().get(position);
        }
        lin.getChildAt(0).setEnabled(false);
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageurl.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, final int position) {
                ImageView  im=new ImageView(Main3Activity.this);
                ImageLoader.getInstance().displayImage(imageurl[position],im);
                im.setScaleType(ImageView.ScaleType.FIT_XY);
                container.addView(im);
                return im;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

        });
        vp.addOnPageChangeListener(this);
        gv.setAdapter(new gv_adapter(this, cl));
        gv.setOnItemClickListener(this);
      han.sendEmptyMessageDelayed(0,5000);
    }

    private void initview() {
       gv = (GridView) findViewById(R.id.gv_main3);
       vp = (ViewPager) findViewById(R.id.vp_main3);
       lin = (LinearLayout) findViewById(R.id.lin_main3);
       ImageView im1 =  (ImageView) findViewById(R.id.image1);
       ImageView im2= (ImageView) findViewById(R.id.image2);
       ImageView im3= (ImageView) findViewById(R.id.image3);
       ImageView im4= (ImageView) findViewById(R.id.image4);
       ImageView im5= (ImageView) findViewById(R.id.image5);
       ImageView im6= (ImageView) findViewById(R.id.image6);
        arrim.add(im1);//添加imagview
        arrim.add(im2);
        arrim.add(im3);
        arrim.add(im4);
        arrim.add(im5);
        arrim.add(im6);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        path = "http://japi.juhe.cn/comic/chapter?comicName="+cl.getResult().get(position).trim()+"&key=bcac705b5f36c31f4101413b0f1e527d";
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                getGson(  position);
            }
        });





    }


    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i <arrim.size() ; i++) {
            lin.getChildAt(i).setEnabled(position==i?false:true);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    public void getGson(final int position) {
        try {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    OkHttpUtils.get().url(path).build().execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {}
                        @Override
                        public void onResponse(String response, int id) {
                            ChapterList list = new Gson().fromJson(response, ChapterList.class);
                            String name = cl.getResult().get(position);
                            String url = cl.getImapath().get(position);
                            for (int i = 0; i <list.getResult().getChapterList().size() ; i++) {
                                arr.add(new Chapter(list.getResult().getChapterList().get(i).getName(),list.getResult().getChapterList().get(i).getId()));
                            }
                            book=new numberBook(url,name,arr );
                            Intent it = new Intent(Main3Activity.this, Main4Activity.class);
                            startActivity(it);
                            overridePendingTransition(R.anim.kaishi, R.anim.jieshu);

                        }
                    });
                }
            }.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
