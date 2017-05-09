package comic_practice.mycomic.Utils;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 作者：Administrator Sulei 2017/2/20 14:24
 * <p/>
 * 邮箱：211779494@qq.com
 */
public abstract class JsonUtil extends AsyncTask<String,Void,String>{
    public  String getInputString(InputStream in){
      byte[]   by=new byte[1024];
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    int len = 0;
    try {
        while((len=in.read(by))!=-1){
            b.write(by,0,len);
        }
        b.close();
        in.close();
        return  b.toString("Utf-8");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection http=null;
        try {
        http = (HttpURLConnection) new URL(params[0]).openConnection();
            if(http.getResponseCode()==200)
            {
             String  data=getInputString(http.getInputStream());
                return data;
            }
            else{
                return   "失败";
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        post(s);
    }
    public abstract void post(String jsonData);
}
