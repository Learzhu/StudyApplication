package com.learzhu.study.studyapplication.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Person.java是测试 FastJson的类
 *
 * @author 祝杭鹏
 * @version 3.0 2016/12/7
 */

public class Man {

    @JSONField(name = "p_name")
    private String name;

    @JSONField(name = "p_age")
    private String age;

    @JSONField(name = "p_desc")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setNAME(String NAME) {
        this.name = NAME;
    }

    public void setAGE(String AGE) {
        this.age = AGE;
    }

    public void setDESC(String DESC) {
        this.desc = DESC;
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}