package com.learzhu.study.studyapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Learzhu
 * @version $Rev$
 * @time 2016/7/28 19:49
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$  19:49
 * @updateDes ${TODO}
 */
public class Compute {
    public static void main(String[] args) throws IOException, InterruptedException {
//        int i = -1;
//        i |= 2;
//        System.out.print("i " + i);

//        Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", "echo $PPID"});
//        if (process.waitFor() == 0) {
//            InputStream in = process.getInputStream();
//            int available = in.available();
//            byte[] output = new byte[available];
//            in.read(output);
//            String pid = new String(output);
//            System.out.println("Your pid is " + pid);
////            System.out.println("Your pid is " +  Process.getCurrentPid());
//        }

//        List<String> names1 = new ArrayList<String>();
//        names1.add("Google ");
//        names1.add("Runoob ");
//        names1.add("Taobao ");
//        names1.add("Baidu ");
//        names1.add("Sina ");
//
//        List<String> names2 = new ArrayList<String>();
//        names2.add("Google ");
//        names2.add("Runoob ");
//        names2.add("Taobao ");
//        names2.add("Baidu ");
//        names2.add("Sina ");
//
//        Compute tester = new Compute();
//        System.out.println("使用 Java 7 语法: ");
//
//        tester.sortUsingJava7(names1);
//        System.out.println(names1);
//        System.out.println("使用 Java 8 语法: ");
//
//        tester.sortUsingJava8(names2);
//        System.out.println(names2);
        System.exit(0);

    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names) {
//        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
