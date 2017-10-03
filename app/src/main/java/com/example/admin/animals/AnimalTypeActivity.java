package com.example.admin.animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AnimalTypeActivity extends AppCompatActivity {


    private ListView lvAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_type);

        lvAnimals = (ListView) findViewById(R.id.lvAnimals);

        String[] animalTypeList = {"Kanine", "Feline", "Rodents"};

        AnimalTypeListAdapter animalTypeListAdapter = new AnimalTypeListAdapter(this, R.layout.custom_list_item, animalTypeList);
        lvAnimals.setAdapter(animalTypeListAdapter);

        lvAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent kanineIntent = new Intent(AnimalTypeActivity.this, KanineActivity.class);
                        startActivity(kanineIntent);
                        Toast.makeText(AnimalTypeActivity.this, "Position 0 pressed", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Intent felineIntent = new Intent(AnimalTypeActivity.this, FelineActivity.class);
                        startActivity(felineIntent);
                        Toast.makeText(AnimalTypeActivity.this, "Position 0 pressed", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Intent rodentIntent = new Intent(AnimalTypeActivity.this, RodentActivity.class);
                        startActivity(rodentIntent);
                        Toast.makeText(AnimalTypeActivity.this, "Position 0 pressed", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }
}
