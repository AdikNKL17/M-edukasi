package com.majesthink.adik.kemendikbud.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.majesthink.adik.kemendikbud.R;
import com.majesthink.adik.kemendikbud.activity.DetailActivity;
import com.majesthink.adik.kemendikbud.model.Applications;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ApplicationsAdapter extends RecyclerView.Adapter<ApplicationsAdapter.RecommendedHolder> {

    Context context;
    List<Applications> applicationsList;

    @NonNull
    @Override
    public RecommendedHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.applications_item, viewGroup, false);
        return new RecommendedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedHolder recommendedHolder, int i) {
        final Applications applications = applicationsList.get(i);

        Picasso.get()
                .load(applicationsList.get(i).getApp_icon())
                .fit()
                .centerCrop()
                .into(recommendedHolder.appIcon);

        recommendedHolder.appName.setText(applications.getApp_name());
        recommendedHolder.appDeveloper.setText(applications.getApp_developer());
        recommendedHolder.appSize.setText(Integer.toString(applications.getSize()));
        recommendedHolder.appRate.setText(Double.toString(applications.getRate()));

        recommendedHolder.recommendedWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("APP_NAME", applications.getApp_name());
                intent.putExtra("APP_ICON", applications.getApp_icon());
                intent.putExtra("APP_DEVELOPER", applications.getApp_developer());
                intent.putExtra("APP_SIZE", Integer.toString(applications.getSize()));
                intent.putExtra("APP_RATE", Double.toString(applications.getRate()));
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return applicationsList.size();
    }

    public class RecommendedHolder extends RecyclerView.ViewHolder {

        ConstraintLayout recommendedWrapper;
        RoundedImageView appIcon;
        TextView appName, appDeveloper, appSize, appRate;

        public RecommendedHolder(@NonNull View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.app_icon);
            appName = itemView.findViewById(R.id.app_name);
            appDeveloper = itemView.findViewById(R.id.app_developer);
            appSize = itemView.findViewById(R.id.size);
            appRate = itemView.findViewById(R.id.app_rate);
            recommendedWrapper = itemView.findViewById(R.id.recommended_wrapper);
        }
    }

    public ApplicationsAdapter(Context context, List<Applications> applicationsList){
        this.context = context;
        this.applicationsList = applicationsList;
    }
}
