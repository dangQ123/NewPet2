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
                    myLinearLayout.setBackgroundResource(R.drawable.drawer1bacmul);
                    addAdditionalViews(false);
                } else {
                    myLinearLayout.setBackgroundResource(R.drawable.drawer1bac);
                    addAdditionalViews(true);
                }
                isClicked = !isClicked;
            }
        });

        return view;
    }

    private void addText(){

        // 创建一个新的TextView
        myTextView = new TextView(requireContext());

        // 设置TextView的属性
        myTextView.setText("电源");
        myTextView.setTextColor(Color.parseColor("#FFFFFF"));
        myTextView.setTextSize(24);
        myTextView.setTypeface(null, Typeface.BOLD); // 设置字体粗体
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(dpToPx(50), dpToPx(25), 0, 0); // 设置上边距和左边距
        myTextView.setLayoutParams(layoutParams);

        // 将TextView添加到myLinearLayout中
        myLinearLayout.addView(myTextView);
    }
    private void addRelativeLayout(){
        // 创建RelativeLayout
        relativeLayout1 = new RelativeLayout(requireContext());
        relativeLayout1.setBackgroundColor(Color.parseColor("#000000"));
        // 设置RelativeLayout的属性
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                dpToPx(250), ViewGroup.LayoutParams.WRAP_CONTENT); // 设置宽度和高度
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE); // 水平居中
        layoutParams.topMargin = dpToPx(8); // 顶部外边距
        relativeLayout1.setLayoutParams(layoutParams);

        // 创建ImageView并设置属性
        ImageView imageView = new ImageView(requireContext());
        imageView.setId(View.generateViewId()); // 设置唯一的ID
        imageView.setImageResource(R.drawable.drawer1icon1);
        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(
                dpToPx(35), dpToPx(35)); // 设置宽度和高度
        imageView.setLayoutParams(imageParams);

        // 创建TextView并设置属性
        TextView textView = new TextView(requireContext());
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView.setText("开机");
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.RIGHT_OF, imageView.getId()); // 设置在ImageView右边
        textParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE); // 垂直居中
        textParams.leftMargin = dpToPx(19); // 左边外边距
        textView.setLayoutParams(textParams);

        // 创建SwitchButton并设置属性
        SwitchButton switchButton = new SwitchButton(requireContext());
        RelativeLayout.LayoutParams switchParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switchParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE); // 右对齐
        switchButton.setLayoutParams(switchParams);

        // 将ImageView、TextView和SwitchButton添加到RelativeLayout中
        relativeLayout1.addView(imageView);
        relativeLayout1.addView(textView);
        relativeLayout1.addView(switchButton);

        // 将RelativeLayout添加到LinearLayout中
        myLinearLayout.addView(relativeLayout1);
    }
    private void addAdditionalViews(boolean showAdditionalViews) {
        if (showAdditionalViews) {
            // 添加其他控件
            addText();
            addRelativeLayout();

        } else {
            // 移除所有额外的控件
            myLinearLayout.removeAllViews();
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
