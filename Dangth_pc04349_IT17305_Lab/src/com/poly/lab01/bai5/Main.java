package com.poly.lab01.bai5;

/**
 *
 * @author dangt
 */
public class Main {

    public static void main(String[] args) {
        //SINH VIÊN ĐANG HỌC
        SinhVien sv1 = new SinhVien();
        System.out.println("-----Student 01----");
        sv1.nhap();
        sv1.getEmail();
        sv1.xuat();
        System.out.println("");
        
        //SINH VIÊN ĐÃ RA TRƯỜNG
        
        //  NHỮNG SINH VIÊN ĐÃ RA TRƯỜNG SẼ KHÔNG CÓ EMAIL TRƯỜNG,
        //  VÌ VẬY EM XÂY DỰNG PHƯƠNG THỨC GHI ĐÈ LÊN PƯƠNG THỨC getEMAIL
        SinhVienNoEmail sv2 = new SinhVienNoEmail();
        System.out.println("-----Student 01 [No Email]----");
        sv2.nhap();
        sv2.getEmail();
        sv2.xuat();
        System.out.println("");
        
        
        //INTERFACE
//        ConNguoi cn = new ConNguoi();
//        System.out.println("-----Student Editing----");
//        cn.insert();
//        cn.delete();
//        cn.update();
//        cn.select();
    }

}
