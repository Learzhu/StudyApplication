package com.learzhu.study.studyapplication;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.jakewharton.scalpel.ScalpelFrameLayout;
import com.learzhu.study.studyapplication.activitys.ParcelableActivity;
import com.learzhu.study.studyapplication.activitys.TagActivity;
import com.learzhu.study.studyapplication.fragment.FragmentTestActivity;
import com.learzhu.study.studyapplication.modle.Book;
import com.learzhu.study.studyapplication.smalldatabases.RealmActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;
import timber.log.Timber;

import static android.R.attr.name;
import static android.os.Build.ID;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button tagBtn, parcelableBtn, fragmentBtn, realmBtn;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ScalpelFrameLayout mScalpelFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (false) {
//        if (BuildConfig.DEBUG) {
            /*测试环境的时候检测布局*/
            View mView = getLayoutInflater().inflate(R.layout.activity_main, null);
            /*只是在最外面加一层容器*/
            mScalpelFrameLayout = new ScalpelFrameLayout(this);
            mScalpelFrameLayout.addView(mView);
            /*开启3D效果*/
            mScalpelFrameLayout.setLayerInteractionEnabled(true);
            /*显隐DrawViews*/
            mScalpelFrameLayout.setDrawViews(true);
            /*显隐 view ID*/
            mScalpelFrameLayout.setDrawIds(true);
            /*修改边框的颜色和阴影*/

            mScalpelFrameLayout.setChromeColor(ContextCompat.getColor(getBaseContext(), R.color.colorAccent));
            setContentView(mScalpelFrameLayout);
        } else {
            setContentView(R.layout.activity_main);
        }
        initViews();
    }

    private void initViews() {
        tagBtn = (Button) findViewById(R.id.tag_btn);
        tagBtn.setOnClickListener(this);
        parcelableBtn = (Button) findViewById(R.id.parcelable_btn);
        parcelableBtn.setOnClickListener(this);
        fragmentBtn = (Button) findViewById(R.id.fragment_btn);
        fragmentBtn.setOnClickListener(this);
        realmBtn = (Button) findViewById(R.id.realm_btn);
        realmBtn.setOnClickListener(this);
    }

    /**
     * 测试 Parcel
     */
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

    private void testTag() {
        startActivity(new Intent(MainActivity.this, TagActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tag_btn:
//                testTag();
//                testString(1);
                testDialog();
                break;
            case R.id.parcelable_btn:
                testParcelable();
                break;
            case R.id.fragment_btn:
                Intent intent = new Intent(MainActivity.this, FragmentTestActivity.class);
                intent.putExtra(ARG_PARAM1, ARG_PARAM1);
                intent.putExtra(ARG_PARAM2, ARG_PARAM2);
                startActivity(intent);
                break;
            case R.id.realm_btn:
                Intent intent1 = new Intent(MainActivity.this, RealmActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }

    private void testDialog() {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(this);
         /*弹出对话框*/
        dialogBuilder
                .withTitle("删除")
                .withMessage(Html.fromHtml(new StringBuilder("确认删除").append("<font color=#f75842>").append(name).append("</font>").append("的对话？").toString()))
                .withDuration(700)
                .withEffect(Effectstype.Fadein)
                .withButton1Text("确认")
                .withButton2Text("取消")
                .withDialogColor("#ffffffff")
                .isCancelableOnTouchOutside(false)
                .setCustomView(R.layout.activity_image_view, MainActivity.this)
                .withButtonDrawable(R.drawable.btn_selector)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        boolean success = EMClient.getInstance().chatManager().deleteConversation(conversation.getUserName(), true);
//                        if (success) {
//                            Alert.Toast("删除成功");
//                                    /*提示主界面刷新未读消息数目*/
//                            ((MainActivity) getActivity()).showChatRecordsUnReadCount();
//                        } else {
//                            Alert.Toast("删除失败");
//                        }
//                        refreshConversationAndCountData();
                        dialogBuilder.dismiss();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                    }
                })
                .show();

    }

    @DebugLog
    private String testString(int x) {
        Timber.tag("LifeCycles");//设置只能用一次的Tag
        Timber.d("Activity Created");

        //DebugTree 会帮你进行格式化输出
        Timber.i("A button with ID %s was clicked to say '%s'.", R.id.tag_btn, "testString");
        return "@DebugLog";
    }
}
