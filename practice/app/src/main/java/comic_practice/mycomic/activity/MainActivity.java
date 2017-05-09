package comic_practice.mycomic.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.util.Timer;
import java.util.TimerTask;

import comic_practice.mycomic.R;
import comic_practice.mycomic.adapter.Viewpagerbase;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewpager_page;
    private Button bt_experience;
    private Button bt_jump;
    private TextView tv;
    int count=3;

    private String[] image;
    private Intent it;
    private String path ="http://cdn.duitang.com/uploads/item/201409/19/20140919085615_TSwNG.jpeg";
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        addpagedata();

    }

    private void addpagedata() {
        SharedPreferences comic = getSharedPreferences("comic", 0);
        edit = comic.edit();
        it = new Intent(MainActivity.this,TwoActivity.class);
        if(comic.getBoolean("isbool",false)) {
            bt_jump.setVisibility(View.GONE);
                           viewpager_page.setAdapter(new PagerAdapter() {



                               @Override
                               public int getCount() {
                                   return 1;
                               }

                               @Override
                               public boolean isViewFromObject(View view, Object object) {
                                   return view==object;
                               }

                               @Override
                               public Object instantiateItem(ViewGroup container, int position) {
                                    View vi=View.inflate(MainActivity.this,R.layout.view,null);
                                    ImageView  im= (ImageView) vi.findViewById(R.id.im_main1);
                                   im.setImageResource(R.mipmap.sishen);
                                   im.setScaleType(ImageView.ScaleType.FIT_XY);
                                   tv = (TextView) vi.findViewById(R.id.texts);
                                   container.addView(vi);
                                   return vi;
                               }

                               @Override
                               public void destroyItem(ViewGroup container, int position, Object object) {
                                  container.removeView((View) object);
                               }
                           });
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         if(count==0){
                             startActivity(it);
                             finish();
                         }

                         tv.setText(count+" ");
                         count--;
                     }
                 });
                }
            },1000,1000);

        }else {
            image = new String[]{
                    "http://i.gtimg.cn/qqlive/img/jpgcache/files/qqvideo/z/zb9kc4rtijwlcja.jpg",
                    "http://mhdtestks3.1391.com/upload/mhd/dh/jdt/zhanchihong.jpg",
                    "http://mhd.ufile.ucloud.com.cn/upload/mhd/dh/tjt/rccs.jpg"};

            viewpager_page.setAdapter(new Viewpagerbase(image, MainActivity.this));
            viewpager_page.setOnPageChangeListener(this);
            bt_experience.setOnClickListener(this);
            bt_jump.setOnClickListener(this);
        }
    }

    private void initview() {
        viewpager_page = (ViewPager) findViewById(R.id.viewpager_page);
        bt_experience = (Button) findViewById(R.id.bt_experience);
        bt_jump = (Button) findViewById(R.id.bt_jump);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==0)

            bt_jump.setVisibility(View.VISIBLE);
        else
            bt_jump.setVisibility(View.GONE);

        if(position== image.length-1){
            bt_experience.setVisibility(View.VISIBLE);
        }else
            bt_experience.setVisibility(View.GONE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
         case R.id.bt_experience:
             edit.putBoolean("isbool",true).commit();
             startActivity(it);
            break;
         case R.id.bt_jump:
             edit.putBoolean("isbool",true).commit();
             startActivity(it);
            break;
        }
    }
}
