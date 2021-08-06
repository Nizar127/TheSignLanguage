package com.balqis.wetalklatest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class onboardingAdapter extends RecyclerView.Adapter<onboardingAdapter.OnBoardingViewHolder> {
    List<OnBoardingItem> onBoardingItems;

    public onboardingAdapter(List<OnBoardingItem> onBoardingItems){
        this.onBoardingItems = onBoardingItems;
    }
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.onboarding_layout_ui,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  onboardingAdapter.OnBoardingViewHolder holder, int position) {
            holder.setOnBoardingData(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    public class OnBoardingViewHolder extends RecyclerView.ViewHolder {
       TextView title, description;
       ImageView imageBoarding;

        public OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);

            title           = itemView.findViewById(R.id.textTitle);
            description     = itemView.findViewById(R.id.textDescription);
            imageBoarding   = itemView.findViewById(R.id.imageOnboarding);
        }

        void setOnBoardingData(OnBoardingItem onBoardingItem){
            title.setText(onBoardingItem.getTitle());
            description.setText(onBoardingItem.getDescription());
            imageBoarding.setImageResource(onBoardingItem.getImage());
        }
    }


}
