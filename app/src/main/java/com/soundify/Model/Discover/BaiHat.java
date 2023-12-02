package com.soundify.Model.Discover;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class BaiHat implements Parcelable {
    private String IdBaiHat, TenBaiHat, HinhBaiHat, CaSi, IdTheLoai, HinhTheLoai, LinkNhac;

    public BaiHat(String idBaiHat, String tenBaiHat, String hinhBaiHat, String caSi, String idTheLoai, String hinhTheLoai, String linkNhac) {
        IdBaiHat = idBaiHat;
        TenBaiHat = tenBaiHat;
        HinhBaiHat = hinhBaiHat;
        CaSi = caSi;
        IdTheLoai = idTheLoai;
        HinhTheLoai = hinhTheLoai;
        LinkNhac = linkNhac;
    }
    public BaiHat(){

    }


    protected BaiHat(Parcel in) {
        IdBaiHat = in.readString();
        TenBaiHat = in.readString();
        HinhBaiHat = in.readString();
        CaSi = in.readString();
        IdTheLoai = in.readString();
        HinhTheLoai = in.readString();
        LinkNhac = in.readString();
    }

    public static final Creator<BaiHat> CREATOR = new Creator<BaiHat>() {
        @Override
        public BaiHat createFromParcel(Parcel in) {
            return new BaiHat(in);
        }

        @Override
        public BaiHat[] newArray(int size) {
            return new BaiHat[size];
        }
    };

    public String getLinkNhac() {
        return LinkNhac;
    }

    public void setLinkNhac(String linkNhac) {
        LinkNhac = linkNhac;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(IdBaiHat);
        parcel.writeString(TenBaiHat);
        parcel.writeString(HinhBaiHat);
        parcel.writeString(CaSi);
        parcel.writeString(IdTheLoai);
        parcel.writeString(HinhTheLoai);
        parcel.writeString(LinkNhac);
    }
}
