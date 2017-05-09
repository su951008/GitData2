package comic_practice.mycomic.Bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 作者：Administrator Sulei 2017/2/21 20:06
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class numberBook implements Serializable {
    private String url;
    private String name;
    ArrayList<Chapter> list;

    public numberBook(String url, String name, ArrayList<Chapter> list) {
        this.url = url;
        this.name = name;
        this.list = list;
    }

    public numberBook() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Chapter> getList() {
        return list;
    }

    public void setList(ArrayList<Chapter> list) {
        this.list = list;
    }
}
