package edu.njust.newpet2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.njust.newpet2.bottombar.adapter.TabPagerAdapter;

public class HomePageActivity extends AppCompatActivity {

    private ViewPager vp_content;
    private RadioGroup rg_tabbar;
    private RadioButton radioButton1,radioButton2,radioButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float density = displayMetrics.density;

        vp_content = findViewById(R.id.vp_content);
        rg_tabbar =findViewById(R.id.rg_tabbar);
        radioButton1 = findViewById(R.id.rb_1);
        radioButton2 = findViewById(R.id.rb_2);
        radioButton3 = findViewById(R.id.rb_3);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        vp_content.setAdapter(tabPagerAdapter);

        Drawable drawable_1 = getResources().getDrawable(R.drawable.tab_first_selector);
        Drawable drawable_2 = getResources().getDrawable(R.drawable.tab_second_selector);
        Drawable drawable_3 = getResources().getDrawable(R.drawable.tab_third_selector);
        int dis = (int) (density*40);

        drawable_1.setBounds(0, 0, dis, dis);
        drawable_2.setBounds(0, 0, dis, dis);
        drawable_3.setBounds(0, 0, dis, dis);
        //设置图片在文字的哪个方向
        radioButton1.setCompoundDrawables(null, null, null, drawable_1);
        radioButton2.setCompoundDrawables(null, null, null, drawable_2);
        radioButton3.setCompoundDrawables(null, null, null, drawable_3);



        vp_content.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                rg_tabbar.check(rg_tabbar.getChildAt(position).getId());
            }
        });
        rg_tabbar.setOnCheckedChangeListener(((radioGroup, i) -> {
            for (int pos =0;pos<rg_tabbar.getChildCount();pos++){
                RadioButton tab = (RadioButton) rg_tabbar.getChildAt(pos);
                if (tab.getId()==i){
                    vp_content.setCurrentItem(pos);
                }
            }
        }));



    }


}