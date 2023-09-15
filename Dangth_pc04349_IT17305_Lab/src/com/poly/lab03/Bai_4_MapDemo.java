package com.poly.lab03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bai_4_MapDemo {
    public static void main(String[] args) {
        Map<String, Bai_2_Student> map = new HashMap<>();   
        Bai_2_Student sv = new Bai_2_Student("Đang", "Ứng dụng phần mềm", 9);
        map.put(sv.getTen(), sv);
        
        Set<String> keys = map.keySet();
        
        for (String key : keys) {
            Bai_2_Student sv1 = map.get(key);
            System.out.println("Họ và tên: " +sv.getTen());
            System.out.println("Học lực: " +sv.getHocLuc());
        }
    }

}
