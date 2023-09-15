package com.poly.lab07;

public class Xpoly {
    @Deprecated
    public static boolean isCardNumber(String number){
        int n = Integer.parseInt(number);
        
        int tong = 0;
        while(n > 0){
            int a = n % 10;
            n = n/10;
            tong += a;
        }
        
        if(tong % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
}
