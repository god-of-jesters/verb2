package com.example.verb2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.verb2.DB.DataUser;
import com.example.verb2.DB.User;
import com.example.verb2.RecycleView.Adapter;
import com.example.verb2.RecycleView.AdapterLeader;
import com.example.verb2.RecycleView.ItemLeader;
import com.example.verb2.databinding.FragmentLeadersBinding;
import com.example.verb2.spinner_cl.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Leaders extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int i = 1;
        List<ItemLeader> items = new ArrayList<>();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_leaders, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.re);

        for (User user: DataUser.getLeaders()){
            if (items.contains(new ItemLeader(user.getName(), Integer.toString(user.getScore()), Integer.toString(i), R.drawable.g))){
                items.add(new ItemLeader(user.getName(), Integer.toString(user.getScore()), Integer.toString(i), R.drawable.g));
            }
            i++;
        }

        AdapterLeader adapter = new AdapterLeader(getContext(), items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}