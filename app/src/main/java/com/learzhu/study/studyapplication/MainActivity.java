package com.learzhu.study.studyapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.learzhu.study.studyapplication.activitys.ParcelableActivity;
import com.learzhu.study.studyapplication.modle.Book;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testParcelable();
    }

    private void testParcelable() {
//        Man man =Man.CREATOR;
        Book book = new Book();
        book.setAuthor("Lear");
        book.setBookName("Computer");
        book.setPublishDate(20);
        ArrayList<String> list = new ArrayList<String>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        book.setList(list);
        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);

//        for (int i = 0; i < 10000; i++) {
//            bundle.writeToParcel(book, 1);
//        }
        Intent intent = new Intent(MainActivity.this, ParcelableActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
