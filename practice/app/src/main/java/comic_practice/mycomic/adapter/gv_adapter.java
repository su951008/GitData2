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

/**
 * 作者：Administrator Sulei 2017/2/21 17:07
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class gv_adapter extends BaseAdapter {
    private Context con;
    private Classify cl ;

    public gv_adapter(Context con, Classify cl) {
        this.con = con;
        this.cl = cl;
    }

    @Override
    public int getCount() {
        return cl.getResult().size();
    }

    @Override
    public Object getItem(int position) {
        return cl.getResult().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        vo v;
        if(convertView==null){
            v=new vo();
            convertView=View.inflate(con, R.layout.glv,null);
            v.tv= (TextView) convertView.findViewById(R.id.tv_bookname);
            v.im= (ImageView) convertView.findViewById(R.id.im);
            convertView.setTag(v);
        }else
            v= (vo) convertView.getTag();
        v.tv.setText(cl.getResult().get(position));
        ImageLoader.getInstance().displayImage(cl.getImapath().get(position),v.im);
        return convertView;
    }
    class vo{
        TextView tv;
        ImageView im;
    }
}
