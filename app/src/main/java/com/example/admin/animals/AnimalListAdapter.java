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

public class AnimalListAdapter extends ArrayAdapter<Animal> {
    public AnimalListAdapter(@NonNull Context context, @LayoutRes int resource, List<Animal> animalList) {
        super(context, resource, animalList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null);
        }

        TextView tvAnimalName = (TextView) view.findViewById(R.id.tvAnimalName);
        TextView tvAnimalHeight = (TextView) view.findViewById(R.id.tvAnimalHeight);
        TextView tvAnimalWeight = (TextView) view.findViewById(R.id.tvAnimalWeight);

        Animal animal = getItem(position);
        tvAnimalName.setText(animal.getName());
        tvAnimalHeight.setText(animal.getHeight());
        tvAnimalWeight.setText(animal.getWeight());

        return view;
    }
}
