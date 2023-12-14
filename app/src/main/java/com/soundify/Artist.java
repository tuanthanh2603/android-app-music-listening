package com.soundify;

public class Artist {

    private int sequentialNumber;
    public void setSequentialNumber(int sequentialNumber) {
        this.sequentialNumber = sequentialNumber;
    }
    public int getSequentialNumber() {
        return sequentialNumber;
    }



    String id, title, artist, picture,position,linknhac;
    public String getPosition() {
        return position;
    }

    public String getLinknhac() {
        return linknhac;
    }

    public void setLinknhac(String linknhac) {
        this.linknhac = linknhac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Artist(String id,String title, String artist, String picture,String linknhac, String position) {
        this.id=id;
    this.title = title;
    this.artist = artist;
    this.picture = picture;
    this.linknhac=linknhac;
    this.position=position;

}

    public Artist(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {this.artist = artist;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
