package com.example.verb2.DB;

public class RetrofitUserServ {
    private static UserApi userApi;

    private static UserApi create(){
        return RetrofitSrv.getInstance().create(UserApi.class);
    }

    public static UserApi getInstance() {
        if (userApi == null){
            userApi = create();
        }
        return userApi;
    }
}
