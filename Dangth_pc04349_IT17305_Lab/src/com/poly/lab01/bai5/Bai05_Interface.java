package com.poly.lab01.bai5;

/**
 *
 * @author dangt
 */
public interface Bai05_Interface {
    public void insert();
    public void update();
    public void delete();
    public void select();
    
    public static void main(String[] args) {
        ConNguoi cn = new ConNguoi();
        cn.insert();
        cn.delete();
        cn.update();
        cn.select();
    }
}
