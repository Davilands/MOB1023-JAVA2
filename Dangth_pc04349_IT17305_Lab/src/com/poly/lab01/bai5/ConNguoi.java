
package com.poly.lab01.bai5;

import java.util.Scanner;

/**
 * @author dangt
 */
public class ConNguoi implements Bai05_Interface {
    private String hoTen;

    private int namSinh;


    public String getHoTen() {
        return hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

      
    public void nhap() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap vao ho ten: ");
        hoTen = in.nextLine();
        System.out.print("Nhap vao nam sinh: ");
        namSinh = in.nextInt();
    }
    
    public void xuat() {
        System.out.printf("Ho ten: %s  - Nam Sinh: %d \n",hoTen,namSinh);
    }
    
//    public static void main(String[] args) {
//        ConNguoi cn = new ConNguoi();
//        cn.nhap();
//        cn.xuat();
//    }
    
    public void insert(){
        System.out.println("Them thanh cong!");
    }
    public void update(){
        System.out.println("Cap nhat thanh cong!");
    }
    public void delete(){
        System.out.println("Xoa cong!");
    }
    public void select(){
        System.out.println("Hien thi thong tin cong!");
    }
}
