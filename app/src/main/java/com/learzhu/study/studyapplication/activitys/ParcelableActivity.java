package com.learzhu.study.studyapplication.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.learzhu.study.studyapplication.R;
import com.learzhu.study.studyapplication.modle.Book;

public class ParcelableActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
        textView = (TextView) findViewById(R.id.show_parcelable_result);
        getBookInfo();
    }

    private void getBookInfo() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Book book = bundle.getParcelable("book");
        System.out.println(book);
        Parcelable book1 = intent.getParcelableExtra("book");
        Book book2 = intent.getParcelableExtra("book");
        textView.setText(book + "\n" + book1 + "\n" + book2);
    }
}
