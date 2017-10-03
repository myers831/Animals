package com.example.admin.animals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class KanineActivity extends AppCompatActivity {

    KanineDatabaseHelper kanineDatabaseHelper = new KanineDatabaseHelper(this);
    private ListView lvKanines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanine);

        lvKanines = (ListView) findViewById(R.id.lvFelines);

        List<Animal> kanineAnimalList = kanineDatabaseHelper.getAnimalList();

        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.custom_list_item, kanineAnimalList);
        lvKanines.setAdapter(animalListAdapter);
    }
}
