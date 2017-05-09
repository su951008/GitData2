package comic_practice.mycomic.Bean;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 作者：Administrator Sulei 2017/2/16 14:12
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Widget {
    private Button  bt;
    private ImageView  im;
    private LinearLayout lin;

    public Widget(Button bt, ImageView im, LinearLayout lin) {
        this.bt = bt;
        this.im = im;
        this.lin = lin;
    }

    public Widget() {
    }

    public Button getBt() {
        return bt;
    }

    public void setBt(Button bt) {
        this.bt = bt;
    }

    public ImageView getIm() {
        return im;
    }

    public void setIm(ImageView im) {
        this.im = im;
    }

    public LinearLayout getLin() {
        return lin;
    }

    public void setLin(LinearLayout lin) {
        this.lin = lin;
    }
}
