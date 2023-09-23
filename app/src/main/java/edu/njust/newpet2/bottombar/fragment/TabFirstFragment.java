package edu.njust.newpet2.bottombar.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.suke.widget.SwitchButton;

import edu.njust.newpet2.R;


public class TabFirstFragment extends Fragment {
    private static final String TAG = "TabFirstFragment";
    protected View view; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象

    private LinearLayout myLinearLayout;
    private TextView myTextView;
    private boolean isClicked = false;
    private RelativeLayout relativeLayout1,relativeLayout2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity(); // 获取活动页面的上下文
        // 根据布局文件fragment_tab_first.xml生成视图对象
        view = inflater.inflate(R.layout.fragment_tab_first, container, false);
        myLinearLayout = view.findViewById(R.id.myLinearLayout);

        myLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 切换背景
                if (isClicked) {

                } else {

                }
                isClicked = !isClicked;
            }
        });

        return view;
    }


    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        ImageView floatingbutton =getActivity().findViewById(R.id.floatingButton);


    }


    @Override
    public void onResume() {
        super.onResume();
//        Bundle bundle = getActivity().getIntent().getExtras();
//        if (bundle!=null){
//            int temperature = bundle.getInt("temperature");
//            exacttemp.setText(temperature+" ℃");
//        }
    }
}
