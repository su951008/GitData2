package comic_practice.mycomic.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 作者：Administrator Sulei 2017/3/1 11:30
 * <p>
 * 邮箱：211779494@qq.com
 */
public class ContentUtils {

    private static NetworkInfo networkInfo;

    public static boolean getContent(Context con){
        ConnectivityManager service = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = service.getActiveNetworkInfo();
        if(networkInfo!=null){
        return true  ;
        }
        else
            return  false;
    }
    }
