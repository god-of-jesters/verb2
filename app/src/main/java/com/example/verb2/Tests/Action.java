package com.example.verb2.Tests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.verb2.R;

public class Action extends AppCompatActivity {
    static private String style;
    static private String hard;
    static  private  String act;
    FragmentTransaction ft;

    public static String getStyle() {
        return style;
    }

    public static String getHard() {
        return hard;
    }
    public static String getAct() {
        return act;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        Bundle args1 = new Bundle();

        Bundle args = getIntent().getExtras();
        String action = args.get("Action").toString();
        style = args.get("Style").toString();
        hard = args.get("Hard").toString();

        ft = getSupportFragmentManager().beginTransaction();

        switch (action){
            case "Скорость":
                act = "Скорость";
                Speed_test speed_test = new Speed_test();
                speed_test.setArguments(args1);
                ft.replace(R.id.fragmentContainerView2, speed_test, null);
                break;
            case "Аккуратность":
                act = "Аккуратность";
                Acuratnost_test acuratnost_test = new Acuratnost_test();
                acuratnost_test.setArguments(args1);
                ft.replace(R.id.fragmentContainerView2, acuratnost_test, null);
                break;
            case "Правильность":
                act = "Правильность";
                Correct_test correct_test = new Correct_test();
                correct_test.setArguments(args1);
                ft.replace(R.id.fragmentContainerView2, correct_test, null);
                break;
        }
        ft.commit();
    }

}