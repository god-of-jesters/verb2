package com.example.verb2.RecycleView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.verb2.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView name; TextView score;

    public MyViewHolder(@NonNull View item){
        super(item);
        imageView = item.findViewById(R.id.imageView2);
        name = item.findViewById(R.id.textView);
        score = item.findViewById(R.id.textView2);
    }
}
