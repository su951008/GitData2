package comic_practice.mycomic.Bean;

/**
 * 作者：Administrator Sulei 2017/2/27 19:44
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class User {
    private int id;
    private String name;
    private String pwd;

    public User() {
    }

    public User(  String name, String pwd) {

        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
