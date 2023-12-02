package com.soundify.Model.Discover;

public class DangChuY {
    private String IdQuangCao, HinhQuangCao, NoiDung, IdBaiHat, TenBaiHat, HinhBaiHat;

    public DangChuY(String idQuangCao, String hinhQuangCao, String noiDung, String idBaiHat, String tenBaiHat, String hinhBaiHat) {
        IdQuangCao = idQuangCao;
        HinhQuangCao = hinhQuangCao;
        NoiDung = noiDung;
        IdBaiHat = idBaiHat;
        TenBaiHat = tenBaiHat;
        HinhBaiHat = hinhBaiHat;

    }
    public DangChuY(){

    }



    public String getIdQuangCao() {
        return IdQuangCao;
    }

    public void setIdQuangCao(String idQuangCao) {
        IdQuangCao = idQuangCao;
    }

    public String getHinhQuangCao() {
        return HinhQuangCao;
    }

    public void setHinhQuangCao(String hinhQuangCao) {
        HinhQuangCao = hinhQuangCao;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
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
}
