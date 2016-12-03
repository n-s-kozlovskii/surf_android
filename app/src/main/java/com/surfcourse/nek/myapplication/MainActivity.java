package com.surfcourse.nek.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String tag = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "onCreate");

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    public class MyPageAdapter extends FragmentPagerAdapter {

        public  MyPageAdapter(android.app.FragmentManager manager){
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return ExampleFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }


    }

    public static class ExampleFragment extends Fragment {

        public ExampleFragment(){
            super();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = null;
            int pos = savedInstanceState.getInt("text");
            switch (pos){
                case 0:
                    view = inflater.inflate(R.layout.my_fragment0, container, false);
                    break;
                case 1:
                    view = inflater.inflate(R.layout.my_fragment1, container, false);
                    break;
                case 3:
                    view = inflater.inflate(R.layout.my_fragment2, container, false);
                    break;
                default:
                    view = inflater.inflate(R.layout.my_fragment3, container, false);

            }
            return view;
        }

        public static ExampleFragment newInstance(int position) {
            Bundle args = new Bundle();
            args.putInt("text", position);
            ExampleFragment fragment = new ExampleFragment();
            fragment.setArguments(args);
            return fragment;
        }
    }

    private void recipe(){
        List<Recipe> recipes = new ArrayList<>();
        Drawable img = ContextCompat.getDrawable(this, R.drawable.cookies);
        recipes.add(new Recipe("Text0", img, ""));
        recipes.add(new Recipe("Text1", img, ""));
        recipes.add(new Recipe("Text2", img, ""));
        recipes.add(new Recipe("Text3", img, ""));
        recipes.add(new Recipe("Text4", img, ""));
        recipes.add(new Recipe("Text5", img, ""));
        recipes.add(new Recipe("Text6", img, ""));
        recipes.add(new Recipe("Text7", img, ""));
        recipes.add(new Recipe("Text8", img, ""));
        recipes.add(new Recipe("Text9", img, ""));
        recipes.add(new Recipe("Text10", img, ""));
        recipes.add(new Recipe("Text11", img, ""));
        recipes.add(new Recipe("Text12", img, ""));
        recipes.add(new Recipe("Text13", img, ""));
        recipes.add(new Recipe("Text14", img, ""));
        recipes.add(new Recipe("Text15", img, ""));

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        RecipeAdapter adapter = new RecipeAdapter(recipes);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", "sfd!");
    }

}
