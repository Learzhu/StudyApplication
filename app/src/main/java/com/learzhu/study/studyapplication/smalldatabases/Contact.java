package com.learzhu.study.studyapplication.smalldatabases;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Learzhu on 2016/10/20.
 */

public class Contact extends RealmObject {
    private String name;
    /*    Error:(12, 29) 错误: The fields of the model must be private*/
//    public RealmList<Email> mEmails;
    private RealmList<Email> mEmails;

    public Contact() {
    }

    public Contact(String name, RealmList<Email> emails) {
        this.name = name;
        this.mEmails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Email> getEmails() {
//        if (mEmails == null) {
//            return new RealmList<Email>();
//        }
        return mEmails;
    }

    public void setEmails(RealmList<Email> emails) {
//        if (mEmails == null) {
//            mEmails = new RealmList<Email>();
//        }
        this.mEmails = emails;
    }
}
