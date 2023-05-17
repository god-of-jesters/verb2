package com.example.verb2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.verb2.databinding.FragmentLeadersBinding;
import com.example.verb2.spinner_cl.Item;
import com.example.verb2.spinner_cl.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Leaders extends Fragment {
    List<Item> items1 = new ArrayList<>();
    private FragmentLeadersBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeadersBinding.inflate(inflater, container, false);

        items1.add(new Item("Скорость", "Вам дается возможность посоревноваться в скорости решении 10 примеров"));
        items1.add(new Item("Правильность", "Сколько же правильных вы сможете сделать из 10 примеров"));
        items1.add(new Item("Аккуратность", "Можете решать сколько угодно, только у вас есть одна ошибка"));

        Spinner spinner1 = binding.spinner4;
        SpinnerAdapter adapter = new SpinnerAdapter(inflater.getContext(), R.layout.item_s, items1);
        spinner1.setAdapter(adapter);

        View view = binding.getRoot();

        return view;
    }
}