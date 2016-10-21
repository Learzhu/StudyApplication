package com.learzhu.study.studyapplication.smalldatabases;

import io.realm.RealmObject;

/**
 * Created by Learzhu on 2016/10/20.
 */

public class Email extends RealmObject {
    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//    public String email;
}
