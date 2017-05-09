package comic_practice.mycomic.Utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * 作者：Administrator Sulei 2017/2/24 15:09
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class SUtils {
    private static SUtils instance;
    private static final String BOOKLIST="booklist";
    private SharedPreferences preferences;
    private SUtils(Context content) {
        preferences=content.getSharedPreferences(BOOKLIST,Context.MODE_PRIVATE);
    }
    public static SUtils getInstance(Context context){
        if (instance==null){
            synchronized (SUtils.class){
                if (instance==null){
                    instance=new SUtils(context);
                }
            }
        }
        return instance;
    }
    public void changeData(String key,boolean value){
        preferences.edit().putBoolean(key,value).commit();
    }
    public void zhanghaoData(String key,String value){
        preferences.edit().putString(key,value).commit();
    }
    public boolean getData(String key){
        return preferences.getBoolean(key,false);
    }
    public String getname(String key){
        return preferences.getString(key,"");
    }
}
