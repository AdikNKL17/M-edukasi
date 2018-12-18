package com.majesthink.adik.kemendikbud.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.majesthink.adik.kemendikbud.HorizontalItemDecoration;
import com.majesthink.adik.kemendikbud.R;
import com.majesthink.adik.kemendikbud.SliderItemDecoration;
import com.majesthink.adik.kemendikbud.activity.CategoryDetail;
import com.majesthink.adik.kemendikbud.adapter.NewestAdapter;
import com.majesthink.adik.kemendikbud.adapter.RecommendedAdapter;
import com.majesthink.adik.kemendikbud.adapter.SliderAdapter;
import com.majesthink.adik.kemendikbud.model.Applications;
import com.majesthink.adik.kemendikbud.model.Newest;
import com.majesthink.adik.kemendikbud.model.Slider;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

import java.util.ArrayList;
import java.util.List;

public  class JelajahFragment extends android.support.v4.app.Fragment {

    List<Slider> sliderList;
    SliderAdapter sliderAdapter;
    List<Newest> newestList;
    NewestAdapter newestAdapter;
    List<Applications> applicationsList;
    RecommendedAdapter recommendedAdapter;
    RecyclerView sliderRecycler, newestRecyler, recommendedRecycler;

    TextView newest_title, newest_more, recommended_title, recommended_more;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jelajah, container, false);

        int margin = getResources().getDimensionPixelSize(R.dimen.slider_margin);

        newest_title = view.findViewById(R.id.title_newest);
        newest_more = view.findViewById(R.id.more_newest);
        recommended_title = view.findViewById(R.id.title_recommended);
        recommended_more = view.findViewById(R.id.more_recommended);

        sliderRecycler = view.findViewById(R.id.banner_slider);
        sliderList = new ArrayList<>();
        sliderAdapter = new SliderAdapter(container.getContext(), sliderList);
        sliderRecycler.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        sliderRecycler.setItemAnimator(new DefaultItemAnimator());
        sliderRecycler.addItemDecoration(new SliderItemDecoration(margin));
        sliderRecycler.setAdapter(sliderAdapter);
        new LinearSnapHelper().attachToRecyclerView(sliderRecycler);


        newestRecyler = view.findViewById(R.id.list_newest);
        newestList = new ArrayList<>();
        newestAdapter = new NewestAdapter(container.getContext(), newestList);
        newestRecyler.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        newestRecyler.setItemAnimator(new DefaultItemAnimator());
        newestRecyler.addItemDecoration(new HorizontalItemDecoration(margin));
        newestRecyler.setAdapter(newestAdapter);
        new LinearSnapHelper().attachToRecyclerView(newestRecyler);

        newest_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CategoryDetail.class);
                intent.putExtra("TOOLBAR_NAME", newest_title.getText());
                v.getContext().startActivity(intent);
            }
        });


        recommendedRecycler = view.findViewById(R.id.list_recommended);
        applicationsList = new ArrayList<>();
        recommendedAdapter = new RecommendedAdapter(container.getContext(), applicationsList);
        recommendedRecycler.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        recommendedRecycler.setItemAnimator(new DefaultItemAnimator());
        recommendedRecycler.setAdapter(recommendedAdapter);
        recommended_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CategoryDetail.class);
                intent.putExtra("TOOLBAR_NAME", recommended_title.getText());
                v.getContext().startActivity(intent);
            }
        });

        dataSlider();
        dataNewest();
        dataRecommended();

        return view;
    }

    private void dataSlider() {

        Slider slider = new Slider("Slider 1", "https://scontent-sea1-1.cdninstagram.com/vp/f8a344aa3bbb19d73929ef89a6f49dbf/5C58D5B6/t51.2885-15/e35/42003235_1213357218831829_4757450124296697989_n.jpg?se=7&ig_cache_key=MTg4Mzg4ODQyNzc5Mzg4MDQ1OA%3D%3D.2");
        sliderList.add(slider);

        slider = new Slider("Slider 2", "https://scontent-sea1-1.cdninstagram.com/vp/e522e792e0ec5f0369b2790c2b665a86/5C5DF5A1/t51.2885-15/fr/e15/p1080x1080/42523361_593987991019231_8499767258107468649_n.jpg?ig_cache_key=MTg3OTQwMDM3NDAwOTY1MzM5MA%3D%3D.2");
        sliderList.add(slider);

        slider = new Slider("Slider 3", "https://pbs.twimg.com/media/DtSVdXrXgAEbShS.jpg");
        sliderList.add(slider);
    }

    private void dataNewest() {

        Newest newest = new Newest(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2009/FIS012009.jpg","Aku Tahu, Alat Transportasi! ","Stripe Inc", 4.5, 10);
        newestList.add(newest);
        newest = new Newest(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2010/FIS032010.jpg","Kombinasi","Stripe Inc", 4.5, 10);
        newestList.add(newest);
        newest = new Newest(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2012/ME12PAUD02.jpg","Siklus Krebs","Stripe Inc", 4.5, 10);
        newestList.add(newest);
        newest = new Newest(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2013/ME13ABAHMA01.jpg","Cita - Citaku","Stripe Inc", 4.5, 10);
        newestList.add(newest);
        newest = new Newest(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2013/ME13AIPABI01.jpg","Words","Stripe Inc", 4.5, 10);
        newestList.add(newest);
        newest = new Newest(0, "https://m-edukasi.kemdikbud.go.id/medukasi/res/icon-produk/me/me2012/ME12PAUD10.jpg","Apple","Stripe Inc", 4.5, 10);
        newestList.add(newest);

    }

    private void dataRecommended() {

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
    }
}
