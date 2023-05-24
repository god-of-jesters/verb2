package com.example.verb2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.verb2.DB.DataFriend;
import com.example.verb2.DB.DataUser;
import com.example.verb2.DB.User;
import com.example.verb2.Login_pac.Login_system;
import com.example.verb2.RecycleView.Adapter;
import com.example.verb2.RecycleView.Item;

import java.util.ArrayList;
import java.util.List;

public class Friends extends Fragment {
    List<Item> list = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_friends, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.re);

        for (long i: DataUser.friends){
            if (i != 0){
                User user = DataUser.getUserById(i);
                if (!list.contains(new Item(user.getName(), String.valueOf(user.getScore()), R.drawable.g))){
                    list.add(new Item("Имя: " + user.getName(),"Очки: " + String.valueOf(user.getScore()), R.drawable.g));
                }else{
                    System.out.println("Врет!");
                }
            }
        }

        Adapter adapter = new Adapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        EditText name_ed = view.findViewById(R.id.editTextText3);
        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name_ed.getText().toString() != ""){
                    String name = name_ed.getText().toString().trim();
                    if (Login_system.getUser().getId() != -1){
                        DataFriend.writeFriend(Login_system.getUser().getId(), DataUser.getUser(name).getId());
                    }

                    for (long i: DataUser.friends){
                        if (i != 0){
                            User user = DataUser.getUserById(i);
                            if (!list.contains(new Item(user.getName(), String.valueOf(user.getScore()), R.drawable.g))){
                                list.add(new Item("Имя: " + user.getName(),"Очки: " + String.valueOf(user.getScore()), R.drawable.g));
                            }
                        }
                    }

                    recyclerView.getAdapter().notifyItemInserted(list.size()-1);
                }
            }
        });
        return view;
    }
}