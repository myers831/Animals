package com.example.admin.animals;

import android.graphics.Bitmap;

import java.sql.Blob;

/**
 * Created by Admin on 10/3/2017.
 */

public class Animal {
    String Name, Height, Weight;
    //Blob Image;

    public Animal(String name, String height, String weight /*, Blob image*/) {
        Name = name;
        Height = height;
        Weight = weight;
       // Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

   /* public Blob getImage() {
        return Image;
    }

    public void setImage(Blob image) {
        Image = image;
    }
*/
    @Override
    public String
    toString() {
        return "Animal{" +
                "Name='" + Name + '\'' +
                ", Height='" + Height + '\'' +
                ", Weight='" + Weight + '\'' +
                //", Image='" + Image + '\'' +
                '}';
    }
}
