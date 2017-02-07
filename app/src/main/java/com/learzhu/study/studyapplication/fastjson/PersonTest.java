package com.learzhu.study.studyapplication.fastjson;

import com.alibaba.fastjson.JSONObject;


/**
 * PersonTest.java 测试结果。
 *
 * @author 祝杭鹏
 * @version 3.0 2016/12/7
 */

public class PersonTest {

    private Person person;

    /**
     * 初始化对象
     */
    public void setUp() {
        person = new Person();
        person.setName("xianglj");
        person.setAge("20");
        person.setDesc("只是一个测试");
    }

    public void test() {
        String jsonStr = JSONObject.toJSONString(person);
        System.out.println("bean to json:" + jsonStr);

        //改变json的key为大写
        jsonStr = jsonStr.toUpperCase();

        System.out.println("需要转换的json:" + jsonStr);
        person = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Person.class);
        System.out.println("json to bean:" + person.getName());
    }

    public static void main(String args[]) {
        PersonTest mPersonTest = new PersonTest();
        mPersonTest.setUp();
        mPersonTest.test();
    }
}