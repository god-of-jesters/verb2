package com.example.verb2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.verb2.databinding.FragmentHomeBinding;
import com.example.verb2.spinner_cl.Item;
import com.example.verb2.spinner_cl.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;
//items1.add(new Item("Скорость", "Вам дается возможность посоревноваться в скорости решении 10 примеров"));
//        items1.add(new Item("Правильность", "Сколько же правильных вы сможете сделать из 10 примеров"));
//        items1.add(new Item("Аккуратность", "Можете решать сколько угодно, только у вас есть одна ошибка"));
//
//        items2.add(new Item("Скорость", "Вам дается возможность посоревноваться в скорости решении 10 примеров"));
//        items2.add(new Item("Правильность", "Сколько же правильных вы сможете сделать из 10 примеров"));
//        items2.add(new Item("Аккуратность", "Можете решать сколько угодно, только у вас есть одна ошибка"));
public class Home extends Fragment {
    private FragmentHomeBinding binding;
    List<Item> items1 = new ArrayList<>();
    List<Item> items2 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        Spinner spinner1 = binding.spinner;
        Spinner spinner2 = binding.spinner2;
        Spinner spinner3 = binding.spinner3;

        items1.add(new Item("Скорость", "Вам дается возможность посоревноваться в скорости решении 10 примеров"));
        items1.add(new Item("Правильность", "Сколько же правильных вы сможете сделать из 10 примеров"));
        items1.add(new Item("Аккуратность", "Можете решать сколько угодно, только у вас есть одна ошибка"));

        items2.add(new Item("Сложение", "Тренировка сложения"));
        items2.add(new Item("Вычитание", "Тренировка вычитания"));
        items2.add(new Item("Умножение", "Тренировка умножения"));
        items2.add(new Item("Деление", "Тренировка деления"));

        SpinnerAdapter adapter = new SpinnerAdapter(inflater.getContext(), R.layout.item_s, items1);
        spinner2.setAdapter(adapter);
        SpinnerAdapter adapter1 = new SpinnerAdapter(inflater.getContext(), R.layout.item_site, items2);
        spinner3.setAdapter(adapter1);

        View view = binding.getRoot();

        return view;
    }
}