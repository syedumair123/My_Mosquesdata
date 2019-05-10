package com.example.my_mosquesdata;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MosqueInterface {
    String jsonurl="http://masjidi.co.uk/api/getMosquesList/";
    @GET("33")
    Call<String> getdata();
}
