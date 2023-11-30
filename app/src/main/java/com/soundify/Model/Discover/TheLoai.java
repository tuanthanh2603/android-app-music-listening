package com.soundify.Model.Discover;

public class TheLoai {
    private String idTheLoai, idChuDe, tenTheLoai, hinhTheLoai ;

    public String getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(String idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getIdChuDe() {
        return idChuDe;
    }

    public void setIdChuDe(String idChuDe) {
        this.idChuDe = idChuDe;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getHinhTheLoai() {
        return hinhTheLoai;
    }

    public void setHinhTheLoai(String hinhTheLoai) {
        this.hinhTheLoai = hinhTheLoai;
    }

    public TheLoai(String idTheLoai, String idChuDe, String tenTheLoai, String hinhTheLoai) {
        this.idTheLoai = idTheLoai;
        this.idChuDe = idChuDe;
        this.tenTheLoai = tenTheLoai;
        this.hinhTheLoai = hinhTheLoai;
    }
    public TheLoai(){

    }
}
