package com.weather.pc.finalckcc_java.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weather.pc.finalckcc_java.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.homefragment_layout,parent,false);
        return new HomeViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imv_home;
        private TextView tv_name;
        public HomeViewHolder(View itemView) {
            super(itemView);
            imv_home=itemView.findViewById(R.id.imv_home_item);
            tv_name=itemView.findViewById(R.id.tv_name_home_item);
        }
    }
}
