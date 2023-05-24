package com.example.verb2.DB;

import static java.lang.Thread.sleep;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.verb2.Login_pac.Login_system;
import com.example.verb2.spinner_cl.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataUser implements Runnable {
    private static List<Item> items1;
    private static List<Item> items2;
    public static List<Integer> ids = new ArrayList<>();
    public static List<User> users = new ArrayList<User>();
    public static Map<String, String> names = new HashMap<>();
    public static List<Long> friends = new ArrayList<>();

    @Override
    public void run() {
        try {
            while (true){
                takeName();
                getFriend();
//                update();
                sleep(5000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeName() {
        RetrofitUserServ.getInstance().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                if(response != null) {
                    writeData(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                Log.d("AAAAAAAA", String.valueOf(t));
            }
        });
    }

    public static void update(){
        if (Login_system.getUser() != null){
            System.out.println(getUser(Login_system.getUser().getName()).getId());
            RetrofitUserServ.getInstance().delete(Integer.toString(getUser(Login_system.getUser().getName()).getId())).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    System.out.println("Не Удачно");
                }
            });

            RetrofitUserServ.getInstance().update(Login_system.getUser()).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    System.out.println("Удачно");
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    System.out.println("Не Удачно");
                }
            });
        }

    }

    public static void writeData(Response<List<User>> response){
        assert response.body() != null;
        for(User user: response.body()){
            if (!ids.contains(user.getId())){
                ids.add(user.getId());
                names.put(user.getName(), user.getPassword());
                users.add(user);
            }
        }
    }

    public static void regestrated(String name, String passsword){
        RetrofitUserServ.getInstance().add(new User(0, name, passsword, 0)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                takeName();
                System.out.println(users);
                Log.d("СОЗДААААААААЛ", "СОЗДААААААААЛ");
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("НЕЕЕЕЕЕЕ СОЗДААААААААЛ", "НЕЕЕЕЕЕЕ СОЗДААААААААЛ");
            }
        });
    }

    public static ArrayList<Item> takeItems1(){
        items1 = new ArrayList<Item>();

        items1.add(new Item("Скорость", "Измерение количества примеров, решенных за 30 секунд"));
        items1.add(new Item("Правильность", "Измерение верных ответов из 10 примеров"));
        items1.add(new Item("Аккуратность", "Измерение количества правильных ответов до первой ошибки"));

        return (ArrayList<Item>) items1;
    }

    public static ArrayList<Item> takeItems2(){
        items2 = new ArrayList<Item>();

        items2.add(new Item("Сложение", "Тренировка сложения"));
        items2.add(new Item("Вычитание", "Тренировка вычитания"));
        items2.add(new Item("Умножение", "Тренировка умножения"));
        items2.add(new Item("Деление", "Тренировка деления"));
        items2.add(new Item("Извлечение корня", "Извлечение квадратного корня"));
        return (ArrayList<Item>) items2;
    }

    public static User getUser(String name){
        takeName();
        for(User user: users){
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public static User getUserById(long id){
        for(User user: users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public static void getFriend(){
        RetrofitFriendServ.getInstance().getFriends().enqueue(new Callback<List<Friend>>() {
            @Override
            public void onResponse(Call<List<Friend>> call, Response<List<Friend>> response) {
                long id = -1;
                System.out.println(ids.toString());
                if(Login_system.getUser() != null){
                    id = Login_system.getUser().getId();
                }

                for (Friend friend: response.body()){
                    if (friend.getUserId() == id && !friends.contains(friend.getFriendId())){
                        friends.add(friend.getFriendId());
                    } else if (friend.getFriendId() == id && !friends.contains(friend.getUserId())) {
                        friends.add(friend.getUserId());
                    }
                }
                System.out.println(friends.toString());
            }

            @Override
            public void onFailure(Call<List<Friend>> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    public static long getMax(){
        long max = -2;
        for (long i: ids){
            if (i>max) max = i;
        }
        return max;
    }

    public static List<User> getLeaders(){
        List<User> led = new ArrayList<>();
        List<Integer> score = new ArrayList<>();
        for(User user: users){
            score.add(user.getScore());
        }
        Collections.sort(score);
        Collections.reverse(score);
        for (int i: score){
            for (User user: users){
                if (user.getScore() == i && !led.contains(user)){
                    led.add(user);
                }
            }
        }
        return led;
    }
}
