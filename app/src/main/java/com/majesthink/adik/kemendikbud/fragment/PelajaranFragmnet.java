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
import com.majesthink.adik.kemendikbud.adapter.PelajaranAdapter;
import com.majesthink.adik.kemendikbud.model.Pelajaran;

import java.util.ArrayList;
import java.util.List;

public class PelajaranFragmnet extends android.support.v4.app.Fragment {

    List<Pelajaran> pelajaranList;
    PelajaranAdapter pelajaranAdapter;
    RecyclerView recycler_pelajaran;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pelajaran, container, false);

        pelajaranList = new ArrayList<>();
        pelajaranAdapter = new PelajaranAdapter(container.getContext(), pelajaranList);
        recycler_pelajaran = view.findViewById(R.id.list_pelajaran);
        recycler_pelajaran.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));
        recycler_pelajaran.setItemAnimator(new DefaultItemAnimator());
        int margin = getResources().getDimensionPixelSize(R.dimen.slider_margin);
        recycler_pelajaran.addItemDecoration(new VerticalItemDecoration(margin));
        recycler_pelajaran.setAdapter(pelajaranAdapter);

        dataPelajaran();

        return view;
    }

    private void dataPelajaran() {
        Pelajaran pelajaran = new Pelajaran(1, "Pelajaran 1", "https://img.icons8.com/color/1600/math.png", 21);
        pelajaranList.add(pelajaran);
        pelajaran = new Pelajaran(1, "Pelajaran 2", "https://img.icons8.com/color/1600/test-tube.png", 21);
        pelajaranList.add(pelajaran);
        pelajaran = new Pelajaran(1, "Pelajaran 3", "https://img.icons8.com/color/1600/physics.png", 21);
        pelajaranList.add(pelajaran);
        pelajaran = new Pelajaran(1, "Pelajaran 4", "https://img.icons8.com/color/1600/sprout.png", 21);
        pelajaranList.add(pelajaran);
        pelajaran = new Pelajaran(1, "Pelajaran 5", "https://img.icons8.com/color/1600/computer.png", 21);
        pelajaranList.add(pelajaran);
        pelajaran = new Pelajaran(1, "Pelajaran 6", "https://img.icons8.com/color/1600/running.png", 21);
        pelajaranList.add(pelajaran);
        pelajaran = new Pelajaran(1, "Pelajaran 7", "https://img.icons8.com/color/1600/language.png", 21);
        pelajaranList.add(pelajaran);
        pelajaran = new Pelajaran(1, "Pelajaran 8", "https://img.icons8.com/color/1600/math.png", 21);
        pelajaranList.add(pelajaran);
        pelajaran = new Pelajaran(1, "Pelajaran 9", "https://img.icons8.com/color/1600/math.png", 21);
        pelajaranList.add(pelajaran);
    }

}
