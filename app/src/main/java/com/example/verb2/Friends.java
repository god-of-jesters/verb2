package com.example.verb2;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.verb2.RecycleView.Adapter;
import com.example.verb2.RecycleView.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        list.add(new Item("Dima", "15", R.drawable.baseline_home_24));

        Adapter adapter = new Adapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}