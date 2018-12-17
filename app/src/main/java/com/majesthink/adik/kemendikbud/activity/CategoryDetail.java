package com.majesthink.adik.kemendikbud.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.majesthink.adik.kemendikbud.R;
import com.majesthink.adik.kemendikbud.adapter.ApplicationsAdapter;
import com.majesthink.adik.kemendikbud.model.Applications;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetail extends AppCompatActivity {

    Toolbar toolbar;

    List<Applications> applicationsList;
    ApplicationsAdapter applicationsAdapter;

    RecyclerView recycler_applications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        String CATEGORIES_NAME = getIntent().getStringExtra("TOOLBAR_NAME");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(CATEGORIES_NAME);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        applicationsList = new ArrayList<>();
        applicationsAdapter = new ApplicationsAdapter(this, applicationsList);

        recycler_applications = findViewById(R.id.list);
        recycler_applications.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler_applications.setItemAnimator(new DefaultItemAnimator());
        recycler_applications.setAdapter(applicationsAdapter);

        dataApplications();

    }

    private void dataApplications() {
        Applications applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/sicerdik/logo%20sicerdik.png","Si Cerdik","BPMPK Inc", 4.5, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2012/ME12PAUD06.jpg","Benda - Benda Langit","BPMPK Inc", 4.1, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/lomba/lomba2014/ME14LOMP34.jpg","Himpunan","BPMPK Inc", 4.0, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/lomba/lomba2017/ME17LOMG14.jpg","Uniknya Sifat Bahan","BPMPK Inc", 4.7, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2013/ME13ABAHMA02.jpg","Permutasi","BPMPK Inc", 4.1, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2013/ME13AIPABI01.jpg","Siklus Krebs","BPMPK Inc", 4.0, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2013/ME13AIPAKI02.jpg","Minyak Bumi","BPMPK Inc", 4.7, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2013/ME13ABAHMA02.jpg","Permutasi","BPMPK Inc", 4.1, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2013/ME13AIPABI01.jpg","Siklus Krebs","BPMPK Inc", 4.0, 10);
        applicationsList.add(applications);
        applications = new Applications(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2013/ME13AIPAKI02.jpg","Minyak Bumi","BPMPK Inc", 4.7, 10);
        applicationsList.add(applications);
    }
}
