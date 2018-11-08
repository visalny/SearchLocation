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

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {


    private Context context;

    public NotificationAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_layout,parent,false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class NotificationViewHolder extends RecyclerView.ViewHolder{

        private ImageView imv_notification;
        private TextView tv_notification;
        public NotificationViewHolder(View itemView) {
            super(itemView);
            imv_notification=itemView.findViewById(R.id.imv_notification_item);
            tv_notification=itemView.findViewById(R.id.tv_notification);
        }
    }
}
