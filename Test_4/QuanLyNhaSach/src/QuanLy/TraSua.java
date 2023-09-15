package QuanLy;

import java.io.Serializable;

/**
 *
 * @author dangt
 */
public class TraSua implements Serializable {
    String maThucUong;
    String tenThucUong;
    int soLuong;
    float donGia;

    TraSua(String nC98, String tra_Sua_Dau, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TraSua(String maThucUong, String tenThucUong, int soLuong, float donGia) {
        this.maThucUong = maThucUong;
        this.tenThucUong = tenThucUong;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public TraSua(String text, String text0, Float valueOf, Float valueOf0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public String getMaThucUong() {
        return maThucUong;
    }

    public void setMaThucUong(String maThucUong) {
        this.maThucUong = maThucUong;
    }

    public String getTenThucUong() {
        return tenThucUong;
    }

    public void setTenThucUong(String tenThucUong) {
        this.tenThucUong = tenThucUong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    
    
    public TraSua() {
    }
    
    
    
    
}
