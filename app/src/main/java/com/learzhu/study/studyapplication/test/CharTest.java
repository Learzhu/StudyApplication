package com.learzhu.study.studyapplication.test;

import java.util.Arrays;

/**
 * @author Learzhu
 * @version ${Rev}
 * @createDate 2016/11/9
 * @updateAuthor $Author$
 * @updateDate ${Date}  10:13
 * @updateDes ${TODO}
 */

public class CharTest {
    public static void main(String args[]) {
        char[] mChars = {73, 76, 79, 86, 85};
        System.out.println(Arrays.toString(mChars));
        System.out.println();
        char[] mChars1 = {'I', 'L', 'O', 'V', 'E', 'U'};
        System.out.println(Arrays.toString(mChars1));
        int[] mCharInt = new int[3];
//        for (int i :
//                mChars1) {
//            mCharInt[i] = mChars1[i];
//        }
        System.out.println();
        for (int i = 0; i < mChars1.length; i++) {
            System.out.println(mChars1[i]);
            System.out.println((int) mChars1[i]);
        }
    }
}
