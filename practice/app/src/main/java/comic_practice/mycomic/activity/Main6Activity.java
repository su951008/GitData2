package comic_practice.mycomic.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.DbUtils;

import java.util.List;

import comic_practice.mycomic.Bean.User;
import comic_practice.mycomic.R;
import comic_practice.mycomic.fragment.Fragment3;

public class Main6Activity extends Activity implements View.OnClickListener {
private EditText  name,pwd;
private Button denglu ;
private TextView  zhuce;
private ImageView  im_drawable;

    private DbUtils user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6);
        initview();
           denglu.setOnClickListener(this);
          zhuce.setOnClickListener(this);
    }

    private void initview() {
        name= (EditText) findViewById(R.id.et_zhanghao);
        pwd= (EditText) findViewById(R.id.et_mima);
        denglu = (Button) findViewById(R.id.button);

        zhuce = (TextView) findViewById(R.id.tv_zhuce);
        im_drawable = (ImageView) findViewById(R.id.im_main6);
        user = DbUtils.create(this, "user");
        try {
            user.createTableIfNotExist(User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                denglu();
            break;
            case  R.id.tv_zhuce:
                zhuce();
            break;
        }
    }

    private void zhuce() {
        View vi=View.inflate(this,R.layout.popu,null);
        final EditText  name= (EditText) vi.findViewById(R.id.et_popu_name),pwd= (EditText) vi.findViewById(R.id.et_popu_pwd);
        Button bt= (Button) vi.findViewById(R.id.button2);
        final PopupWindow  pw=new PopupWindow(vi,400,400);
        pw.setTouchable(true);
        pw.setFocusable(true);
        pw.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names =name.getText().toString().trim();
                String pwds =pwd.getText().toString().trim();
                if(names.isEmpty()||pwds.isEmpty()) {
                    Toast.makeText(Main6Activity.this, "账号或密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    user.save(new User(names,pwds));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(Main6Activity.this, "注册成功", Toast.LENGTH_SHORT).show();
                pw.dismiss();

            }

        });
        pw.showAsDropDown(denglu);
    }

    private void denglu() {

        String names=name.getText().toString().trim();
        String pwds=pwd.getText().toString().trim();

        if(TextUtils.isEmpty(names)||TextUtils.isEmpty(pwds)){
            Fragment3.tv.setVisibility(View.VISIBLE);
            Fragment3.im.setImageResource(R.mipmap.touxiang1);
            return;
        }
        try {
boolean  isbool=true;
            if(user.findAll(User.class)!=null){
                List<User> all = user.findAll(User.class);
                for (int i = 0; i <all.size(); i++) {
                    if(all.get(i).getName().equals(names)&&all.get(i).getPwd().equals(pwds)){


                        Toast.makeText(Main6Activity.this, "登录成功", Toast.LENGTH_SHORT).show();

                        Fragment3.tv.setVisibility(View.GONE);

                        isbool=false;
                        finish();
                    }
                }
            }
            if(isbool) {
                Toast.makeText(Main6Activity.this, "账号或密码不正确", Toast.LENGTH_SHORT).show();
                Fragment3.im.setImageResource(R.mipmap.touxiang1);
            }
            } catch (Exception e) {
            e.printStackTrace();
            }

        }

    }

