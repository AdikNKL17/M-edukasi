package com.majesthink.adik.kemendikbud.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.majesthink.adik.kemendikbud.activity.DetailActivity;
import com.majesthink.adik.kemendikbud.R;
import com.majesthink.adik.kemendikbud.model.Newest;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewestAdapter extends RecyclerView.Adapter<NewestAdapter.NewestHolder> {

    Context context;
    List<Newest> newestList;

    @NonNull
    @Override
    public NewestHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.newest_item, viewGroup, false);
        return new NewestHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewestHolder newestHolder, int i) {
        final Newest newest = newestList.get(i);

        Picasso.get()
                .load(newestList.get(i).getApp_icon())
                .fit()
                .centerCrop()
                .into(newestHolder.appIcon);

        newestHolder.appName.setText(newest.getApp_name());

        newestHolder.newestHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("APP_NAME", newest.getApp_name());
                intent.putExtra("APP_ICON", newest.getApp_icon());
                intent.putExtra("APP_DEVELOPER", newest.getApp_developer());
                intent.putExtra("APP_SIZE", Integer.toString(newest.getSize()));
                intent.putExtra("APP_RATE", Double.toString(newest.getRate()));
                v.getContext().startActivity(intent);
                Animatoo.animateSlideLeft(v.getContext());

            }
        });

    }

    @Override
    public int getItemCount() {
        return newestList.size();
    }

    public class NewestHolder extends RecyclerView.ViewHolder {

        CardView newestHolder;
        RoundedImageView appIcon;
        TextView appName;

        public NewestHolder(@NonNull View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.app_icon);
            appName = itemView.findViewById(R.id.title_app);
            newestHolder = itemView.findViewById(R.id.newest_holder);
        }
    }

    public NewestAdapter(Context context, List<Newest> newestList){
        this.context = context;
        this.newestList = newestList;
    }
}
