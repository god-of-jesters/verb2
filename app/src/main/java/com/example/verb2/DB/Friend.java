package com.example.verb2.DB;

public class Friend {
    private long id;
    private long user_id;
    private long friend_id;

    public Friend(long id, long user_id, long friend_id){
        this.id = id;
        this.friend_id = friend_id;
        this.user_id = user_id;
    }
    public long getUserId(){return user_id;}
    public long getFriendId(){return friend_id;}
}
