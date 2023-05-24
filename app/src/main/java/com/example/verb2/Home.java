package com.example.verb2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.verb2.DB.DataUser;
import com.example.verb2.Tests.Action;
import com.example.verb2.databinding.FragmentHomeBinding;
import com.example.verb2.spinner_cl.Item;
import com.example.verb2.spinner_cl.SpinnerAdapter;
import com.example.verb2.spinner_cl.SpinnerAdapterLit;

import java.util.List;
public class Home extends Fragment {
    private FragmentHomeBinding binding;
    List<Item> items1 = DataUser.takeItems1();
    List<Item> items2 = DataUser.takeItems2();
    List<Item> items3 = DataUser.takeItems3();
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
        Button button = binding.button;

        SpinnerAdapter adapter = new SpinnerAdapter(inflater.getContext(), R.layout.item_s, items1);
        spinner2.setAdapter(adapter);
        SpinnerAdapter adapter1 = new SpinnerAdapter(inflater.getContext(), R.layout.item_site, items2);
        spinner3.setAdapter(adapter1);
        SpinnerAdapterLit adapter2 = new SpinnerAdapterLit(inflater.getContext(), R.layout.item_site, items3);
        spinner1.setAdapter(adapter2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Action.class);
                Item action = (Item) spinner2.getSelectedItem();
                Item style = (Item) spinner3.getSelectedItem();
                Item hard = (Item) spinner1.getSelectedItem();
                intent.putExtra("Action", action.getName());
                intent.putExtra("Style", style.getName());
                intent.putExtra("Hard", hard.getName());
                startActivity(intent);
            }
        });

        View view = binding.getRoot();
        return view;
    }
}

