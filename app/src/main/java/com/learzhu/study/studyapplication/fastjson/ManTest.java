package com.learzhu.study.studyapplication.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Learzhu
 * @version ${Rev}
 * @createDate 2016/12/7
 * @updateAuthor $Author$
 * @updateDate 2016/12/7  17:54
 * @updateDes ${TODO}
 */

public class ManTest {
    private Man mMan;

    /**
     * 初始化对象
     */
    public void setUp() {
        mMan = new Man();
        mMan.setName("xianglj");
        mMan.setAge("20");
        mMan.setDesc("只是一个测试");
    }

    public void test() {
        String jsonStr = JSONObject.toJSONString(mMan);
        System.out.println("bean to json:" + jsonStr);

        //改变json的key为大写
        jsonStr = jsonStr.toUpperCase();

        System.out.println("需要转换的json:" + jsonStr);
        mMan = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Man.class);
        System.out.println("json to bean:" + mMan.getName());
    }

    public static void main(String args[]) {
        ManTest mManTest = new ManTest();
        mManTest.setUp();
        mManTest.test();

    }
}
