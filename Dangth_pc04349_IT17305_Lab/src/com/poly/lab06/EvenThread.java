package com.poly.lab06;

public class EvenThread extends Thread{
    @Override
    public void run(){
        for (int i = 2; i <= 20; i += 2){
            System.out.println(" " + i);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
