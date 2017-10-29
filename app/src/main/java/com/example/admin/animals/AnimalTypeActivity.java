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

    KanineDatabaseHelper kanineDatabaseHelper = new KanineDatabaseHelper(this);
    FelineDatabaseHelper felineDatabaseHelper = new FelineDatabaseHelper(this);
    RodentDatabaseHelper rodentDatabaseHelper = new RodentDatabaseHelper(this);
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
                        break;
                    case 1:
                        Intent felineIntent = new Intent(AnimalTypeActivity.this, FelineActivity.class);
                        startActivity(felineIntent);
                        break;
                    case 2:
                        Intent rodentIntent = new Intent(AnimalTypeActivity.this, RodentActivity.class);
                        startActivity(rodentIntent);
                        break;

                }
            }
        });
    }

    public void updateData(View view) {

        kanineDatabaseHelper.saveAnimal(new Animal("Rottweiler", "27in", "130lb"));
        kanineDatabaseHelper.saveAnimal(new Animal("Great Dane", "34in", "200lb"));
        kanineDatabaseHelper.saveAnimal(new Animal("Bulldog", "16in", "55lb"));

        felineDatabaseHelper.saveAnimal(new Animal("Lion", "3.9ft", "420lb"));
        felineDatabaseHelper.saveAnimal(new Animal("Tiger", "4ft", "670lb"));
        felineDatabaseHelper.saveAnimal(new Animal("Cheetah", "3.1ft", "160lb"));

        rodentDatabaseHelper.saveAnimal(new Animal("Kangaroo", "8ft", "200lb"));
        rodentDatabaseHelper.saveAnimal(new Animal("Large Rabbit", "20in", "10lb"));
        rodentDatabaseHelper.saveAnimal(new Animal("Brown Rat", "10in", "350g"));

    }
}
