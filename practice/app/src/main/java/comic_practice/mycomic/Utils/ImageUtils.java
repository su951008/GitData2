package comic_practice.mycomic.Utils;


import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * 作者：Administrator Sulei 2017/2/24 19:37
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class ImageUtils {
    public static DisplayImageOptions getImage(){
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true).build();
        return options;

    }
}
