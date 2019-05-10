package com.example.my_mosquesdata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MosqueInterface {

    String jsonurl="http://masjidi.co.uk/api/";
    @GET("getMosquesList/{id}{page}")
    Call<String> getdata(@Path("id") int id,
                         @Path("page") String page);
}
