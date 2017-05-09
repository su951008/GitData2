package comic_practice.mycomic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import comic_practice.mycomic.Bean.Classify;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.ImageUtils;


/**
 * 作者：Administrator Sulei 2017/2/19 10:13
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Xlv_adapter extends BaseAdapter {
    private Context con;
    private   Classify csif;


    public Xlv_adapter(Context con,Classify  arr ) {
        this.con = con;
        this.csif = arr;

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
            convertView=View.inflate(con, R.layout.xlv2,null);
            v.tv= (TextView) convertView.findViewById(R.id.tv_bookname);
            v.im= (ImageView) convertView.findViewById(R.id.im);
            convertView.setTag(v);
        }else
        v= (vo) convertView.getTag();
        v.tv.setText(csif.getResult().get(position));
        ImageLoader.getInstance().displayImage(csif.getImapath().get(position),v.im, ImageUtils.getImage());
        return convertView;
    }
    class vo{
        TextView tv;
        ImageView im;

    }
}
