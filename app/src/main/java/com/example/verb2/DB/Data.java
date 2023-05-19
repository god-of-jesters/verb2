package com.example.verb2.DB;

import static java.lang.Thread.sleep;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.verb2.spinner_cl.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Data implements Runnable {
    private static List<Item> items1;
    private static List<Item> items2;
    static List<Integer> ids = new ArrayList<>();
    public static List<User> users = new ArrayList<User>();
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
                users.add(user);
                System.out.println(user.getId());
            }
        }
    }

    public static ArrayList<Item> takeItems1(){
        items1 = new ArrayList<Item>();

        items1.add(new Item("Скорость", "Вам дается возможность посоревноваться в скорости решении 10 примеров"));
        items1.add(new Item("Правильность", "Сколько же правильных вы сможете сделать из 10 примеров"));
        items1.add(new Item("Аккуратность", "Можете решать сколько угодно, только у вас есть одна ошибка"));

        return (ArrayList<Item>) items1;
    }

    public static ArrayList<Item> takeItems2(){
        items2 = new ArrayList<Item>();

        items2.add(new Item("Сложение", "Тренировка сложения"));
        items2.add(new Item("Вычитание", "Тренировка вычитания"));
        items2.add(new Item("Умножение", "Тренировка умножения"));
        items2.add(new Item("Деление", "Тренировка деления"));

        return (ArrayList<Item>) items2;
    }
}
