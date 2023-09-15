
package com.poly.lab08;

import java.util.ArrayList;


public class Lab8Bai2 {

    public static void main(String[] args) {
        ArrayList<Integer> myarr = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            myarr.add(i);
        }
        myarr.forEach((a) ->{
        System.out.println(" "+a);
    });
    }
    
}
