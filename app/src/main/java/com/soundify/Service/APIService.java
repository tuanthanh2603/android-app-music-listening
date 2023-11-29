package com.soundify.Service;

public class APIService {
    private static String base_url = "https://musicapp29263.000webhostapp.com/Server/";
    public static DataService getService(){
        return  APIClient.getClient(base_url).create(DataService.class);
    }
}
