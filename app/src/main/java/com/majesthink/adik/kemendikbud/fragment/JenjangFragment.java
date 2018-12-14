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
import com.majesthink.adik.kemendikbud.adapter.JenjangAdapter;
import com.majesthink.adik.kemendikbud.model.Jenjang;

import java.util.ArrayList;
import java.util.List;

public class JenjangFragment extends android.support.v4.app.Fragment {

    List<Jenjang> jenjangList;
    JenjangAdapter jenjangAdapter;

    RecyclerView recycler_jenjang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jenjang, container, false);

        jenjangList = new ArrayList<>();
        jenjangAdapter = new JenjangAdapter(container.getContext(), jenjangList);

        recycler_jenjang = view.findViewById(R.id.list_jenjang);
        recycler_jenjang.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));
        recycler_jenjang.setItemAnimator(new DefaultItemAnimator());
        int margin = getResources().getDimensionPixelSize(R.dimen.slider_margin);
        recycler_jenjang.addItemDecoration(new VerticalItemDecoration(margin));
        recycler_jenjang.setAdapter(jenjangAdapter);

        dataJenjang();


        return view;
    }

    private void dataJenjang() {

        Jenjang jenjang = new Jenjang(1, "Sekolah Dasar", "https://img.icons8.com/color/1600/123.png", 17);
        jenjangList.add(jenjang);
        jenjang = new Jenjang(1, "Sekolah Menengah Pertama", "https://img.icons8.com/color/1600/classroom.png", 20);
        jenjangList.add(jenjang);
        jenjang = new Jenjang(1, "Sekolah Menengah Atas", "https://img.icons8.com/color/1600/students.png", 34);
        jenjangList.add(jenjang);
        jenjang = new Jenjang(1, "Universitas", "https://img.icons8.com/color/1600/graduation-cap.png", 17);
        jenjangList.add(jenjang);

    }

}
