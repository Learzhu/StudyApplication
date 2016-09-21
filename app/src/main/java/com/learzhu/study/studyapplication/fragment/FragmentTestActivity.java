package com.learzhu.study.studyapplication.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.media.MediaBrowserCompat;

import com.learzhu.study.studyapplication.R;

public class FragmentTestActivity extends FragmentActivity implements ContentFragment.OnFragmentInteractionListener {

    private ContentFragment mContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        startActivity(new Intent(FragmentTestActivity.this, ListTitleActivity.class));
//        FragmentManager fm = getSupportFragmentManager();
//        mContentFragment = (ContentFragment) fm.findFragmentById(R.id.id_fragment_container);
//        /**
//         * 当Activity因为配置发生改变（屏幕旋转）或者内存不足被系统杀死，造成重新创建时，我们的fragment会被保存下来，但是会创建新的FragmentManager，
//         * 新的FragmentManager会首先会去获取保存下来的fragment队列，重建fragment队列，从而恢复之前的状态。
//         */
//        if (mContentFragment == null) {
//            /*方式一*/
////            mContentFragment = new ContentFragment();
//            /**
//             * 告知FragmentManager，此fragment的位置；另一方面是此fragment的唯一标识；就像我们上面通过fm.findFragmentById(R.id.id_fragment_container)
//             */
////            mContentFragment = ContentFragment.newInstance("param1", "param1");
//            fm.beginTransaction().add(R.id.id_fragment_container, mContentFragment).commit();
//        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
