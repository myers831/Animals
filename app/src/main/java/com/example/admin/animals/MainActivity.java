package com.example.admin.animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    KanineDatabaseHelper kanineDatabaseHelper = new KanineDatabaseHelper(this);
    FelineDatabaseHelper felineDatabaseHelper = new FelineDatabaseHelper(this);
    RodentDatabaseHelper rodentDatabaseHelper = new RodentDatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

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

    public void goToAnimals(View view) {
        Intent intent = new Intent(MainActivity.this, AnimalTypeActivity.class);
        startActivity(intent);
    }
}
