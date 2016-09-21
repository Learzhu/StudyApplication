package com.learzhu.study.studyapplication.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.learzhu.study.studyapplication.R;

public class ContentActivity extends FragmentActivity implements ContentFragment.OnFragmentInteractionListener {

    private ContentFragment mContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        FragmentManager fm = getSupportFragmentManager();
        mContentFragment = (ContentFragment) fm.findFragmentById(R.id.id_fragment_container);
        if (mContentFragment == null) {
            String title = getIntent().getStringExtra(ContentFragment.ARGUMENT);
            mContentFragment = ContentFragment.newInstance(title);
            fm.beginTransaction().add(R.id.id_fragment_container, mContentFragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
