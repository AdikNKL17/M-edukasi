package com.majesthink.adik.kemendikbud.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.majesthink.adik.kemendikbud.R;
import com.majesthink.adik.kemendikbud.fragment.JelajahFragment;
import com.majesthink.adik.kemendikbud.fragment.JenjangFragment;
import com.majesthink.adik.kemendikbud.fragment.KategoriFragment;
import com.majesthink.adik.kemendikbud.fragment.PelajaranFragmnet;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    AppBarLayout appBarLayout;
    Toolbar toolbar;
    BottomNavigationView navigationView;

    MaterialSearchView searchView;

    /*RoundedImageView profile;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appBarLayout = findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                ViewCompat.setElevation(appBarLayout, 20);
            }
        });

        toolbar = findViewById(R.id.toolbar);

        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);

        searchView = findViewById(R.id.search_view);

        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.jelajah);

        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_wrapper, new JelajahFragment()).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.jelajah:
                    selectedFragment = new JelajahFragment();
                    break;
                case R.id.kategori:
                    selectedFragment = new KategoriFragment();
                    break;
                case R.id.pelajaran:
                    selectedFragment = new PelajaranFragmnet();
                    break;
                case R.id.jenjang:
                    selectedFragment = new JenjangFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_wrapper, selectedFragment).commit();

            return true;
        }
    };

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()){
            case R.id.search:
                searchView.showSearch();
        }

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed(){
        if (searchView.isSearchOpen()){
            searchView.closeSearch();
        }else {
            super.onBackPressed();
        }
    }
}