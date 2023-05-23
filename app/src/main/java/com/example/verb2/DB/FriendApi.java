package com.example.verb2.DB;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FriendApi {

    @GET("friend")
    Call<List<Friend>> getFriends();

    @POST("friend")
    Call<Friend> add(@Body Friend friend);

    @DELETE("friend")
    Call<Friend> delete(@Body Friend friend);
}
