package com.poly.lab01.bai5;

import java.util.Scanner;

/**
 *
 * @author dangt
 */
//FINAL : KHÔNG CHO PHÉP THỪA KẾ (ĐỨNG TRƯỚC CLASS)
//        KHÔNG CHO PHÉP GHI ĐÈ (ĐỨNG TRƯỚC METHOD)
//        KHÔNG CHO PHÉP SỬA GIÁ TRỊ BIẾN (ĐỨNG TRƯỚC BIẾN)
public class SinhVien extends ConNguoi {
    
    private String mssv;
    private String nganhHoc;
    
    @Override
    public void nhap() {
        super.nhap();
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap MSSV: ");
        mssv = in.nextLine();
        System.out.print("Nhap Nganh hoc: ");
        nganhHoc = in.nextLine();
    }
    
    public String getEmail(){
        return "k17" + mssv + "@fpt.edu.vn";
    }
    
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("MSSV: %s - Nganh: %s \n",mssv,nganhHoc);
        System.out.println("Email: " + getEmail());
    }
    
    
    
//    public static void main(String[] args) {
//        SinhVien sv = new SinhVien();
//        sv.nhap();
//        sv.xuat();
//    }
}
