package com.example.verb2.DB;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UserApi {

    @GET("user")
    Call<List<User>> getUsers();

    @POST("user")
    Call<User> add(@Body User user);

    @POST("user")
    Call<User> update(@Body User user);

    @DELETE("user/{id}")
    Call<ResponseBody> delete(@Path("id") String id);

}

