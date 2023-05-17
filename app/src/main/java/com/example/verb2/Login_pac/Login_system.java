package com.example.verb2.Login_pac;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.verb.DB.Data;
import com.example.verb.databinding.FragmentLoginSystemBinding;


public class Login_system extends Fragment {
    private FragmentLoginSystemBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginSystemBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.fragment_login_system, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button l = (Button) view.findViewById(R.id.loginBut);
        EditText name = view.findViewById(R.id.editTextText);
        EditText pas = view.findViewById(R.id.editTextText2);

        l.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                System.out.println(Data.names.keySet());
                if(Data.names.keySet().contains(n) && Data.names.get(n).equals(pas.getText().toString())){
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    name.setText("Ошибка");
                    pas.setText("");
                }

            }
        });
    }
}