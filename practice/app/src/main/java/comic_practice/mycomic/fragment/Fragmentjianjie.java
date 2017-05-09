package comic_practice.mycomic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comic_practice.mycomic.R;

/**
 * 作者：Administrator Sulei 2017/2/22 18:02
 * <p/>
 * 邮箱：211779494@qq.com
 */
public class Fragmentjianjie extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View  vi=View.inflate(getActivity(), R.layout.fragment_jiemian,null);

        return  vi;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
