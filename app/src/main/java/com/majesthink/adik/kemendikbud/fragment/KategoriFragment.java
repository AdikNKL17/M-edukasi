package com.majesthink.adik.kemendikbud.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majesthink.adik.kemendikbud.R;
import com.majesthink.adik.kemendikbud.VerticalItemDecoration;
import com.majesthink.adik.kemendikbud.adapter.CategoriesAdapter;
import com.majesthink.adik.kemendikbud.model.Categories;

import java.util.ArrayList;
import java.util.List;

public class KategoriFragment extends android.support.v4.app.Fragment {

    List<Categories> categoriesList;
    CategoriesAdapter categoriesAdapter;

    RecyclerView recycler_categories;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kategori, container, false);

        categoriesList = new ArrayList<>();
        categoriesAdapter = new CategoriesAdapter(container.getContext(), categoriesList);
        recycler_categories = view.findViewById(R.id.list_categories);
        recycler_categories.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));
        recycler_categories.setItemAnimator(new DefaultItemAnimator());
        int margin = getResources().getDimensionPixelSize(R.dimen.slider_margin);
        recycler_categories.addItemDecoration(new VerticalItemDecoration(margin));
        recycler_categories.setAdapter(categoriesAdapter);

        dataCategories();

        return view;
    }

    private void dataCategories() {
        Categories categories = new Categories(1, "Kategori 1", "https://img.icons8.com/color/1600/cycling-road.png", 20);
        categoriesList.add(categories);
        categories = new Categories(2, "Kategori 2", "https://img.icons8.com/color/1600/student-male.png", 20);
        categoriesList.add(categories);
        categories = new Categories(3, "Kategori 3", "https://img.icons8.com/color/1600/football.png", 20);
        categoriesList.add(categories);
        categories = new Categories(4, "Kategori 4", "https://img.icons8.com/color/1600/puzzle.png", 20);
        categoriesList.add(categories);
        categories = new Categories(5, "Kategori 5", "https://img.icons8.com/color/1600/rock-music.png", 20);
        categoriesList.add(categories);
        categories = new Categories(1, "Kategori 6", "https://img.icons8.com/color/1600/reading.png", 20);
        categoriesList.add(categories);
        categories = new Categories(2, "Kategori 7", "https://img.icons8.com/color/1600/rubiks-cube.png", 20);
        categoriesList.add(categories);
        categories = new Categories(3, "Kategori 8", "https://img.icons8.com/color/1600/code.png", 20);
        categoriesList.add(categories);
        categories = new Categories(4, "Kategori 9", "https://img.icons8.com/color/1600/drafting-compass2.png", 20);
        categoriesList.add(categories);
        categories = new Categories(5, "Kategori 10", "https://img.icons8.com/color/1600/paint-palette.png", 20);
        categoriesList.add(categories);
        categories = new Categories(1, "Kategori 11", "https://img.icons8.com/color/1600/mars-planet.png", 20);
        categoriesList.add(categories);
        categories = new Categories(2, "Kategori 12", "https://img.icons8.com/color/1600/numerology-square.png", 20);
        categoriesList.add(categories);
        categories = new Categories(3, "Kategori 13", "https://img.icons8.com/color/1600/test-tube.png", 20);
        categoriesList.add(categories);
        categories = new Categories(4, "Kategori 14", "https://img.icons8.com/color/1600/calculator.png", 20);
        categoriesList.add(categories);
        categories = new Categories(5, "Kategori 15", "https://img.icons8.com/color/1600/sunbathe.png", 20);
        categoriesList.add(categories);
    }

}
