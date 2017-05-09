package comic_practice.mycomic.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import comic_practice.mycomic.Bean.Widget;
import comic_practice.mycomic.R;
import comic_practice.mycomic.fragment.Fragment1;
import comic_practice.mycomic.fragment.Fragment2;
import comic_practice.mycomic.fragment.Fragment3;

/**
 * 作者： Sulei
 * 2017/2/16
 * 11:50
 * 邮箱：211779494@qq.com
 */


public class TwoActivity extends FragmentActivity implements View.OnClickListener {

    private  Button bt_book, bt_update,bt_my;
    private   ArrayList<Widget> arrBt;
    private ImageView imbt1, imbt2, imbt3;
    private LinearLayout lin_bt1,lin_bt2,lin_bt3;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initview();//初始化控件
        initDate();//初始化数据
      }
    private void initDate() {
        focusble();//失去焦点

    }



    private void focusble() {

        bt_book.setFocusable(false);
        bt_update.setFocusable(false);
        bt_my.setFocusable(false);
        imbt1.setFocusable(false);
        imbt2.setFocusable(false);
        imbt3.setFocusable(false);

    }

    private void initview() {

        arrBt=new ArrayList<Widget>();
        bt_my= (Button) findViewById(R.id.bt_my);
        bt_update= (Button) findViewById(R.id.bt_update);
        bt_book= (Button) findViewById(R.id.bt_book);
        imbt1 = (ImageView) findViewById(R.id.imageBt1);
        imbt2= (ImageView) findViewById(R.id.imageBt2);
        imbt3= (ImageView) findViewById(R.id.imageBt3);
        lin_bt1= (LinearLayout) findViewById(R.id.lin_bt1);
        lin_bt2= (LinearLayout) findViewById(R.id.lin_bt2);
        lin_bt3= (LinearLayout) findViewById(R.id.lin_bt3);
        boolean isbool = ContentUtils.getContent(this);
        if(isbool) {
            lin_bt1.setOnClickListener(this);
            lin_bt2.setOnClickListener(this);
            lin_bt3.setOnClickListener(this);
        } else {
            Toast.makeText(TwoActivity.this, "网络无法连接请查看网络状态", Toast.LENGTH_SHORT).show();
        return;
        }
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,new Fragment1(),"Fragment1").commit();
        arrBt.add(new Widget(bt_book,imbt1,lin_bt1));
        arrBt.add(new Widget(bt_update,imbt2,lin_bt2));
        arrBt.add(new Widget(bt_my,imbt3,lin_bt3));
    }




    /*
    Fragment添加替换
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){

           case R.id.lin_bt1:
               manager.beginTransaction().replace(R.id.frameLayout,new Fragment1(),"frag1_1").commit();
               imbt1.setImageResource(R.mipmap.bt1_2);
               imbt2.setImageResource(R.mipmap.bt2);
               imbt3.setImageResource(R.mipmap.bt3);

            break;
           case R.id.lin_bt2:
               manager.beginTransaction().replace(R.id.frameLayout,new Fragment2(),"frag2").commit();
               imbt1.setImageResource(R.mipmap.bt1_1);
               imbt2.setImageResource(R.mipmap.bt2_2);
               imbt3.setImageResource(R.mipmap.bt3);
            break;
           case R.id.lin_bt3:
               manager.beginTransaction().replace(R.id.frameLayout,new Fragment3(),"frag3").commit();
               imbt1.setImageResource(R.mipmap.bt1_1);
               imbt2.setImageResource(R.mipmap.bt2);
               imbt3.setImageResource(R.mipmap.bt3_3);
            break;



        }
    }
}
