
package com.poly.lab01.bai5;

/**
 *
 * @author dangt
 */
//  NHỮNG SINH VIÊN ĐÃ RA TRƯỜNG SẼ KHÔNG CÓ EMAIL TRƯỜNG,
//  VÌ VẬY EM XÂY DỰNG PHƯƠNG THỨC GHI ĐÈ LÊN TRƯỜNG getEMAIL
public class SinhVienNoEmail extends SinhVien {
    public String getEmail(){
        return "No Email";
    }
    
    public void nhap(){
        super.nhap();
    }
    
    public void xuat() {
        super.xuat();
    }
}
