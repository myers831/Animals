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

public class KanineActivity extends AppCompatActivity {

    KanineDatabaseHelper kanineDatabaseHelper = new KanineDatabaseHelper(this);
    private ListView lvKanines;
    private List<Animal> kanineAnimalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanine);

        lvKanines = (ListView) findViewById(R.id.lvKanines);

        kanineAnimalList = kanineDatabaseHelper.getAnimalList();

        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.custom_list_item, kanineAnimalList);
        lvKanines.setAdapter(animalListAdapter);

        lvKanines.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Animal animal = kanineDatabaseHelper.getAnimal(position + 1);
                Intent intent = new Intent(KanineActivity.this, SingleAnimalActivity.class);
                intent.putExtra("animal", animal);
                startActivity(intent);
            }
        });
    }
}
