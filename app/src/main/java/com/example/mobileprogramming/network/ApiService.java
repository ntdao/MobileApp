package com.example.mobileprogramming.network;

import com.example.mobileprogramming.AQIResponse;
import com.example.mobileprogramming.LoginRequest;
import com.example.mobileprogramming.LoginResponse;
import com.example.mobileprogramming.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://103.1.238.175:8000/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("auth/customer/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @GET("social/getCurrentAQI")
    Call<List<AQIResponse>> getCurrentAQI();
}
