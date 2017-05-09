package comic_practice.mycomic.Bean;

/**
 * 作者：Administrator Sulei 2017/2/22 13:44
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Chapter {
    private String name;
    private int id;
        @Override
        public String toString() {
            return
                    "章节名称      " + name + '\'' +
                            " 图书ID" + id ;
        }

    public Chapter(String name, int id) {
        this.name = name;
        this.id = id;
    }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

}
