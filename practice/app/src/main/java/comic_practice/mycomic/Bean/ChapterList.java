package comic_practice.mycomic.Bean;

import java.util.List;

/**
 * 作者：Administrator Sulei 2017/2/21 19:02
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class ChapterList {

    /**
     * error_code : 200
     * reason : 请求成功！
     * result : {"total":21,"comicName":"怪物大师","chapterList":[{"name":"第1话 影王村,背棺材的少年","id":227884},{"name":"第2话 奇怪的绿疹病","id":240988},{"name":"第03话 爸爸的留言","id":245424},{"name":"第04话 饺子的回报","id":262621},{"name":"第05话珍珠大峡谷","id":264681},{"name":"第7话布布路的惊人绝技","id":268938},{"name":"第8话 乱七八糟的孵化方法","id":271398},{"name":"第09话 诞生了?布布路的怪物","id":274838},{"name":"第10话 双子兄弟的\"刁难\"","id":276851},{"name":"第11话 对战的法则","id":279820},{"name":"第12话 十连败的大叔","id":285486},{"name":"第13话 饺子的剧本","id":288855},{"name":"第14话 五分钟的获胜之道","id":311642},{"name":"第15话 布布路的全面攻击","id":313321},{"name":"第16话 不听话的怪物","id":314465},{"name":"第17话 再见了!巴巴里金狮!","id":320516},{"name":"第18话 前进!四人同盟!","id":327686},{"name":"第19话 棺材里的导师","id":328962},{"name":"第20话 杂物室的奖牌","id":330895},{"name":"第21话 死亡墓地","id":334096}],"limit":20}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ChapterList{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class ResultBean {
        /**
         * total : 21
         * comicName : 怪物大师
         * chapterList : [{"name":"第1话 影王村,背棺材的少年","id":227884},{"name":"第2话 奇怪的绿疹病","id":240988},{"name":"第03话 爸爸的留言","id":245424},{"name":"第04话 饺子的回报","id":262621},{"name":"第05话珍珠大峡谷","id":264681},{"name":"第7话布布路的惊人绝技","id":268938},{"name":"第8话 乱七八糟的孵化方法","id":271398},{"name":"第09话 诞生了?布布路的怪物","id":274838},{"name":"第10话 双子兄弟的\"刁难\"","id":276851},{"name":"第11话 对战的法则","id":279820},{"name":"第12话 十连败的大叔","id":285486},{"name":"第13话 饺子的剧本","id":288855},{"name":"第14话 五分钟的获胜之道","id":311642},{"name":"第15话 布布路的全面攻击","id":313321},{"name":"第16话 不听话的怪物","id":314465},{"name":"第17话 再见了!巴巴里金狮!","id":320516},{"name":"第18话 前进!四人同盟!","id":327686},{"name":"第19话 棺材里的导师","id":328962},{"name":"第20话 杂物室的奖牌","id":330895},{"name":"第21话 死亡墓地","id":334096}]
         * limit : 20
         */

        private int total;
        private String comicName;
        private int limit;
        private List<ChapterListBean> chapterList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "total=" + total +
                    ", comicName='" + comicName + '\'' +
                    ", limit=" + limit +
                    ", chapterList=" + chapterList +
                    '}';
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getComicName() {
            return comicName;
        }

        public void setComicName(String comicName) {
            this.comicName = comicName;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public List<ChapterListBean> getChapterList() {
            return chapterList;
        }

        public void setChapterList(List<ChapterListBean> chapterList) {
            this.chapterList = chapterList;
        }

        public static class ChapterListBean {
            @Override
            public String toString() {
                return
                        "章节名称      " + name + '\'' +
                        " 图书ID" + id ;
            }

            /**
             * name : 第1话 影王村,背棺材的少年
             * id : 227884
             */

            private String name;
            private int id;

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
    }
}
