
package com.poly.lab01;

/**
 *
 * @author dangt
 */
public interface Bai_4_DAO {
    
    public void insert();
    public void update();
    public void delete();
    public void select();
    
    public static void main(String[] args) {
        Bai_1_Product product = new Bai_1_Product();
        product.insert();
        product.delete();
        product.update();
        product.select();
    }
}
