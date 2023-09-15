package com.poly.lab06;

public class OddThread extends Thread{
    @Override
    public void run(){
        for (int i = 1; i < 20; i += 2){
            System.out.println(" " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
