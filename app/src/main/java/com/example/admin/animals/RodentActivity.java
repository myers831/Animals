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

public class RodentActivity extends AppCompatActivity {

    RodentDatabaseHelper rodentDatabaseHelper = new RodentDatabaseHelper(this);
    private ListView lvRodent;
    private List<Animal> rodentAnimalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodent);

        lvRodent = (ListView) findViewById(R.id.lvRodents);

        rodentAnimalList = rodentDatabaseHelper.getAnimalList();

        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.custom_list_item, rodentAnimalList);
        lvRodent.setAdapter(animalListAdapter);

        lvRodent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Animal animal = rodentDatabaseHelper.getAnimal(position + 1);
                Intent intent = new Intent(RodentActivity.this, SingleAnimalActivity.class);
                intent.putExtra("animal", animal);
                startActivity(intent);
            }
        });
    }
}
