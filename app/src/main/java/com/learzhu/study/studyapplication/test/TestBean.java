package com.learzhu.study.studyapplication.test;

import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Learzhu on 2016/10/26.
 */

public class TestBean {

    static class Bean {
        private String name = "XX";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String args[]) {
//        Bean bean = new Bean();

//        System.out.println("SSSSSSSSS");
        System.out.println("Bean --" + (new Bean()).getName());
        showTest();
    }

    public static void showMyToast(final Toast toast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
                System.out.println("AAAAAAAAAAAAAAAAAa");
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt);
    }

    public static void showTest() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAAAAAAAAa");
//                Toast.LENGTH_SHORT 2 3.5s
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
            }
        }, 10000);
    }
}
