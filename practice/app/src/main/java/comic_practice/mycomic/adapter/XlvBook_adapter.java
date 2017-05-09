package comic_practice.mycomic.adapter;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import comic_practice.mycomic.Bean.XlvBook;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.ImageUtils;
import comic_practice.mycomic.Utils.SUtils;

/**
 * 作者：Administrator Sulei 2017/2/19 10:13
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class XlvBook_adapter extends BaseAdapter {
    private Context con;
    private List<XlvBook.ResultBean.BookListBean> bookList ;
    private boolean []  isbool;
    private Button bt;

    public XlvBook_adapter(Context con,  List<XlvBook.ResultBean.BookListBean> bookList ) {
        this.con = con;
        this.bookList = bookList;
    }



    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        vo v;
        if(convertView==null){
         v=new vo();
            convertView=View.inflate(con, R.layout.xlv,null);
            v.tv= (TextView) convertView.findViewById(R.id.tv_bookname);
            v.im= (ImageView) convertView.findViewById(R.id.im);
            v.bt = (Button) convertView.findViewById(R.id.bt_shoucang);
            convertView.setTag(v);
        }else{
            v= (vo) convertView.getTag();
        }
        if (SUtils.getInstance(con).getData(bookList.get(position).getName())){

            v.bt.setBackgroundResource(R.mipmap.bt_shou2);

        }else{

            v.bt.setBackgroundResource(R.mipmap.bt_shou1);

        }
        v.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                if(SUtils.getInstance(con).getData(bookList.get(position).getName())){
                    AlertDialog.Builder ad=new AlertDialog.Builder(con);
                    ad.setTitle("是否取消收藏");
                    ad.setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SUtils.getInstance(con).changeData(bookList.get(position).getName(),
                                    !SUtils.getInstance(con).getData(bookList.get(position).getName()));

                            notifyDataSetChanged();
                        }
                    });
                    ad.setNegativeButton("否", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                              return;
                        }
                    });
                    ad.show();
                }else {
                    SUtils.getInstance(con).changeData(bookList.get(position).getName(),
                            !SUtils.getInstance(con).getData(bookList.get(position).getName()));
                    notifyDataSetChanged();
                }
                }

        });
        v.tv.setText(bookList.get(position).getName());
      ImageLoader.getInstance().displayImage(bookList.get(position).getCoverImg(),v.im, ImageUtils.getImage());
        return convertView;
    }
    class vo{
        TextView tv;
        ImageView im;
        Button bt;
    }
}
