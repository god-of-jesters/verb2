package com.example.verb2.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verb2.R;

import java.util.List;

public class AdapterLeader extends RecyclerView.Adapter<MyViewHolderLeader> {
    Context context;
    List<ItemLeader> items;

    public AdapterLeader(Context context, List<ItemLeader> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolderLeader onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderLeader(LayoutInflater.from(context).inflate(R.layout.list_view_leaders,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderLeader holder, int position) {
        holder.name.setText(items.get(position).getName());
        holder.score.setText(items.get(position).getScore());
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.place.setText((items.get(position).getPlace()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
