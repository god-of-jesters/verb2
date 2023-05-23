package com.example.verb2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.verb2.Login_pac.Login_system;
import com.example.verb2.databinding.FragmentProfileBinding;

public class Profile extends Fragment {
    FragmentProfileBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile, container, false);

        TextView name = view.findViewById(R.id.textView8);
        TextView score = view.findViewById(R.id.textView9);

        name.setText(Login_system.getUser().getName());
        score.setText("Очки: " + String.valueOf(Login_system.getUser().getScore()));

        return view;
    }
}