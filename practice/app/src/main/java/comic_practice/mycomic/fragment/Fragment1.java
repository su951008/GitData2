package comic_practice.mycomic.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import comic_practice.mycomic.R;

/**
 * 作者：Administrator Sulei 2017/2/16 14:46
 * <p>
 * 邮箱：211779494@qq.com
 */
public class Fragment1 extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private View vi;
    private ViewPager vp;
    private TextView title_two,title,tv_prog,tv_prog2;
    LinearLayout  lintitle,lintitle2;
    private ArrayList<TextView> tvColor,tvshow;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vi = inflater.inflate(R.layout.fragment1,null);
        initview();
        initdata();
        return vi;
    }

    private void initdata() {
        tvColor = new ArrayList<>();
        tvshow = new ArrayList<>();
        tvColor.add(title);
        tvColor.add(title_two);
        tvshow.add(tv_prog);
        tvshow.add(tv_prog2);

    }

    private void tv_updateColor(int id) {
        for (TextView tv:tvColor) {
            if(tv.getId()==id){
                tv.setTextColor(getResources().getColor(R.color.colortv2));
            }else
                tv.setTextColor(getResources().getColor(R.color.colortv1));

        }
    }
    private void tv_updateshow(int id) {
        for (TextView tv:tvshow) {
            if(tv.getId()==id){
               tv.setVisibility(View.VISIBLE);
            }else
            {
                tv.setVisibility(View.GONE);
            }
        }
    }

    private void initview() {

        title = (TextView) vi.findViewById(R.id.tv_frag1_title);
        title_two = (TextView) vi.findViewById(R.id.tv_frag1_title2);
        lintitle = (LinearLayout) vi.findViewById(R.id.linfenlei);
        lintitle2 = (LinearLayout) vi.findViewById(R.id.shudan);
        tv_prog = (TextView) vi.findViewById(R.id.tv_prog1);
        tv_prog2 = (TextView) vi.findViewById(R.id.tv_prog2);
        vp = (ViewPager) vi.findViewById(R.id.vp_Frag1);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        lintitle.setOnClickListener(this);
        lintitle2.setOnClickListener(this);
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fr=null;
                switch (position){
                    case 0:fr=new Fragclassify();
                    break;
                    case 1:fr=new FragBookList();
                    break;
                }
                return fr;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        vp.setOnPageChangeListener(this);
 }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.linfenlei:
        vp.setCurrentItem(0);
        tv_updateColor(v.getId());
        tv_updateshow(R.id.tv_prog1);
        title.setTextColor(Color.BLUE);
    break;
    case R.id.shudan:
        tv_updateColor(v.getId());
        tv_updateshow(R.id.tv_prog2);
        vp.setCurrentItem(1);
    break;
}

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
      switch (position){
          case 0:tv_updateColor(tvColor.get(position).getId());
                 tv_updateshow(R.id.tv_prog1);
          break;
          case 1:tv_updateColor(tvColor.get(position).getId());
              tv_updateshow(R.id.tv_prog2);
          break;
      }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
