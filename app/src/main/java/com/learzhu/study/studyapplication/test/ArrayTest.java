package com.learzhu.study.studyapplication.test;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Learzhu on 2016/10/27.
 */

public class ArrayTest {
    private static List<String> mList = new CopyOnWriteArrayList<>();

    private void testCopyArrayList() {
        mList.add("A");
        mList.add("B");
        mList.add("C");
        for (String string :
                mList) {
            System.out.println("mlist----" + string);
        }
    }

    private String[] TestArray() {
        String[] strings = new String[]{"A", "B", "C"};
        System.arraycopy(strings, 0, strings, strings.length, 1);
        return strings;
    }

    public static void main(String args[]) {
        ArrayTest test = new ArrayTest();
        test.testCopyArrayList();

    }
}
