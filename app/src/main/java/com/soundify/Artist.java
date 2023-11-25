package com.soundify;

public class Artist {

    public Artist(String name, String numOfFans, String picLink) {
    this.name = name;
    this.numOfFans = numOfFans;
    this.picLink = picLink;
}

    public Artist(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumOfFans() {
        return numOfFans;
    }

    public void setNumOfFans(String numOfFans) {
        this.numOfFans = numOfFans;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    String name, numOfFans, picLink;
}
