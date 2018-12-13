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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.majesthink.adik.kemendikbud.R;
import com.majesthink.adik.kemendikbud.activity.CategoryDetail;
import com.majesthink.adik.kemendikbud.model.Categories;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder> {

    Context context;
    List<Categories> categoriesList;


    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.categories_item, viewGroup, false);
        return new CategoriesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder categoriesHolder, int i) {

        final Categories categories = categoriesList.get(i);

        Picasso.get()
                .load(categoriesList.get(i).getCATEGORIES_ICON())
                .fit()
                .centerCrop()
                .into(categoriesHolder.categories_icon);

        categoriesHolder.categories_name.setText(categories.getName());
        categoriesHolder.categories_total.setText(Integer.toString(categories.getTotal()));

        categoriesHolder.holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CategoryDetail.class);
                intent.putExtra("CATEGORIES_NAME", categories.getName());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CategoriesHolder extends RecyclerView.ViewHolder {
        ConstraintLayout holder;
        ImageView categories_icon;
        TextView categories_name, categories_total;
        public CategoriesHolder(@NonNull View itemView) {
            super(itemView);

            holder = itemView.findViewById(R.id.categories_holder);
            categories_icon = itemView.findViewById(R.id.categories_icon);
            categories_name = itemView.findViewById(R.id.categories_name);
            categories_total = itemView.findViewById(R.id.categories_item_total);

        }
    }

    public CategoriesAdapter(Context context, List<Categories> categoriesList){
        this.context = context;
        this.categoriesList = categoriesList;
    }
}
