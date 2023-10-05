package edu.njust.newpet2.bottombar.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import edu.njust.newpet2.R;


public class TabFirstFragment extends Fragment {
    private static final String TAG = "TabFirstFragment";
    protected View view; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象

    private LinearLayout myLinearLayout11,myLinearLayout12;
    private LinearLayout myLinearLayout21,myLinearLayout22;
    private LinearLayout myLinearLayout31,myLinearLayout32;
    private LinearLayout myLinearLayout41,myLinearLayout42;
    private LinearLayout myLinearLayout51,myLinearLayout52;
    private FrameLayout framelayout1,framelayout2,framelayout3,framelayout4,framelayout5;
    private boolean isClicked1 = true,isClicked2 = true,isClicked3 = false,isClicked4 = true,isClicked5 = true;

    private ImageView hoticon, coldicon , temppic;
    private static final int AllReady = 0, OneOpen = 1;

    private int[] beforeDis = {0,75,150,225,295};
    private int[] transDis = {193,236,279,322,365};

    private void tranRightDis(int index , int status){
        float density = getResources().getDisplayMetrics().density; // 获取屏幕密度
        FrameLayout.LayoutParams[] layoutParams = new FrameLayout.LayoutParams[5];
        for (int i = 0; i < 5; i++) {
            layoutParams[i] = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT, // 宽度为WRAP_CONTENT
                    FrameLayout.LayoutParams.WRAP_CONTENT  // 高度为WRAP_CONTENT
            );
            layoutParams[i].gravity = Gravity.CENTER_HORIZONTAL; // 设置布局的水平居中
        }
        if (status == AllReady){

            for (int i = 0; i <5; i++) {
                layoutParams[i].topMargin = (int) (beforeDis[i] * density);
            }
            myLinearLayout11.setVisibility(View.VISIBLE);
            myLinearLayout21.setVisibility(View.VISIBLE);
            myLinearLayout31.setVisibility(View.VISIBLE);
            myLinearLayout41.setVisibility(View.VISIBLE);
            myLinearLayout51.setVisibility(View.VISIBLE);

        }else if (status == OneOpen){

            for (int i = 0; i < 5; i++) {
                if (i!=index)
                    layoutParams[i].topMargin = (int) (transDis[i] * density);
                layoutParams[index].topMargin = 0;
            }

        }else {

        }

//        int marginTopInDp = 16; // 设置你想要的marginTop值，单位是dp
//        int marginTopInPixels = (int) (marginTopInDp * density); // 将dp转换为像素
//        layoutParams.topMargin = marginTopInPixels; // 设置marginTop属性

        framelayout1.setLayoutParams(layoutParams[0]);
        framelayout2.setLayoutParams(layoutParams[1]);
        framelayout3.setLayoutParams(layoutParams[2]);
        framelayout4.setLayoutParams(layoutParams[3]);
        framelayout5.setLayoutParams(layoutParams[4]);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity(); // 获取活动页面的上下文
        // 根据布局文件fragment_tab_first.xml生成视图对象
        view = inflater.inflate(R.layout.fragment_tab_first, container, false);
        float density = getResources().getDisplayMetrics().density;
        framelayout1 = view.findViewById(R.id.framelayout1);
        myLinearLayout11 = view.findViewById(R.id.myLinearLayout11);
        myLinearLayout12 = view.findViewById(R.id.myLinearLayout12);
        framelayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 切换背景
                if (isClicked1) {
                    tranRightDis(0,OneOpen);
                    myLinearLayout12.setVisibility(View.VISIBLE);
                    myLinearLayout11.setVisibility(View.INVISIBLE);
                } else {
                    tranRightDis(0,AllReady);
                    myLinearLayout12.setVisibility(View.INVISIBLE);
                    myLinearLayout11.setVisibility(View.VISIBLE);
                }
                isClicked1 = !isClicked1;
            }
        });

        framelayout2 = view.findViewById(R.id.framelayout2);
        myLinearLayout21 = view.findViewById(R.id.myLinearLayout21);
        myLinearLayout22 = view.findViewById(R.id.myLinearLayout22);
        framelayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 切换背景
                if (isClicked2) {
                    tranRightDis(1,OneOpen);
                    myLinearLayout22.setVisibility(View.VISIBLE);
                    myLinearLayout21.setVisibility(View.INVISIBLE);
                } else {
                    tranRightDis(0,AllReady);
                    myLinearLayout22.setVisibility(View.INVISIBLE);
                    myLinearLayout21.setVisibility(View.VISIBLE);
                }
                isClicked2 = !isClicked2;
            }
        });


        framelayout3 = view.findViewById(R.id.framelayout3);
        myLinearLayout31 = view.findViewById(R.id.myLinearLayout31);
        myLinearLayout32 = view.findViewById(R.id.myLinearLayout32);
        framelayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 切换背景
                if (isClicked3) {
                    tranRightDis(2,OneOpen);
                    myLinearLayout32.setVisibility(View.VISIBLE);
                    myLinearLayout31.setVisibility(View.INVISIBLE);
                } else {
                    tranRightDis(0,AllReady);
                    myLinearLayout32.setVisibility(View.INVISIBLE);
                    myLinearLayout31.setVisibility(View.VISIBLE);
                }
                isClicked3 = !isClicked3;
            }
        });
        hoticon = view.findViewById(R.id.hoticon);
        coldicon = view.findViewById(R.id.coldicon);
        temppic = view.findViewById(R.id.temppic);
        hoticon.setOnClickListener(view1 -> {
            hoticon.setImageResource(R.drawable.hot_new_press);
            coldicon.setImageResource(R.drawable.cold_notpress);
            temppic.setImageResource(R.drawable.hotpic);
            myLinearLayout32.setBackgroundResource(R.drawable.drawer3bac_hot);

        });
        coldicon.setOnClickListener(view1 -> {
            hoticon.setImageResource(R.drawable.hot_new_notpress);
            coldicon.setImageResource(R.drawable.cold_press);
            temppic.setImageResource(R.drawable.coldpic);
            myLinearLayout32.setBackgroundResource(R.drawable.drawer3bac);
        });

        framelayout4 = view.findViewById(R.id.framelayout4);
        myLinearLayout41 = view.findViewById(R.id.myLinearLayout41);
        myLinearLayout42 = view.findViewById(R.id.myLinearLayout42);
        framelayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 切换背景
                if (isClicked4) {
                    tranRightDis(3,OneOpen);
                    myLinearLayout42.setVisibility(View.VISIBLE);
                    myLinearLayout41.setVisibility(View.INVISIBLE);
                } else {
                    tranRightDis(0,AllReady);
                    myLinearLayout42.setVisibility(View.INVISIBLE);
                    myLinearLayout41.setVisibility(View.VISIBLE);
                }
                isClicked4 = !isClicked4;
            }
        });

        framelayout5 = view.findViewById(R.id.framelayout5);
        myLinearLayout51 = view.findViewById(R.id.myLinearLayout51);
        myLinearLayout52 = view.findViewById(R.id.myLinearLayout52);
        framelayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 切换背景
                if (isClicked5) {
                    tranRightDis(4,OneOpen);
                    myLinearLayout52.setVisibility(View.VISIBLE);
                    myLinearLayout51.setVisibility(View.INVISIBLE);
                } else {
                    tranRightDis(0,AllReady);
                    myLinearLayout52.setVisibility(View.INVISIBLE);
                    myLinearLayout51.setVisibility(View.VISIBLE);
                }
                isClicked5 = !isClicked5;
            }
        });

        choosemin();

        return view;
    }

    private ImageView[] imageViews = new ImageView[4];
    private TextView[] textViews = new TextView[4];

    private void choosemin(){
        imageViews[0] = view.findViewById(R.id.tenmin);
        imageViews[1] = view.findViewById(R.id.fifteenmin);
        imageViews[2] = view.findViewById(R.id.twentymin);
        imageViews[3] = view.findViewById(R.id.thirtymin);

        textViews[0] = view.findViewById(R.id.text1);
        textViews[1] = view.findViewById(R.id.text2);
        textViews[2] = view.findViewById(R.id.text3);
        textViews[3] = view.findViewById(R.id.text4);

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int j = 0; j < 4; j++) {
                        imageViews[j].setBackgroundResource(android.R.color.transparent);
                        textViews[j].setTextColor(Color.WHITE);
                    }
                    imageViews[finalI].setBackgroundResource(R.drawable.chosebac);
                    textViews[finalI].setTextColor(Color.BLACK);
                }
            });
        }
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
