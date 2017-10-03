package com.example.admin.animals;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 10/3/2017.
 */

public class AnimalTypeListAdapter extends ArrayAdapter<String> {
    public AnimalTypeListAdapter(@NonNull Context context, @LayoutRes int resource, String[] animalTypeList) {
        super(context, resource, animalTypeList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null);
        }

        TextView tvName = (TextView) view.findViewById(R.id.tvAnimalType);

        String animalType = getItem(position);
        tvName.setText(animalType);

        return view;
    }
}
