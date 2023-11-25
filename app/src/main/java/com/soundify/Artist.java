package com.soundify;

public class Artist {

    public Artist(String title, String artist, String picture) {
    this.title = title;
    this.artist = artist;
    this.picture = picture;
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

    String title, artist, picture;
}
