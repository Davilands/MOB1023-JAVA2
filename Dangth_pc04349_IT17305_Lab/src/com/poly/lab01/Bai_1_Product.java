package com.poly.lab01;

import java.util.Scanner;

/**
 *
 * @author dangth
 */
public class Bai_1_Product implements Bai_4_DAO {
    private String name;
    private double price;

    public Bai_1_Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Bai_1_Product() {
    }
    
    public void nhap() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap Name: ");
        name = in.nextLine();
        System.out.print("Nhap Price: ");
        price = in.nextDouble();
    }
    
    public void xuat() {
        System.out.printf("Name: %s - Price: %s - Tax: %.1f\n",name,price,getImportTax()); 
//        System.out.println("Thue: " + getImportTax());
    }
    
    public double getImportTax() {
        return (price * 0.1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
//    public static void main(String[] args) {
//        Bai_1_Product product = new Bai_1_Product();
//        product.nhap();
//        product.xuat();
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
