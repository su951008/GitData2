package comic_practice.mycomic.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import comic_practice.mycomic.Bean.Classify;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.SqUtil;


/**
 * 作者：Administrator Sulei 2017/2/19 10:13
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Xlv2_adapter extends BaseAdapter {
    private Context con;
    private   Classify csif;
    private  boolean[] isbool;

    public Xlv2_adapter(Context con, Classify  arr, boolean[] isbool) {
        this.con = con;
        this.csif = arr;
        this.isbool=isbool;
    }

    @Override
    public int getCount() {
        return csif.getResult().size();
    }

    @Override
    public Object getItem(int position) {
        return csif.getResult().get(position);
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
            v.bt= (Button) convertView.findViewById(R.id.bt_shoucang);
            v.tv= (TextView) convertView.findViewById(R.id.tv_bookname);
            v.im= (ImageView) convertView.findViewById(R.id.im);
            convertView.setTag(v);
        }else
        v= (vo) convertView.getTag();
        v.tv.setText(csif.getResult().get(position));
        v.bt.setEnabled(isbool[position]);
        final SqUtil booklist = new SqUtil(con, "booklist");
        v.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues cons=new ContentValues();
                cons.put("name",csif.getResult().get(position));
                cons.put("url",csif.getImapath().get(position));
                cons.put("position",position);
                booklist.insert("booklist", cons);
            }
        });
        if(booklist.select("select * from booklist", null)!=null){
        Cursor select = booklist.select("select * from booklist", null);
        while(select.moveToNext()) {
            if (select.getString(1).equals(csif.getResult().get(position))) {
                v.bt.setEnabled(false);
            }
        }
        }
        ImageLoader.getInstance().displayImage(csif.getImapath().get(position),v.im);
        return convertView;
    }
    class vo{
        TextView tv;
        ImageView im;
        Button  bt;
    }
}
