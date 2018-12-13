package com.majesthink.adik.kemendikbud.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.majesthink.adik.kemendikbud.R;

public class CategoryDetail extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        String CATEGORIES_NAME = getIntent().getStringExtra("CATEGORIES_NAME");

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle(CATEGORIES_NAME);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
