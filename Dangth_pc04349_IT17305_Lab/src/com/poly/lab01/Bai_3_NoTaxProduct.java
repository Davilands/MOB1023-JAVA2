package com.poly.lab01;

/**
 *
 * @author dangt
 */
public class Bai_3_NoTaxProduct extends Bai_1_Product {
    
    @Override
    public double getImportTax(){
        return 0;
    }
    
    public void nhap(){
        super.nhap();
    }
    
    public void xuat() {
        super.xuat();
    }
    
    public static void main(String[] args) {
        System.out.println("----Product 01-----");
        Bai_1_Product product1 = new Bai_1_Product();
        product1.nhap();
        product1.getImportTax();
        product1.xuat();
      
        System.out.println("----Product 02-----");
        Bai_1_Product product2 = new Bai_1_Product();
        product2.nhap();
        product2.getImportTax();
        product2.xuat();
        
        
        System.out.println("----Product 03 (No Tax)-----");
        Bai_3_NoTaxProduct product3 = new Bai_3_NoTaxProduct();
        product3.nhap();
        product3.getImportTax();
        product3.xuat();
        
    }
}
