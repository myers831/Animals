package com.example.admin.animals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/3/2017.
 */

public class RodentDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "Rodents.db";

    public static final String TABLE_NAME = "Rodent";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_HEIGHT = "Height";
    public static final String COLUMN_WEIGHT = "Weight";
    public static final String ID = "id";


    public RodentDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT, " + COLUMN_HEIGHT + " TEXT, " + COLUMN_WEIGHT + " TEXT " + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void saveAnimal(Animal animal){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, animal.Name);
        contentValues.put(COLUMN_HEIGHT, animal.Height);
        contentValues.put(COLUMN_WEIGHT, animal.Weight);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public Animal getAnimal(int id){

        Animal animal = null;

        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * from " + TABLE_NAME + " WHERE id=" + id;

        Cursor cursor = database.rawQuery(QUERY, null);

        if(cursor.moveToFirst()) {
            do {
                animal = new Animal(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            }while (cursor.moveToNext());
        }
        return animal;
    }

    public List<Animal> getAnimalList(){
        List<Animal> animalList = new ArrayList<>();

        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(QUERY, null);

        if(cursor.moveToFirst()){
            do{
                Animal animal = new Animal(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                animalList.add(animal);
            }while (cursor.moveToNext());
        }

        return animalList;
    }
}

