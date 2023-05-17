package com.example.verb2.DB;

import static java.lang.Thread.sleep;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Data implements Runnable {
    static List<Integer> ids = new ArrayList<>();
    public static Map<String, String> names = new HashMap<>();
    @Override
    public void run() {
        try {
            while (true){
                takeName();
                sleep(5000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeName() {
        System.out.println("НУ Я ПОПЫТАЛСЯ");
        RetrofitUserServ.getInstance().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                if(response != null) {
                    writeData(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                System.out.println("НУ НЕ ПОЛУЧИЛОСЬ");
                Log.d("AAAAAAAA", "AAAAAAAAAAAAAAAAAA");
            }
        });
    }

    public void writeData(Response<List<User>> response){
        assert response.body() != null;
        for(User user: response.body()){
            if (!ids.contains(user.getId())){
                ids.add(user.getId());
                names.put(user.getName(), user.getPassword());
                System.out.println(user.getId());
            }
        }

    }
}
