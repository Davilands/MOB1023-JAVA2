package com.poly.lab01;

import com.poly.lab01.bai5.ConNguoi;
import com.poly.lab01.bai5.SinhVien;
import com.poly.lab01.bai5.SinhVienNoEmail;
import java.util.Scanner;

/**
 *
 * @author dangt
 */
public class Bai_5_TongHop {
    
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
        Scanner in = new Scanner(System.in);
        int chon;
        System.out.print("Bạn có muốn thực hiện các thao tác CSDL không? (1.Có - 0.Không): ");
        chon = in.nextInt();
        if (chon ==1) {
            ConNguoi cn = new ConNguoi();
            System.out.println("-----Student Editing----");
            cn.insert();
            cn.delete();
            cn.update();
            cn.select();
        }
        
    }
}
