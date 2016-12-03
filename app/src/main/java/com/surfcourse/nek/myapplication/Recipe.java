package com.surfcourse.nek.myapplication;

import android.graphics.drawable.Drawable;

/**
 * Created by nek on 25.11.16.
 */

public class Recipe {
    private String title;
    private Drawable img;
    private String recipe;

    public String getTitle() {
        return title;
    }

    public Drawable getImg() {
        return img;
    }

    public String getRecipe() {
        return recipe;
    }

    public Recipe(String title, Drawable img, String recipe) {

        this.title = title;
        this.img = img;
        this.recipe = recipe;
    }
}
