package com.example.admin.animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FelineActivity extends AppCompatActivity {

    FelineDatabaseHelper felineDatabaseHelper = new FelineDatabaseHelper(this);
    private ListView lvFelines;
    private List<Animal> felineAnimalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feline);

        lvFelines = (ListView) findViewById(R.id.lvFelines);

        felineAnimalList = felineDatabaseHelper.getAnimalList();

        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.custom_list_item, felineAnimalList);
        lvFelines.setAdapter(animalListAdapter);

        lvFelines.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Animal animal = felineDatabaseHelper.getAnimal(position + 1);
                Intent intent = new Intent(FelineActivity.this, SingleAnimalActivity.class);
                intent.putExtra("animal", animal);
                startActivity(intent);
            }
        });
    }
}
