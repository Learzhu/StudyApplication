package com.learzhu.study.studyapplication.activitys;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.learzhu.study.studyapplication.R;

import java.util.ArrayList;

public class TagActivity extends Activity implements View.OnClickListener {

    private Button button1, button2;
    private Button getTag, setTag;
    private GridView gridView;

    //    java.lang.IllegalArgumentException: The key must be an application-specific resource id.
//    private final static int five = 5;
//    private final static int six = 6;
//    private final static int serven = 7;
//    private final static int eight = 8;

    /*方法一*/
//    如果只需要设置一个tag，那么直接调用setTag（Object tag)方法就可以轻松搞定，如果一定需要使用多个tag绑定，那么需要先在res/values/ids.xml中添加
//            <resources>
//    <item type="id" name="tag_first"></item>
//    <item type="id" name="tag_second"></item>
//    </resources>

    /*方法一*/
    private final static int five = R.id.five;
    private final static int six = R.id.sex;
    private final static int serven = R.id.seven;
    private final static int eight = R.id.eight;

    /*方法二*/
//    private final static int five = 5 << 24;
//    private final static int six = 6 << 24;
//    private final static int serven = 7 << 24;
//    private final static int eight = 8 << 24;

    /*错误*/
//    private final static int five = 5 >> 24;
//    private final static int six = 6 >> 24;
//    private final static int serven = 7 >> 24;
//    private final static int eight = 8 >> 24;

    /*错误*/
//    private final static int five = 5 << 8;
//    private final static int six = 6 << 8;
//    private final static int serven = 7 << 8;
//    private final static int eight = 8 << 8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        getTag = (Button) findViewById(R.id.gettag);
        setTag = (Button) findViewById(R.id.settag);
        gridView = (GridView) findViewById(R.id.gridview);

        MyListener listener = new MyListener();
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);

        getTag.setOnClickListener(this);
        setTag.setOnClickListener(this);

        gridView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
    }

    private ArrayList<String> getData() {
        ArrayList<String> mArrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mArrayList.add("item " + i);
        }
//        mArrayList.add("测试数据1");
//        mArrayList.add("测试数据2");
//        mArrayList.add("测试数据3");
//        mArrayList.add("测试数据4");
//        mArrayList.add("测试数据5");
//        mArrayList.add("测试数据6");
        return mArrayList;
    }


    @Override
    public void onClick(View v) {
        if (v == getTag) {
            getTag();
        } else if (v == setTag) {
            setTag();
        }
    }

    private void setTag() {
        gridView.setTag(five, "hello world");
        gridView.setTag(six, true);
        gridView.setTag(serven, 100);
        gridView.setTag(eight, 158.9f);
    }

    private void getTag() {
        Log.e("gridview getTag(index)",
                "String:" + ((String) gridView.getTag(five)));
        Log.e("gridview getTag(index)", "boolean:" +
                ((Boolean) gridView.getTag(six)));
        Log.e("gridview getTag(index)", "int:" +
                ((Integer) gridView.getTag(serven)));
        Log.e("gridview getTag(index)", "float:" +
                ((Float) gridView.getTag(eight)));
    }

    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            doToast(v.getTag());
        }
    }

    private void doToast(Object tag) {
        Toast.makeText(TagActivity.this, tag.toString(), Toast.LENGTH_SHORT).show();
    }

}
