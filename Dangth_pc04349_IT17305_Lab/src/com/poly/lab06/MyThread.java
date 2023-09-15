package com.poly.lab06;

public class MyThread implements Runnable{
    
    //khai báo phương thức Run
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" " +i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
