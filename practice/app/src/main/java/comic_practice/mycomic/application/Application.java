package comic_practice.mycomic.application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

 /**
  * 类的作用:初始化ImageLoader
  * 作者： Sulei
  * 2017/2/19
  * 9:43
  * 邮箱：211779494@qq.com
  */


public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration  im=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(im);
}
        }
