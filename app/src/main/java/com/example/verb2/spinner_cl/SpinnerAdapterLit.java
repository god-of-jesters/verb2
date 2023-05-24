package com.example.verb2.spinner_cl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.verb2.R;

import java.util.List;

public class SpinnerAdapterLit extends ArrayAdapter<Item> {

    LayoutInflater layoutInflater;
    public SpinnerAdapterLit(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, @NonNull View view, @NonNull ViewGroup viewGroup){
        View rawView = layoutInflater.inflate(R.layout.item_site, null, true);
        Item item = getItem(position);
        TextView textView = rawView.findViewById(R.id.textView4);
        textView.setText(item.getName());
        return rawView;
    }

    @Override
    public View getDropDownView(int position, @NonNull View view, @NonNull ViewGroup viewGroup){
        if (view == null){
            view = layoutInflater.inflate(R.layout.item_site, viewGroup, false);
        }

        Item item = getItem(position);
        TextView textView = view.findViewById(R.id.textView4);
        textView.setText(item.getName());
        return view;
    }
}
