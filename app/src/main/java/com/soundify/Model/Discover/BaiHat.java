package com.soundify.Model.Discover;

public class BaiHat {
    private String IdBaiHat, TenBaiHat, HinhBaiHat, CaSi, IdTheLoai, HinhTheLoai;

    public BaiHat(String idBaiHat, String tenBaiHat, String hinhBaiHat, String caSi, String idTheLoai, String hinhTheLoai) {
        IdBaiHat = idBaiHat;
        TenBaiHat = tenBaiHat;
        HinhBaiHat = hinhBaiHat;
        CaSi = caSi;
        IdTheLoai = idTheLoai;
        HinhTheLoai = hinhTheLoai;
    }
    public BaiHat(){

    }



    public String getIdBaiHat() {
        return IdBaiHat;
    }

    public void setIdBaiHat(String idBaiHat) {
        IdBaiHat = idBaiHat;
    }

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        TenBaiHat = tenBaiHat;
    }

    public String getHinhBaiHat() {
        return HinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
        HinhBaiHat = hinhBaiHat;
    }

    public String getCaSi() {
        return CaSi;
    }

    public void setCaSi(String caSi) {
        CaSi = caSi;
    }

    public String getIdTheLoai() {
        return IdTheLoai;
    }

    public void setIdTheLoai(String idTheLoai) {
        IdTheLoai = idTheLoai;
    }

    public String getHinhTheLoai() {
        return HinhTheLoai;
    }

    public void setHinhTheLoai(String hinhTheLoai) {
        HinhTheLoai = hinhTheLoai;
    }
}
