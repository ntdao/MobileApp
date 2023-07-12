package com.example.mobileprogramming.network;

import com.example.mobileprogramming.AQIResponse;
import com.example.mobileprogramming.LoginRequest;
import com.example.mobileprogramming.LoginResponse;
import com.example.mobileprogramming.SwitchRequest;
import com.example.mobileprogramming.SwitchResponse;
import com.example.mobileprogramming.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
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


//    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//    httpClient.addInterceptor(new Interceptor() {
//        @Override
//        public Response intercept(Interceptor.Chain chain) throws IOException {
//            Request originalRequest = chain.request();
//            Request.Builder builder = originalRequest.newBuilder().header("Authorization",
//                    "Bearer " + token);
//            Request newRequest = builder.build();
//            return chain.proceed(newRequest);
//        }
//    });
//    ApiService apiServiceAuth = new Retrofit.Builder()
//            .baseUrl("http://103.1.238.175:8000/api/")
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client()
//            .build()
//            .create(ApiService.class);

    @POST("auth/customer/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @GET("social/getCurrentAQI")
    Call<List<AQIResponse>> getCurrentAQI();

    @GET("auth/customer")
    Call<User> getUserProfile(@Header("Authorization") String token);

    @POST("device/switch1")
    Call<SwitchResponse> switchLight1(@Body SwitchRequest request);
    @POST("device/switch2")
    Call<SwitchResponse> switchLight2(@Body SwitchRequest request);
    @POST("device/switch3")
    Call<SwitchResponse> switchLight3(@Body SwitchRequest request);
    @POST("device/switch4")
    Call<SwitchResponse> switchLight4(@Body SwitchRequest request);
    @POST("device/switch5")
    Call<SwitchResponse> switchLight5(@Body SwitchRequest request);
}
