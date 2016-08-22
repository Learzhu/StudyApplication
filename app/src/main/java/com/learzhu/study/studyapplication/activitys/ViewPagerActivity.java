package com.learzhu.study.studyapplication.activitys;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learzhu.study.studyapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends Activity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<RecyclerView> recyclerViews;
    private Toolbar toolbar;
    private List<String> mDatas;

    private RecyclerViewAdapter recyclerViewAdapter, recyclerViewAdapter1;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        recyclerViews = new ArrayList<RecyclerView>();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView1 = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView2 = (RecyclerView) findViewById(R.id.recycle_view1);
        toolbar.setTitle("AAAAAAAAAAA");

        initData();
        /*每日榜的RecyclerView*/
//        recyclerView1 = new RecyclerView(this);
        initRecyclerView();

        recyclerViews.add(recyclerView1);
        recyclerViews.add(recyclerView2);
        int[] tabImages = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher};
        MyViewPageAdapter myPagerAdapter = new MyViewPageAdapter(recyclerViews, this, tabImages);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void initRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(this, mDatas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewPagerActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setAdapter(recyclerViewAdapter);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setHasFixedSize(true);


        recyclerViewAdapter1 = new RecyclerViewAdapter(this, mDatas);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ViewPagerActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setAdapter(recyclerViewAdapter1);
        recyclerView2.setLayoutManager(linearLayoutManager1);
        recyclerView2.setHasFixedSize(true);
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    class MyViewPageAdapter extends PagerAdapter {

        private List<RecyclerView> recyclerViews;
        private Context context;
        /*tab的图标*/
        private int[] tabImgs;

        public MyViewPageAdapter(List<RecyclerView> recyclerViews, Context context, int[] tabImgs) {
            this.recyclerViews = recyclerViews;
            this.context = context;
            this.tabImgs = tabImgs;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            RecyclerView recyclerView = recyclerViews.get(position);
            container.addView(recyclerView, position);
            return recyclerView;
        }

        @Override
        public int getCount() {
            return recyclerViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(recyclerViews.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            /*设置图标*/
            Drawable myDrawable = ContextCompat.getDrawable(context,
                    tabImgs[position]);
            myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(),
                    myDrawable.getIntrinsicHeight());
            ImageSpan imageSpan = new ImageSpan(myDrawable,
                    ImageSpan.ALIGN_BASELINE);
            SpannableString spannableString = new SpannableString("   " + "888");
            spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return spannableString;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private List<String> data;
        private LayoutInflater inflater;

        public RecyclerViewAdapter(Context context, List<String> data) {
            this.data = data;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(inflater.inflate(R.layout.layout_recyclerview_item, parent, false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(data.get(position) + "");
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}

