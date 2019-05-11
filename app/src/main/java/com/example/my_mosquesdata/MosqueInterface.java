package com.example.my_mosquesdata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MosqueInterface {

    @GET("{page}")
    Call<String> getdata(@Query("page") int page);
}
