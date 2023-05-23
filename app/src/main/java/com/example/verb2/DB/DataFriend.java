package com.example.verb2.DB;

import android.util.Log;

import com.example.verb2.Login_pac.Login_system;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataFriend {



    public static void writeFriend(long id, long friend_id){
        RetrofitFriendServ.getInstance().add(new Friend(0, id, friend_id)).enqueue(new Callback<Friend>() {
            @Override
            public void onResponse(Call<Friend> call, Response<Friend> response) {
            }
            @Override
            public void onFailure(Call<Friend> call, Throwable t) {
                Log.d("НЕЕЕЕЕЕЕ СОЗДААААААААЛ", "НЕЕЕЕЕЕЕ СОЗДААААААААЛ");
            }
        });
    }
}
