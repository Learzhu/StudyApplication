package com.learzhu.study.studyapplication.smalldatabases;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.learzhu.study.studyapplication.R;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import static android.R.attr.name;

/**
 * Realm CRUD
 */
public class RealmActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "RealmActivity";
    private Realm mRealm;
    private Button createBtn, retrieveBtn, updateBtn, deleteBtn, createContactBtn;
    private TextView showResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        initViews();
    }

    private void initViews() {
        createBtn = (Button) findViewById(R.id.create_btn);
        createBtn.setOnClickListener(this);
        retrieveBtn = (Button) findViewById(R.id.query_btn);
        retrieveBtn.setOnClickListener(this);
        updateBtn = (Button) findViewById(R.id.query_btn);
        updateBtn.setOnClickListener(this);
        deleteBtn = (Button) findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(this);
        showResultTv = (TextView) findViewById(R.id.show_result);
        createContactBtn = (Button) findViewById(R.id.create_contact_btn);
        createContactBtn.setOnClickListener(this);
    }

    /**
     * 创建一个带有配置的数据库
     */
    private void testCreateRealm() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder(getApplicationContext()).name("learzhu.realm").build());
        mRealm.beginTransaction();
        /*对于一个Realm来说，管理一个RealmObject的实例，这个实例必须用createObject方法创建。*/
        RealmResults<Country> mCountries = mRealm.allObjects(Country.class);
        if (mCountries.size() > 0) {
            Toast.makeText(this, "Aleardy Created Realm", Toast.LENGTH_SHORT).show();
            showResultTv.setText("Aleardy Created Realm");
        } else {
        /*way1*/
            Country mCountry = mRealm.createObject(Country.class);
            mCountry.setName("China");
            mCountry.setCode("X1");
            mCountry.setPopulation(10000000);
        /*way2*/
            Country mCountry1 = new Country();
            mCountry1.setName("Japan");
            mCountry1.setPopulation(20000);
            mCountry1.setCode("Y1");
        /*copyToRealm方法还有一个很重要的作用就是可以把已经存在的对象直接拷贝Realm数据库*/
            mRealm.copyToRealm(mCountry1);
            mRealm.commitTransaction();
            Toast.makeText(this, "Success Create Realm", Toast.LENGTH_SHORT).show();
            showResultTv.setText("Success Create Realm");
        }
        Log.i(TAG, "Success Create Realm");
    }

    /**
     * 显示所有
     */
    private void findAllFromRealm() {
        RealmResults<Country> result = mRealm.where(Country.class).findAll();
        StringBuilder sb = new StringBuilder();
        for (Country country
                : result
                ) {
            Log.i(TAG, country.getName());
            sb.append(toString(country));
        }
        showResultTv.setText(sb.toString());
    }

    private void testUpdate() {
//        mRealm.beginTransaction();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Country mCountry = realm.where(Country.class).equalTo("name", "China").findFirst();
                if (mCountry != null) {
                    mCountry.setName("China11");
                    mCountry.setPopulation(1);
                }
                Toast.makeText(RealmActivity.this, "update success", Toast.LENGTH_SHORT).show();
                findAllFromRealm();
            }
        });
    }

    /**
     * 条件查询，Realm 支持以下查询条件（来源于官网）：
     * between()、greaterThan()、lessThan()、greaterThanOrEqualTo() 和 lessThanOrEqualTo()
     * equalTo() 和 notEqualTo()
     * contains()、beginsWith() 和 endsWith()
     * isNull() 和 isNotNull()
     * isEmpty() 和 isNotEmpty()
     * 以下代码片段查询年龄小于15的User
     * <p>
     * public void testQueryAgeLessThan15() {
     * List<User> users= realm.where(User.class).lessThan("age", 15).findAll();
     * for (User user: users) {
     * showInTextView("id:" + user.getId() + " name:" + user.getName() + " age:" + user.getAge());
     * }
     * }
     * 聚合查询，支持的聚合操作有sum，min，max，average
     * <p>
     * 以下代码片段得到所有人的平均年龄
     * <p>
     * public void testQueryAverageAge() {
     * double age = realm.where(User.class).findAll().average("age");
     * textView.setText("average age:" + age);
     * }
     */
    private void testQuery() {
//        RealmResults<Country> mAll = mRealm.where(Country.class).findAll();
        List<Country> mCountryList = mRealm.where(Country.class).findAll();
        for (Country country :
                mCountryList) {
            Toast.makeText(this, country.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    private void testDelete() {
        mRealm.beginTransaction();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Country mCountry = realm.where(Country.class).equalTo("name", "China").findFirst();
                if (mCountry != null) {
                    mRealm.beginTransaction();
                    mCountry.removeFromRealm();
                }
                Toast.makeText(RealmActivity.this, "delete success", Toast.LENGTH_SHORT).show();
                findAllFromRealm();
            }
        });
    }

    private void testDelete1() {
        Country mCountry = mRealm.where(Country.class).equalTo("name", "China11").findFirst();
//        mRealm.beginTransaction();
        mCountry.removeFromRealm();
        mRealm.commitTransaction();
        showResultTv.setText("delete success");
    }

    private void removeAll() {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                realm.delete(Country.class);
//                realm.
            }
        });
    }

    private void testAdd() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_btn:
                testCreateRealm();
                break;
            case R.id.query_btn:
//                testQuery();
                findAllFromRealm();
                break;
            case R.id.update_btn:
                testUpdate();
                break;
            case R.id.delete_btn:
//                testDelete();
                testDelete1();
                break;
            case R.id.create_contact_btn:
//                testCreateContact();
                break;
        }
    }

    private void testCreateContact() {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Contact mContact = realm.createObject(Contact.class);
                mContact.setName("Lear");

                Email mEmail = realm.createObject(Email.class);
                mEmail.setEmail("lear@gmail.com");
//                mEmail.email = "lear@gmail.com";
                /*错误*/
//                mContact.mEmails.add(mEmail);
                mContact.getEmails().add(mEmail);

//                Email mEmail1 = new Email();
//                mEmail.setEmail("xxx@qq.com");
////                mEmail1.email = "xxx@qq.com";
//                Email mEmail2 = realm.copyToRealm(mEmail1);
////                mContact.mEmails.add(mEmail2);
//                mContact.getEmails().add(mEmail2);
                showResultTv.setText("success create Contact");
            }
        });
    }

    /**
     * @param country
     * @return
     */
    public String toString(Country country) {
        return "Country{" +
                "code='" + country.getCode() + '\'' +
                ", name='" + country.getName() + '\'' +
                ", population=" + country.getPopulation() +
                '}';
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.removeAllChangeListeners();
        mRealm.close();
    }
}

