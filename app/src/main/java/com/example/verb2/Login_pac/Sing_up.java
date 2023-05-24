package com.example.verb2.Login_pac;

import static java.util.Collections.max;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.verb2.DB.DataUser;
import com.example.verb2.DB.User;
import com.example.verb2.MainActivity;
import com.example.verb2.R;
import com.example.verb2.databinding.FragmentSingUpBinding;

import java.util.ArrayList;

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
        EditText pas1 = view.findViewById(R.id.editTextText3);
        TextView name_cr = view.findViewById(R.id.textView6);
        TextView pass_cr = view.findViewById(R.id.textView7);

        name_cr.setVisibility(View.INVISIBLE);
        pass_cr.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bring_name = name.getText().toString();
                String bring_pass = pas.getText().toString();
                String bring_pass1 = pas1.getText().toString();
                if(!DataUser.names.keySet().contains(bring_name) && bring_pass.equals(bring_pass1)){
                    DataUser.regestrated(bring_name, bring_pass);
                    System.out.println("IDDDDDDDDDDDD" + DataUser.getUser(bring_name).getId());
                    Login_system.setUser(new User((int) DataUser.getMax(), bring_name, bring_pass, 0));
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    if (DataUser.names.keySet().contains(bring_name)){
                        name_cr.setText("Такой пользователь уже есть");
                        name_cr.setVisibility(View.VISIBLE);
                    }else{
                        pass_cr.setText("Пароль не совпадает");
                        pass_cr.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}