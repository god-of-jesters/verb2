package com.example.verb2.Login_pac;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.verb2.DB.RetrofitUserServ;
import com.example.verb2.DB.User;
import com.example.verb2.R;
import com.example.verb2.databinding.FragmentSingUpBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sing_up extends Fragment {
    FragmentSingUpBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sing_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button2);
        EditText name = view.findViewById(R.id.editTextText);
        EditText pas = view.findViewById(R.id.editTextText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zdfbnjilmopnjlmdpfvbmoopdfbm");
                regestrated(name.getText().toString(), pas.getText().toString());
            }
        });
    }

    public void regestrated(String name, String passsword){

        RetrofitUserServ.getInstance().add(new User(0, name, passsword, 0)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("СОЗДААААААААЛ", "СОЗДААААААААЛ");
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("НЕЕЕЕЕЕЕ СОЗДААААААААЛ", "НЕЕЕЕЕЕЕ СОЗДААААААААЛ");
            }
        });
    }
}