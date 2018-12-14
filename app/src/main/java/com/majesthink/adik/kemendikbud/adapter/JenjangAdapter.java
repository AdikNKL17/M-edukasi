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
import com.majesthink.adik.kemendikbud.model.Jenjang;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class JenjangAdapter extends RecyclerView.Adapter<JenjangAdapter.JenjangHolder> {

    Context context;
    List<Jenjang> jenjangList;

    @NonNull
    @Override
    public JenjangHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.jenjang_item, viewGroup, false);
        return new JenjangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JenjangHolder jenjangHolder, int i) {
        final Jenjang jenjang = jenjangList.get(i);

        Picasso.get()
                .load(jenjang.getJELAJAH_ICON())
                .fit()
                .centerCrop()
                .into(jenjangHolder.jenjang_icon);

        jenjangHolder.jenjang_name.setText(jenjang.getName());
        jenjangHolder.jenjang_total.setText(Integer.toString(jenjang.getTotal()));

        jenjangHolder.holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CategoryDetail.class);
                intent.putExtra("TOOLBAR_NAME", jenjang.getName());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jenjangList.size();
    }

    public class JenjangHolder extends RecyclerView.ViewHolder {
        ConstraintLayout holder;
        ImageView jenjang_icon;
        TextView jenjang_name, jenjang_total;
        public JenjangHolder(@NonNull View itemView) {
            super(itemView);

            holder = itemView.findViewById(R.id.jenjang_holder);
            jenjang_icon = itemView.findViewById(R.id.jenjang_icon);
            jenjang_name = itemView.findViewById(R.id.jenjang_name);
            jenjang_total = itemView.findViewById(R.id.jenjang_item_total);
        }
    }

    public JenjangAdapter(Context context, List<Jenjang> jenjangList){
        this.context = context;
        this.jenjangList = jenjangList;
    }
}
