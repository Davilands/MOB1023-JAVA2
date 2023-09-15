
package com.poly.lab05;

public class Bai01MainClass {
    public static void main(String[] args) {
        try {
            byte[] data = XFile.read("fileLab05\\file1.txt");
            XFile.write("fileLab05\\file2.txt", data);
            System.out.println("Thao tác đã hoàn thành vui lòng xem lại file");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
