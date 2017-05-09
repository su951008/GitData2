package comic_practice.mycomic.Bean;

import java.util.List;

/**
 * 作者：Administrator Sulei 2017/2/22 16:47
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Context {

    /**
     * error_code : 200
     * reason : 请求成功！
     * result : {"chapterId":228034,"comicName":"好漫画","imageList":[{"id":1,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/0-MjI4MDM0MA==.jpg"},{"id":2,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/1-MjI4MDM0MQ==.jpg"},{"id":3,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/2-MjI4MDM0Mg==.jpg"},{"id":4,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/3-MjI4MDM0Mw==.jpg"},{"id":5,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/4-MjI4MDM0NA==.jpg"},{"id":6,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/5-MjI4MDM0NQ==.jpg"},{"id":7,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/6-MjI4MDM0Ng==.jpg"},{"id":8,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/7-MjI4MDM0Nw==.jpg"},{"id":9,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/8-MjI4MDM0OA==.jpg"},{"id":10,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/9-MjI4MDM0OQ==.jpg"},{"id":11,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/10-MjI4MDM0MTA=.jpg"},{"id":12,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/11-MjI4MDM0MTE=.jpg"},{"id":13,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/12-MjI4MDM0MTI=.jpg"},{"id":14,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/13-MjI4MDM0MTM=.jpg"},{"id":15,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/14-MjI4MDM0MTQ=.jpg"},{"id":16,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/15-MjI4MDM0MTU=.jpg"},{"id":17,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/16-MjI4MDM0MTY=.jpg"},{"id":18,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/17-MjI4MDM0MTc=.jpg"},{"id":19,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/18-MjI4MDM0MTg=.jpg"},{"id":20,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/19-MjI4MDM0MTk=.jpg"},{"id":21,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/20-MjI4MDM0MjA=.jpg"},{"id":22,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/21-MjI4MDM0MjE=.jpg"},{"id":23,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/22-MjI4MDM0MjI=.jpg"},{"id":24,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/23-MjI4MDM0MjM=.jpg"},{"id":25,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/24-MjI4MDM0MjQ=.jpg"},{"id":26,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/25-MjI4MDM0MjU=.jpg"},{"id":27,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/26-MjI4MDM0MjY=.jpg"},{"id":28,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/27-MjI4MDM0Mjc=.jpg"},{"id":29,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/28-MjI4MDM0Mjg=.jpg"},{"id":30,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/29-MjI4MDM0Mjk=.jpg"},{"id":31,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/30-MjI4MDM0MzA=.jpg"},{"id":32,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/31-MjI4MDM0MzE=.jpg"},{"id":33,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/32-MjI4MDM0MzI=.jpg"},{"id":34,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/33-MjI4MDM0MzM=.jpg"},{"id":35,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/34-MjI4MDM0MzQ=.jpg"},{"id":36,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/35-MjI4MDM0MzU=.jpg"},{"id":37,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/36-MjI4MDM0MzY=.jpg"},{"id":38,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/37-MjI4MDM0Mzc=.jpg"},{"id":39,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/38-MjI4MDM0Mzg=.jpg"},{"id":40,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/39-MjI4MDM0Mzk=.jpg"},{"id":41,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/40-MjI4MDM0NDA=.jpg"},{"id":42,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/41-MjI4MDM0NDE=.jpg"},{"id":43,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/42-MjI4MDM0NDI=.jpg"},{"id":44,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/43-MjI4MDM0NDM=.jpg"},{"id":45,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/44-MjI4MDM0NDQ=.jpg"},{"id":46,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/45-MjI4MDM0NDU=.jpg"},{"id":47,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/46-MjI4MDM0NDY=.jpg"},{"id":48,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/47-MjI4MDM0NDc=.jpg"},{"id":49,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/48-MjI4MDM0NDg=.jpg"},{"id":50,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/49-MjI4MDM0NDk=.jpg"},{"id":51,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/50-MjI4MDM0NTA=.jpg"},{"id":52,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/51-MjI4MDM0NTE=.jpg"},{"id":53,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/52-MjI4MDM0NTI=.jpg"},{"id":54,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/53-MjI4MDM0NTM=.jpg"},{"id":55,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/54-MjI4MDM0NTQ=.jpg"},{"id":56,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/55-MjI4MDM0NTU=.jpg"},{"id":57,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/56-MjI4MDM0NTY=.jpg"},{"id":58,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/57-MjI4MDM0NTc=.jpg"},{"id":59,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/58-MjI4MDM0NTg=.jpg"},{"id":60,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/59-MjI4MDM0NTk=.jpg"},{"id":61,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/60-MjI4MDM0NjA=.jpg"},{"id":62,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/61-MjI4MDM0NjE=.jpg"},{"id":63,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/62-MjI4MDM0NjI=.jpg"},{"id":64,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/63-MjI4MDM0NjM=.jpg"},{"id":65,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/64-MjI4MDM0NjQ=.jpg"},{"id":66,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/65-MjI4MDM0NjU=.jpg"},{"id":67,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/66-MjI4MDM0NjY=.jpg"},{"id":68,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/67-MjI4MDM0Njc=.jpg"},{"id":69,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/68-MjI4MDM0Njg=.jpg"},{"id":70,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/69-MjI4MDM0Njk=.jpg"},{"id":71,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/70-MjI4MDM0NzA=.jpg"},{"id":72,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/71-MjI4MDM0NzE=.jpg"},{"id":73,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/72-MjI4MDM0NzI=.jpg"},{"id":74,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/73-MjI4MDM0NzM=.jpg"},{"id":75,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/74-MjI4MDM0NzQ=.jpg"},{"id":76,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/75-MjI4MDM0NzU=.jpg"},{"id":77,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/76-MjI4MDM0NzY=.jpg"},{"id":78,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/77-MjI4MDM0Nzc=.jpg"},{"id":79,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/78-MjI4MDM0Nzg=.jpg"},{"id":80,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/79-MjI4MDM0Nzk=.jpg"},{"id":81,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/80-MjI4MDM0ODA=.jpg"},{"id":82,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/81-MjI4MDM0ODE=.jpg"},{"id":83,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/82-MjI4MDM0ODI=.jpg"},{"id":84,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/83-MjI4MDM0ODM=.jpg"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    @Override
    public String toString() {
        return "Context{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public Context(int error_code, String reason, ResultBean result) {
        this.error_code = error_code;
        this.reason = reason;
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * chapterId : 228034
         * comicName : 好漫画
         * imageList : [{"id":1,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/0-MjI4MDM0MA==.jpg"},{"id":2,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/1-MjI4MDM0MQ==.jpg"},{"id":3,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/2-MjI4MDM0Mg==.jpg"},{"id":4,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/3-MjI4MDM0Mw==.jpg"},{"id":5,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/4-MjI4MDM0NA==.jpg"},{"id":6,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/5-MjI4MDM0NQ==.jpg"},{"id":7,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/6-MjI4MDM0Ng==.jpg"},{"id":8,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/7-MjI4MDM0Nw==.jpg"},{"id":9,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/8-MjI4MDM0OA==.jpg"},{"id":10,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/9-MjI4MDM0OQ==.jpg"},{"id":11,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/10-MjI4MDM0MTA=.jpg"},{"id":12,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/11-MjI4MDM0MTE=.jpg"},{"id":13,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/12-MjI4MDM0MTI=.jpg"},{"id":14,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/13-MjI4MDM0MTM=.jpg"},{"id":15,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/14-MjI4MDM0MTQ=.jpg"},{"id":16,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/15-MjI4MDM0MTU=.jpg"},{"id":17,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/16-MjI4MDM0MTY=.jpg"},{"id":18,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/17-MjI4MDM0MTc=.jpg"},{"id":19,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/18-MjI4MDM0MTg=.jpg"},{"id":20,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/19-MjI4MDM0MTk=.jpg"},{"id":21,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/20-MjI4MDM0MjA=.jpg"},{"id":22,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/21-MjI4MDM0MjE=.jpg"},{"id":23,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/22-MjI4MDM0MjI=.jpg"},{"id":24,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/23-MjI4MDM0MjM=.jpg"},{"id":25,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/24-MjI4MDM0MjQ=.jpg"},{"id":26,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/25-MjI4MDM0MjU=.jpg"},{"id":27,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/26-MjI4MDM0MjY=.jpg"},{"id":28,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/27-MjI4MDM0Mjc=.jpg"},{"id":29,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/28-MjI4MDM0Mjg=.jpg"},{"id":30,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/29-MjI4MDM0Mjk=.jpg"},{"id":31,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/30-MjI4MDM0MzA=.jpg"},{"id":32,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/31-MjI4MDM0MzE=.jpg"},{"id":33,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/32-MjI4MDM0MzI=.jpg"},{"id":34,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/33-MjI4MDM0MzM=.jpg"},{"id":35,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/34-MjI4MDM0MzQ=.jpg"},{"id":36,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/35-MjI4MDM0MzU=.jpg"},{"id":37,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/36-MjI4MDM0MzY=.jpg"},{"id":38,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/37-MjI4MDM0Mzc=.jpg"},{"id":39,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/38-MjI4MDM0Mzg=.jpg"},{"id":40,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/39-MjI4MDM0Mzk=.jpg"},{"id":41,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/40-MjI4MDM0NDA=.jpg"},{"id":42,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/41-MjI4MDM0NDE=.jpg"},{"id":43,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/42-MjI4MDM0NDI=.jpg"},{"id":44,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/43-MjI4MDM0NDM=.jpg"},{"id":45,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/44-MjI4MDM0NDQ=.jpg"},{"id":46,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/45-MjI4MDM0NDU=.jpg"},{"id":47,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/46-MjI4MDM0NDY=.jpg"},{"id":48,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/47-MjI4MDM0NDc=.jpg"},{"id":49,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/48-MjI4MDM0NDg=.jpg"},{"id":50,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/49-MjI4MDM0NDk=.jpg"},{"id":51,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/50-MjI4MDM0NTA=.jpg"},{"id":52,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/51-MjI4MDM0NTE=.jpg"},{"id":53,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/52-MjI4MDM0NTI=.jpg"},{"id":54,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/53-MjI4MDM0NTM=.jpg"},{"id":55,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/54-MjI4MDM0NTQ=.jpg"},{"id":56,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/55-MjI4MDM0NTU=.jpg"},{"id":57,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/56-MjI4MDM0NTY=.jpg"},{"id":58,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/57-MjI4MDM0NTc=.jpg"},{"id":59,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/58-MjI4MDM0NTg=.jpg"},{"id":60,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/59-MjI4MDM0NTk=.jpg"},{"id":61,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/60-MjI4MDM0NjA=.jpg"},{"id":62,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/61-MjI4MDM0NjE=.jpg"},{"id":63,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/62-MjI4MDM0NjI=.jpg"},{"id":64,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/63-MjI4MDM0NjM=.jpg"},{"id":65,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/64-MjI4MDM0NjQ=.jpg"},{"id":66,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/65-MjI4MDM0NjU=.jpg"},{"id":67,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/66-MjI4MDM0NjY=.jpg"},{"id":68,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/67-MjI4MDM0Njc=.jpg"},{"id":69,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/68-MjI4MDM0Njg=.jpg"},{"id":70,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/69-MjI4MDM0Njk=.jpg"},{"id":71,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/70-MjI4MDM0NzA=.jpg"},{"id":72,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/71-MjI4MDM0NzE=.jpg"},{"id":73,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/72-MjI4MDM0NzI=.jpg"},{"id":74,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/73-MjI4MDM0NzM=.jpg"},{"id":75,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/74-MjI4MDM0NzQ=.jpg"},{"id":76,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/75-MjI4MDM0NzU=.jpg"},{"id":77,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/76-MjI4MDM0NzY=.jpg"},{"id":78,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/77-MjI4MDM0Nzc=.jpg"},{"id":79,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/78-MjI4MDM0Nzg=.jpg"},{"id":80,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/79-MjI4MDM0Nzk=.jpg"},{"id":81,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/80-MjI4MDM0ODA=.jpg"},{"id":82,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/81-MjI4MDM0ODE=.jpg"},{"id":83,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/82-MjI4MDM0ODI=.jpg"},{"id":84,"imageUrl":"http://imgs.juheapi.com/comic_xin/usPC/rut/228034/83-MjI4MDM0ODM=.jpg"}]
         */

        private int chapterId;
        private String comicName;
        private List<ImageListBean> imageList;

        public ResultBean(int chapterId, String comicName, List<ImageListBean> imageList) {
            this.chapterId = chapterId;
            this.comicName = comicName;
            this.imageList = imageList;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getComicName() {
            return comicName;
        }

        public void setComicName(String comicName) {
            this.comicName = comicName;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
        }

        public static class ImageListBean {
            /**
             * id : 1
             * imageUrl : http://imgs.juheapi.com/comic_xin/usPC/rut/228034/0-MjI4MDM0MA==.jpg
             */

            private int id;
            private String imageUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }
    }
}
