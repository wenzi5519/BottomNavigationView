package com.example.ziwen.bottomnavigationview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //    private TextView textView;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private MenuItem prevMenuItem;

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = (TextView) findViewById(R.id.text);
//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
//        //去除菜单项目大于 3 个之后，菜单项目缩放的方式
//        //每次修改 menu 都要调用 helper 的方法
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.home:
//                        textView.setText(item.getTitle());
//                        break;
//                    case R.id.service:
//                        textView.setText(item.getTitle());
//                        break;
//                    case R.id.message:
//                        textView.setText(item.getTitle());
//                        break;
//                    case R.id.personal:
//                        textView.setText(item.getTitle());
//                        break;
//                }
//                return true;
//            }
//        });

        //配合viewpager使用
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.service:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.message:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.personal:
                                viewPager.setCurrentItem(3);
                                break;
                        }
                        return false;
                    }
                });
        ArrayList list = new ArrayList();
        for (int i = 0; i < 4; i++) {
            TextView textView = new TextView(mContext);
            textView.setText("page" + i);
            list.add(textView);
        }
        viewPager.setAdapter(new QuickPageAdapter<TextView>(list));
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//         如果想禁止滑动，可以把下面的代码取消注释
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
    }
}
