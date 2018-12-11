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

import com.github.rubensousa.bottomsheetbuilder.BottomSheetBuilder;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetMenuDialog;
import com.github.rubensousa.bottomsheetbuilder.adapter.BottomSheetItemClickListener;
import com.squareup.picasso.Picasso;
import com.weather.pc.finalckcc_java.R;
import com.weather.pc.finalckcc_java.callback.ItemCallBackListener;
import com.weather.pc.finalckcc_java.entity.Location;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private Context context;
    private ItemCallBackListener listener;
    private List<Location> locationList;


    public HomeAdapter(Context context, ItemCallBackListener listener) {
        this.context = context;
        this.listener = listener;
        locationList=new ArrayList<>();
    }

    public void AddData(List<Location> locations){
        locationList.addAll(locations);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.homefragment_layout,parent,false);
        return new HomeViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Location location=locationList.get(position);
        holder.tv_name.setText(location.getLocation_address());
        Picasso.get()
                .load(location.getLocation_image())
                .placeholder(R.drawable.ic_save_black_24dp)
                .error(R.drawable.ic_save_black_24dp)
                .into(holder.imv_home);
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imv_home,imv_save;
        private TextView tv_name;
        public HomeViewHolder(View itemView) {
            super(itemView);
            imv_home=itemView.findViewById(R.id.imv_home_item);
            tv_name=itemView.findViewById(R.id.tv_name_home_item);
            imv_save=itemView.findViewById(R.id.btnmenu_item_home);

            imv_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    PopupMenu popupMenu=new PopupMenu(context,imv_save);
//                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu_save_item,popupMenu.getMenu());
//                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem item) {
//                            listener.ItemhomeClick(getAdapterPosition());
//                            return true;
//                        }
//                    });
//                    popupMenu.show();
                    BottomSheetMenuDialog dialog=new BottomSheetBuilder(context,R.style.Theme_Design_BottomSheetDialog)
                            .setMode(BottomSheetBuilder.MODE_LIST)
                            .setMenu(R.menu.popup_menu_save_item)
                            .setBackground(R.color.white)
                            .setItemClickListener(new BottomSheetItemClickListener() {
                                @Override
                                public void onBottomSheetItemClick(MenuItem item) {
                                    if(item.getItemId()==R.id.item_save){
                                        listener.ItemhomeClick(getAdapterPosition());
                                    }
                                }
                            })
                            .createDialog();
                    dialog.show();
                }
            });

            imv_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.ItemClickImage(getAdapterPosition());
                }
            });
        }
    }
}
