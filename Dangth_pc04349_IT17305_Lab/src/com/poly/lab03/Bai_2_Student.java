package com.poly.lab03;

public class Bai_2_Student {
    String ten;
    private String nganh;
    private double diem;

    public Bai_2_Student(String ten, String nganh, double diem) {
        this.ten = ten;
        this.nganh = nganh;
        this.diem = diem;
    }

    public Bai_2_Student() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
    
    public String getHocLuc(){
        if(diem >= 9){
            return "Xuất sắc";
        } else if(diem >= 7.5){
            return "Giỏi";
        }else if(diem >= 6.5){
            return "Khá";
        }else if(diem >=5){
            return "Trung bình";
        }else if (diem >= 3){
            return "Yếu";
        }else return "Kém";
    }
    
    //Nếu điểm >= 7.5 thì hàm trả về true
    public boolean isBonus(){
        return diem >= 7.5;
    }
}
