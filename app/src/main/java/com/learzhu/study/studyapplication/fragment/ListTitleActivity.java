package com.learzhu.study.studyapplication.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.learzhu.study.studyapplication.R;

public class ListTitleActivity extends FragmentActivity implements ListTitleFragment.OnFragmentInteractionListener {

    private ListTitleFragment mListTitleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_title);
        FragmentManager fm = getSupportFragmentManager();
        mListTitleFragment = (ListTitleFragment) fm.findFragmentById(R.id.id_fragment_container);
        if (mListTitleFragment == null) {
            mListTitleFragment = new ListTitleFragment();
            fm.beginTransaction().add(R.id.id_fragment_container, mListTitleFragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
