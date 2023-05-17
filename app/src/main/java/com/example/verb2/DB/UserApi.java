package com.example.verb2.DB;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {

    @GET("user")
    Call<List<User>> getUsers();

    @POST("user")
    Call<User> add(@Body User user);
}

