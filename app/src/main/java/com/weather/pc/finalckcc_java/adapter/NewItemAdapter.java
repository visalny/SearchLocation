package com.weather.pc.finalckcc_java.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.pc.finalckcc_java.R;

public class NewItemAdapter extends RecyclerView.Adapter<NewItemAdapter.NewItemViewHolder> {


    private Context context;

    public NewItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NewItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.new_itemfragment_layout,parent,false);

        return new NewItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    class NewItemViewHolder extends RecyclerView.ViewHolder{

        public NewItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
