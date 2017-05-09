package comic_practice.mycomic.fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import comic_practice.mycomic.Bean.Chapter;
import comic_practice.mycomic.Bean.ChapterList;
import comic_practice.mycomic.Bean.XlvBook;
import comic_practice.mycomic.Bean.numberBook;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.JsonUtil;
import comic_practice.mycomic.Utils.SqUtil;
import comic_practice.mycomic.activity.Main4Activity;
import comic_practice.mycomic.adapter.XlvBook_adapter;
import okhttp3.Call;
import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * 作者：Administrator Sulei 2017/2/16 14:46
 * <p>
 * 邮箱：211779494@qq.com
 */
public class FragBookList extends Fragment{
    public static numberBook books;
    private String path="http://japi.juhe.cn/comic/book?key=bcac705b5f36c31f4101413b0f1e527d";
    private XListView xlv;
    private String []name =new String[]{"少年漫画","青年漫画","少女漫画","耽美漫画"};
    private SharedPreferences  sp;
    private List<XlvBook.ResultBean.BookListBean> bookList;
    private SharedPreferences.Editor edit;
    private SqUtil db;
    private int count ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  vi=inflater.inflate(R.layout.booklist,null);
        xlv = (XListView) vi.findViewById(R.id.xlvBook);
        return vi;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sp=getActivity().getSharedPreferences("su",0);
        edit = sp.edit();
        new JsonUtil() {
             @Override
             public void post(String jsonData) {
                 XlvBook xlvs = new Gson().fromJson(jsonData, XlvBook.class);
                 bookList = xlvs.getResult().getBookList();
                 for (int i = 0; i < bookList.size(); i++) {
                     Log.e("ss",bookList.toString());
                 }
                 xlv.setAdapter(new XlvBook_adapter(getActivity(), bookList));
     if(!sp.getBoolean("isbool",false))
                 addSQL();
                 XListViewListener();
             }
         }.execute(path);





    }
    private void XListViewListener() {
        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
        xlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
               path = "http://japi.juhe.cn/comic/chapter?comicName="+bookList.get(position).getName().trim()+"&key=bcac705b5f36c31f4101413b0f1e527d";
               OkHttpUtils.get().url(path).build().execute(new StringCallback() {
                   @Override
                   public void onError(Call call, Exception e, int id) {

                   }

                   @Override
                   public void onResponse(String response, int id) {
                       List<ChapterList.ResultBean.ChapterListBean> chapterList = new Gson().fromJson(response, ChapterList.class).getResult().getChapterList();
                       books=new numberBook();

                       books.setName(bookList.get(position).getName());
                       books.setUrl(bookList.get(position).getCoverImg());
                      ArrayList arr=new ArrayList<Chapter>();
                       for (int i = 0; i <chapterList.size() ; i++) {
                           arr.add(new Chapter(chapterList.get(i).getName(),chapterList.get(i).getId()));
                       }
                       books.setList(arr);
                       Intent it=new Intent(getActivity(), Main4Activity.class);
                       startActivity(it);
                   }
               });


            }
        });
        xlv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                xlv.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        xlv.stopRefresh();
                        xlv.setRefreshTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                xlv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updata();
                        xlv.stopLoadMore();
                    }

                    private void updata() {
                        if(count==4)
                            count=0;
                        count++;
                        Cursor book = new SqUtil(getActivity(), "book").select("select * from book where type=?", new String[]{name[count]});
                        bookList =new ArrayList<XlvBook.ResultBean.BookListBean>();
                        while(book.moveToNext()){
                            XlvBook.ResultBean.BookListBean bean = new XlvBook.ResultBean.BookListBean();
                            bean.setLastUpdate(book.getInt(0));
                            bean.setName(book.getString(1));
                            bean.setCoverImg(book.getString(2));
                            bean.setType(book.getString(3));
                            bookList.add(bean);
                        }
                        xlv.setAdapter(new XlvBook_adapter(getActivity(), bookList));
                    }
                },2000);
            }
        });

    }

    public void addSQL(){
        edit.putBoolean("isbool",true).commit();
        db = new SqUtil(getActivity(), "book");
        for (int i = 0; i <bookList.size() ; i++) {
            ContentValues values=new ContentValues();
            values.put("name",bookList.get(i).getName());
            values.put("url",bookList.get(i).getCoverImg());
            values.put("type",bookList.get(i).getType());
            db.insert("book",values );
            values=null;
        }
        String []pathcount=new String[]{
                "http://japi.juhe.cn/comic/book?name=&type=少女漫画&skip=&finish=&key=bcac705b5f36c31f4101413b0f1e527d",
                "http://japi.juhe.cn/comic/book?name=&type=青年漫画&skip=&finish=&key=bcac705b5f36c31f4101413b0f1e527d",
                "http://japi.juhe.cn/comic/book?name=&type=耽美漫画&skip=&finish=&key=bcac705b5f36c31f4101413b0f1e527d"
        };
        for (int i = 0; i < 3; i++) {
            OkHttpUtils.get().url(pathcount[i]).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                }

                @Override
                public void onResponse(String response, int id) {
                    List<XlvBook.ResultBean.BookListBean> list = new Gson().fromJson(response, XlvBook.class).getResult().getBookList();
                    for (int j = 0; j <list.size() ; j++) {
                        ContentValues values=new ContentValues();
                        values.put("name",list.get(j).getName());
                        values.put("url",list.get(j).getCoverImg());
                        values.put("type",list.get(j).getType());
                        db.insert("book",values );
                        values=null;
                }
            }});
            }
        }




    }



