package comic_practice.mycomic.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import comic_practice.mycomic.Bean.Context;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.ImageUtils;
import comic_practice.mycomic.fragment.Fragment_mulu;
import okhttp3.Call;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {

    private List<Context.ResultBean.ImageListBean> list;
    RadioButton ra;
    private SeekBar se;
    private boolean  isbool ;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ra = (RadioButton) findViewById(R.id.bt_fanhui);
        tv = (TextView) findViewById(R.id.tv_main_count);
        se = (SeekBar) findViewById(R.id.senk);
        ra.setOnClickListener(this);
        String path = Fragment_mulu.path;
        final ViewPager vp= (ViewPager) findViewById(R.id.vp_main5);
        OkHttpUtils.get().url(path).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                list = new Gson().fromJson(response, Context.class).getResult().getImageList();
               tv.setText("1/"+list.size());
                vp.setAdapter(new PagerAdapter() {
                    @Override
                    public int getCount() {
                        return list.size();
                    }

                    @Override
                    public boolean isViewFromObject(View view, Object object) {
                        return view==object;
                    }

                    @Override
                    public Object instantiateItem(ViewGroup container, int position) {
                        ImageView imageView = new ImageView(Main5Activity.this);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImageLoader.getInstance().displayImage(list.get(position).getImageUrl(),imageView, ImageUtils.getImage());
                        imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isbool) {
                            se.setVisibility(View.VISIBLE);
                            isbool=false;
                        }
                        else {
                            se.setVisibility(View.GONE);
                            isbool=true;
                        }
                    }
                });
                        container.addView(imageView);
                        return  imageView;
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position, Object object) {

                        container.removeView((View) object);
                    }
                });
                se.setMax(list.size());

                se.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        se.setProgress(progress);
                        vp.setCurrentItem(progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

                    @Override
                    public void onPageSelected(int position) {
                        tv.setText(position+1+"/"+list.size());
                        se.setProgress(position);
                         if(position==list.size()-1){
                             AlertDialog.Builder  al=new AlertDialog.Builder(Main5Activity.this);
                       al.setTitle("是否返回目录界面");
                             al.setPositiveButton("是", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialog, int which) {
                                     finish();
                                 }
                             });
                             al.setNegativeButton("否", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialog, int which) {

                                 }
                             });
                             al.show();
                         }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        });


        //获取String

    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
