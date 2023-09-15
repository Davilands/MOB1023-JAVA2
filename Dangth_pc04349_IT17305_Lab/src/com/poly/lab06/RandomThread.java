package com.poly.lab06;

import javax.swing.JTextField;

public class RandomThread extends Thread{
    private JTextField text;
    
    public void RandomThread(JTextField text){
        this.text = text;
    }
    @Override
    public void run(){
        for(int i = 0; i<1000; i++){
            try {
                int so = (int) Math.round(Math.random() * 9);
                text.setText(String.valueOf(so));
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
