package com.learzhu.study.studyapplication.test;

/**
 * @author Learzhu
 * @version ${Rev}
 * @createDate 2016/11/28
 * @updateAuthor $Author$
 * @updateDate 2016/11/28  19:06
 * @updateDes ${TODO}
 */

public class StringBuilderTest {

    public static void main(String args[]) {
        StringBuilderTest st = new StringBuilderTest();
        st.test();
    }

    private void test() {
        Flower mFlower = new Flower(1, "A");
        System.out.println(new StringBuilder(mFlower.getNum()).toString());
    }

    class Flower {
        private int num;
        private String name;

        public Flower(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
