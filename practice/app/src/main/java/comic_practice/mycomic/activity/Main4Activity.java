package comic_practice.mycomic.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import comic_practice.mycomic.Bean.numberBook;
import comic_practice.mycomic.R;
import comic_practice.mycomic.fragment.FragBookList;
import comic_practice.mycomic.fragment.Fragment2;
import comic_practice.mycomic.fragment.Fragment_mulu;
import comic_practice.mycomic.fragment.Fragmentjianjie;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    public static  numberBook book;
    public static String path;
    private TextView tv;
    private ImageView im;
    private Button bt1,bt2;
    private RadioButton ra;
    private ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initview();
        ra.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        if(Main3Activity.book!=null)
            book=Main3Activity.book;
        else if(FragBookList.books!=null)
            book =FragBookList.books;
        else
            book = Fragment2.book;
        ImageLoader.getInstance().displayImage(book.getUrl(),im);
        tv.setText(book.getName());

    }

    private void initview() {
        ra = (RadioButton) findViewById(R.id.bt_fanhui);
        bt1= (Button) findViewById(R.id.bt_mulv);
        bt2= (Button) findViewById(R.id.bt_jianjie);
        im = (ImageView) findViewById(R.id.im_main);
        tv = (TextView) findViewById(R.id.tv_main);
        vp = (ViewPager) findViewById(R.id.vp_main4);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment  fr=null;
                switch (position){
                    case 0:fr=new Fragment_mulu();
                        break;
                    case 1:fr=new Fragmentjianjie();
                        break;
                }
                return fr;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        vp.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_fanhui:
                finish();
            break;
            case R.id.bt_mulv:
                vp.setCurrentItem(0);
            break;
            case R.id.bt_jianjie:
                vp.setCurrentItem(1);
            break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
     if(position==1){
         bt1.setBackgroundResource(R.mipmap.btb);
         bt2.setBackgroundResource(R.mipmap.bt2__2);
     }else{
         bt1.setBackgroundResource(R.mipmap.bta);
         bt2.setBackgroundResource(R.mipmap.bt1__2);
     }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
