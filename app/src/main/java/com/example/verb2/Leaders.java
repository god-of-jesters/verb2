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
    private FragmentLeadersBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeadersBinding.inflate(inflater, container, false);


        View view = binding.getRoot();

        return view;
    }
}