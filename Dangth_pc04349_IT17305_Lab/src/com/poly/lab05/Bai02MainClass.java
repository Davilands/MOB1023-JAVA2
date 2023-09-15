
package com.poly.lab05;

import java.util.ArrayList;
import java.util.List;

public class Bai02MainClass {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();//mảng chứa dữ liệu ghi vào file
        List<Student> list1 = new ArrayList<>();//mảng chứa dữ liệu lấy được từ file
        String path = "fileLab05\\students.dat";//Đường dẫn file
        //them đối tượng sinh viên vào mảng để ghi vào file
        list.add(new Student("Hoang", 5, "Biz"));
        list.add(new Student("Nam", 4, "Biz"));
        list.add(new Student("Truc", 1, "CNTT"));
        list.add(new Student("Mai", 7, "QTKD"));
        list.add(new Student("Duong", 3, "Data"));
       System.out.println("Thao tác đã hoàn thành vui lòng xem lại file");
        try {
            //Ghi dữ liệu vào file
            XFile.writeObj(path, list);
            
            //đọc dữ liệu từ file
            list1 = (List<Student>) XFile.readObj(path);
            for (Student sv1 : list1) {
                System.out.println("Name: " + sv1.getName());
                System.out.println("Mark: " + sv1.getMark());
                System.out.println("Major: " + sv1.getMajor());
                System.out.println("-----------------------");
            }

        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
