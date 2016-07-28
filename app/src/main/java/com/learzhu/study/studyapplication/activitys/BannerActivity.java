package com.learzhu.study.studyapplication.activitys;

import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.learzhu.study.studyapplication.R;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity {
    /**
     * ViewPager中ImageView的容器
     */
    private List<ImageView> imageViewList = null;

    private long scrollTimeOffset = 2000;

    private LinearLayout llDotGroup;

    private int preDotPosition = 0;
    /**
     * Banner滚动线程是否销毁的标志，默认不销毁
     */
    private boolean isStop = false;
    private ViewPager viewPager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        llDotGroup = (LinearLayout) findViewById(R.id.pointer_group);
        initBanner();
        startBannerScrollThread();
    }

    public void initBanner() {
        imageViewList = new ArrayList<>();
        LinearLayout.LayoutParams params = null;
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ic_launcher);
            imageViewList.add(imageView);

            View dot = new View(this);
            dot.setBackgroundResource(R.drawable.selector_dot_bg);
            params = new LinearLayout.LayoutParams(5, 5);
            params.leftMargin = 10;
            dot.setEnabled(false);
            dot.setLayoutParams(params);
            llDotGroup.addView(dot);
        }

        viewPager.setAdapter(new BannerAdapter());
        viewPager.setOnPageChangeListener(new BannerPageChangeListener());
        llDotGroup.getChildAt(0).setEnabled(true);
        viewPager.setCurrentItem(0);
    }

    private void startBannerScrollThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStop) {
                    SystemClock.sleep(scrollTimeOffset);
                    if (BannerActivity.this == null) {
                        return;
                    }
                    BannerActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int newIndex = viewPager.getCurrentItem()+1;
                            viewPager.setCurrentItem(newIndex);
                        }
                    });

                }
            }
        }).start();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private class BannerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewList.get(position % imageViewList.size()));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = imageViewList.get(position % imageViewList.size());
            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    private class BannerPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int newPositon = position % imageViewList.size();
            llDotGroup.getChildAt(preDotPosition).setEnabled(false);
            llDotGroup.getChildAt(newPositon).setEnabled(true);
            preDotPosition = newPositon;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    protected void onDestroy() {
        isStop = true;
        super.onDestroy();
    }
}
