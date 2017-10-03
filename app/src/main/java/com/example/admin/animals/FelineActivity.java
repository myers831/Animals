package com.example.admin.animals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class FelineActivity extends AppCompatActivity {

    FelineDatabaseHelper felineDatabaseHelper = new FelineDatabaseHelper(this);
    private ListView lvFelines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feline);

        lvFelines = (ListView) findViewById(R.id.lvFelines);

        List<Animal> felineAnimalList = felineDatabaseHelper.getAnimalList();

        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.custom_list_item, felineAnimalList);
        lvFelines.setAdapter(animalListAdapter);
    }
}
