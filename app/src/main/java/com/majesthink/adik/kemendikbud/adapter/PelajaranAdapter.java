package com.majesthink.adik.kemendikbud.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.majesthink.adik.kemendikbud.R;
import com.majesthink.adik.kemendikbud.activity.CategoryDetail;
import com.majesthink.adik.kemendikbud.model.Pelajaran;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PelajaranAdapter extends RecyclerView.Adapter<PelajaranAdapter.PelajaranHolder> {

    Context context;
    List<Pelajaran> pelajaranList;

    @NonNull
    @Override
    public PelajaranHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pelajaran_item, viewGroup, false);
        return new PelajaranHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PelajaranHolder pelajaranHolder, int i) {

        final Pelajaran pelajaran = pelajaranList.get(i);

        Picasso.get()
                .load(pelajaran.getCATEGORIES_ICON())
                .fit()
                .centerCrop()
                .into(pelajaranHolder.pelajaran_icon);

        pelajaranHolder.pelajaran_name.setText(pelajaran.getName());
        pelajaranHolder.pelajaran_total.setText(Integer.toString(pelajaran.getTotal()));

        pelajaranHolder.pelajaran_holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CategoryDetail.class);
                intent.putExtra("TOOLBAR_NAME", pelajaran.getName());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pelajaranList.size();
    }

    public class PelajaranHolder extends RecyclerView.ViewHolder {

        ConstraintLayout pelajaran_holder;
        ImageView pelajaran_icon;
        TextView pelajaran_name, pelajaran_total;

        public PelajaranHolder(@NonNull View itemView) {
            super(itemView);

            pelajaran_holder = itemView.findViewById(R.id.pelajaran_holder);
            pelajaran_icon = itemView.findViewById(R.id.pelajaran_icon);
            pelajaran_name = itemView.findViewById(R.id.pelajaran_name);
            pelajaran_total = itemView.findViewById(R.id.pelajaran_item_total);
        }
    }

    public PelajaranAdapter(Context context, List<Pelajaran> pelajaranList){
        this.context = context;
        this.pelajaranList = pelajaranList;
    }
}
