package comic_practice.mycomic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import comic_practice.mycomic.Bean.numberBook;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.ImageUtils;


/**
 * 作者：Administrator Sulei 2017/2/19 10:13
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Xlv_adapter_frag2 extends BaseAdapter {
    private Context con;
    ArrayList<numberBook> arr;

    public Xlv_adapter_frag2(Context con, ArrayList<numberBook> arr) {
        this.con = con;
        this.arr = arr;

    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
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
        v.tv.setText(arr.get(position).getName());

        ImageLoader.getInstance().displayImage(arr.get(position).getUrl(),v.im, ImageUtils.getImage());
        return convertView;
    }
    class vo{
        TextView tv;
        ImageView im;

    }
}
