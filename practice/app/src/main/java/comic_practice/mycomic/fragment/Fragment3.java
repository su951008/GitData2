package comic_practice.mycomic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import comic_practice.mycomic.R;
import comic_practice.mycomic.activity.Main6Activity;

/**
 * 作者：Administrator Sulei 2017/2/16 14:46
 * <p>
 * 邮箱：211779494@qq.com
 */
public class Fragment3 extends Fragment implements View.OnClickListener {

    public static ImageView im;

    public static TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View vi=inflater.inflate(R.layout.fragment3,null);
        im = (ImageView) vi.findViewById(R.id.imagefrag3);
         tv= (TextView) vi.findViewById(R.id.frag3_denglu);
        return vi;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        im.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), Main6Activity.class));
    }
}
