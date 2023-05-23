package com.example.verb2.DB;

public class RetrofitFriendServ {
    private static FriendApi friendApi;

    private static FriendApi create(){
        return RetrofitSrv.getInstance().create(FriendApi.class);
    }

    public static FriendApi getInstance() {
        if (friendApi == null) friendApi = create();
        return friendApi;
    }
}
