package com.example.verb2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.verb2.DB.Data;
import com.example.verb2.databinding.FragmentHomeBinding;
import com.example.verb2.spinner_cl.Item;
import com.example.verb2.spinner_cl.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;
public class Home extends Fragment {
    private FragmentHomeBinding binding;
    List<Item> items1 = Data.takeItems1();
    List<Item> items2 = Data.takeItems2();

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

        SpinnerAdapter adapter = new SpinnerAdapter(inflater.getContext(), R.layout.item_s, items1);
        spinner2.setAdapter(adapter);
        SpinnerAdapter adapter1 = new SpinnerAdapter(inflater.getContext(), R.layout.item_site, items2);
        spinner3.setAdapter(adapter1);

        View view = binding.getRoot();

        return view;
    }
}