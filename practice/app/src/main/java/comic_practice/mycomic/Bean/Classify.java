package comic_practice.mycomic.Bean;

import java.util.ArrayList;

/**
 * 作者：Administrator Sulei 2017/2/21 10:46
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Classify {
    private ArrayList<String> result;
    private ArrayList<String> imapath;
    public ArrayList<String> getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "result=" + result +
                ", imapath='" + imapath + '\'' +
                '}';
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
    }

    public ArrayList<String> getImapath() {
        return imapath;
    }

    public void setImapath(ArrayList<String> imapath) {
        this.imapath = imapath;
    }

    public Classify(ArrayList<String> result, ArrayList<String> imapath) {
        this.result = result;
        this.imapath = imapath;
    }
}
