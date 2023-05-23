package com.example.verb2.Login_pac;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.verb2.DB.DataUser;
import com.example.verb2.R;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Thread thread = new Thread(new DataUser());
        thread.start();

        Button login = findViewById(R.id.button4);
        Button sing_up_bt = findViewById(R.id.button5);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login_system login_system = new Login_system();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainerView, login_system);
                ft.commit();
            }
        });

        sing_up_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sing_up sing_up = new Sing_up();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainerView, sing_up);
                ft.commit();
            }
        });
    }
}