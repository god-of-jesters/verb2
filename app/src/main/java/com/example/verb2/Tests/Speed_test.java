package com.example.verb2.Tests;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.verb2.Login_pac.Login_system;
import com.example.verb2.MainActivity;
import com.example.verb2.R;
import com.example.verb2.Solution;
import com.example.verb2.databinding.FragmentSpeedTestBinding;

public class Speed_test extends Fragment {
    TextView task; TextView timer; TextView correct;
    Button answer_but; EditText answer;
    private CountDownTimer countDownTimer;
    int[] params;
    Solution solution;
    String hard; String style; String act;
    int correct_an = 0;
    FragmentSpeedTestBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_speed_test, container, false);
        binding = FragmentSpeedTestBinding.inflate(inflater, container, false);
        solution = new Solution();
        answer_but = view.findViewById(R.id.button6);
        answer = view.findViewById(R.id.editTextText4);
        task = view.findViewById(R.id.task);
        timer = view.findViewById(R.id.time);
        correct = view.findViewById(R.id.correct);

        hard = Action.getHard();
        style = Action.getStyle();
        act = Action.getAct();

        params = solution.getTask(style, Integer.parseInt(hard));
        String operation = solution.getO();
        setTextTo(task, operation, params);
        correct.setText("Правильно: " + Integer.toString(correct_an));

        if (act.equals("Скорость")){
            countDownTimer = new CountDownTimer(30000, 100) {
                @Override
                public void onTick(long millisUntilFinished) {
                    answer_but.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int an = 0;
                            if(!answer.getText().toString().trim().equals("")){
                                an = Integer.parseInt(answer.getText().toString().trim());
                            }else {
                                an = -1;
                            }

                            if(an == params[2]){
                                correct_an += 1;
                                correct.setText("Правильно: " + Integer.toString(correct_an));
                            }
                            params = solution.getTask(style, Integer.parseInt(hard));
                            setTextTo(task, operation, params);
                            answer.setText("");
                        }
                    });
                    timer.setText("Осталось времени: " + (String) Integer.toString((int) (millisUntilFinished / 1000)) + "." + (String) Integer.toString((int) (millisUntilFinished % 1000 / 100)));
                }

                @Override
                public void onFinish() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Вы набрали " + (Integer.parseInt(hard) * correct_an) + " очков")
                            .setCancelable(false)
                            .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    Intent intent = new Intent(getContext(), MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                    Login_system.getUser().setScore(Login_system.getUser().getScore() + Integer.parseInt(hard) * correct_an);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }.start();
        }
        return view;
    }

    private void setTextTo(TextView t, String operation, int[] params){
        System.out.println(params[0]);
        if(operation.equals("<span>&#8730;3<span>")){
            t.setText("Пример: " + Html.fromHtml("<span>&#8730<span>" + Integer.toString(params[0])));
        }else {
            if(params[0] > params[1]){
                t.setText(Integer.toString(params[0]) + operation + Integer.toString(params[1]));
            }else{
                t.setText(Integer.toString(params[1]) + operation + Integer.toString(params[0]));
            }
        }
    }
}