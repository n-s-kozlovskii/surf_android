package com.surfcourse.nek.myapplication;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nek on 25.11.16.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeLayoutHolder> {
    private List<Recipe> recipes;

    public RecipeAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public RecipeLayoutHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_layout,parent,false);
        return new RecipeLayoutHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeLayoutHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.button.setText(recipe.getTitle());
        holder.button.setBackground(recipe.getImg());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeLayoutHolder extends RecyclerView.ViewHolder {
        public Button button;

        public RecipeLayoutHolder(View view) {
            super(view);
            button = (Button) view.findViewById(R.id.recipe_btn);
        }
    }


}
