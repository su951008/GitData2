package comic_practice.mycomic.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import comic_practice.mycomic.Bean.Chapter;
import comic_practice.mycomic.Bean.ChapterList;
import comic_practice.mycomic.Bean.numberBook;
import comic_practice.mycomic.R;
import comic_practice.mycomic.Utils.SUtils;
import comic_practice.mycomic.Utils.SqUtil;
import comic_practice.mycomic.activity.Main4Activity;
import comic_practice.mycomic.adapter.Xlv_adapter_frag2;
import okhttp3.Call;
import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * 作者：Administrator Sulei 2017/2/16 14:46
 * <p>
 * 邮箱：211779494@qq.com
 */
public class Fragment2 extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    public static numberBook book;
    private XListView xlv;
    private ArrayList<numberBook> arr;
    ArrayList<Chapter> lists;
    private Xlv_adapter_frag2 frag2;
    private Cursor book1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment2, null);
        xlv = (XListView) vi.findViewById(R.id.xlv2);
        return vi;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lists = new ArrayList<>();
        book1 = new SqUtil(getActivity(), "book").select("select * from book", null);
        if (book1 == null)
            return;
        numberBook numberBook = new numberBook();
        selectAdd(book1);
        frag2 = new Xlv_adapter_frag2(getActivity(), arr);
        xlv.setAdapter(frag2);
        xlv.setOnItemClickListener(this);
        xlv.setOnItemLongClickListener(this);
    }

    private void selectAdd(Cursor book) {
        arr = new ArrayList<>();
        while (book.moveToNext()) {
            if (SUtils.getInstance(getActivity()).getData(book.getString(1))) {
                arr.add(new numberBook(book.getString(2), book.getString(1), null));
            }

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        String path = "http://japi.juhe.cn/comic/chapter?comicName=" + arr.get(position - 1).getName() + "&key=bcac705b5f36c31f4101413b0f1e527d";
        OkHttpUtils.get().url(path).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

                ChapterList list = new Gson().fromJson(response, ChapterList.class);
                String name = arr.get(position - 1).getName();
                String url = arr.get(position - 1).getUrl();
                List<ChapterList.ResultBean.ChapterListBean> chapterList = list.getResult().getChapterList();
                for (int i = 0; i < list.getResult().getChapterList().size(); i++) {
                    lists.add(new Chapter(chapterList.get(position - 1).getName(), chapterList.get(position - 1).getId()));
                }
                book = new numberBook(url, name, lists);
                Intent it = new Intent(getActivity(), Main4Activity.class);
                getActivity().startActivity(it);
            }

        });
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
        ad.setTitle("是否删除");
        ad.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SUtils.getInstance(getActivity()).changeData(arr.get(position-1).getName(),
                        !SUtils.getInstance(getActivity()).getData(arr.get(position-1).getName()));

                arr.remove(position-1);
                frag2.notifyDataSetChanged();


            }
        });
        ad.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        ad.show();

        return true;
    }
}
