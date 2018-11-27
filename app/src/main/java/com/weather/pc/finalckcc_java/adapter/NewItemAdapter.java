package com.weather.pc.finalckcc_java.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.weather.pc.finalckcc_java.R;
import com.weather.pc.finalckcc_java.callback.ItemCallBackListener;

public class NewItemAdapter extends RecyclerView.Adapter<NewItemAdapter.NewItemViewHolder> {


    private ItemCallBackListener listener;
    private Context context;

    public NewItemAdapter(ItemCallBackListener listener, Context context) {
        this.listener = listener;
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

        private ImageView imv_new_item,imv_save;
        private TextView tv_name;
        public NewItemViewHolder(View itemView) {
            super(itemView);
            imv_new_item=itemView.findViewById(R.id.imv_new_item);
            imv_save=itemView.findViewById(R.id.btnmenu_item_new);
            tv_name=itemView.findViewById(R.id.tv_name_new_item);

            imv_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu=new PopupMenu(context,imv_save);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu_save_item,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            listener.ItemhomeClick(getAdapterPosition());
                            return true;
                        }
                    });
                    popupMenu.show();
                }
            });

        }
    }
}
