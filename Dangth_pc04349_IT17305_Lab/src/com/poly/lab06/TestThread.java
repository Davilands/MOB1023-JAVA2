package com.poly.lab06;

public class TestThread {

    public static void main(String[] args) {
        OddThread t1 = new OddThread();
        EvenThread t2 = new EvenThread();

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
        }
        t2.start();
        System.out.println("Thread run un main............");
    }
}
