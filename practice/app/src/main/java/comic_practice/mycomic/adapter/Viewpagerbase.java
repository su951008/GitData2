package comic_practice.mycomic.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import comic_practice.mycomic.Utils.ImageUtils;

/**
 * 作者：Administrator Sulei 2017/2/16 19:07
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Viewpagerbase extends PagerAdapter {
    private Context con ;
    private String[]  image;

    public Viewpagerbase(String[] image, Context con) {
        this.image = image;
        this.con = con;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView  im=new ImageView(con);
        ImageLoader.getInstance().displayImage(image[position],im, ImageUtils.getImage());
        im.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(im);
        return im;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }
}
