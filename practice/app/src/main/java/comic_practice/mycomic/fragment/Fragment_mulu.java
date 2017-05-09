package comic_practice.mycomic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import comic_practice.mycomic.Bean.Chapter;
import comic_practice.mycomic.Bean.numberBook;
import comic_practice.mycomic.R;
import comic_practice.mycomic.activity.Main4Activity;
import comic_practice.mycomic.activity.Main5Activity;

/**
 * 作者：Administrator Sulei 2017/2/22 18:01
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Fragment_mulu extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listview;
    public static  numberBook book;
    public static  String path;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View vi=View.inflate(getActivity(),R.layout.mulufrag,null);
        listview = (ListView)vi. findViewById(R.id.listview);
        return  vi;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(Main4Activity.book!=null)
            book= Main4Activity.book;
        else if(FragBookList.books!=null)
            book =FragBookList.books;
        else
            book =Fragment2.book;

        listview.setAdapter(new ArrayAdapter<Chapter>(getActivity(),android.R.layout.simple_list_item_1,
                book.getList() ));
        listview.setOnItemClickListener(this);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        path = "http://japi.juhe.cn/comic/chapterContent?comicName="+book.getName()+"&id="+book.getList().get(position).getId()+"&key=124459043dbf88240bcbf6a3c6bd10cd";
        Intent it=new Intent(getActivity(), Main5Activity.class);
        getActivity().startActivity(it);
    }
    }

