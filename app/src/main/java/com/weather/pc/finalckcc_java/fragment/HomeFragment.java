package com.weather.pc.finalckcc_java.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.weather.pc.finalckcc_java.R;
import com.weather.pc.finalckcc_java.activity.DetailhomeActivity;
import com.weather.pc.finalckcc_java.adapter.HomeAdapter;
import com.weather.pc.finalckcc_java.callback.ItemCallBackListener;
import com.weather.pc.finalckcc_java.entity.Location;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;


public class HomeFragment extends Fragment implements ItemCallBackListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView home_item;
    private List<Location> locationList;
    private HomeAdapter adapter;
    private Location location;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        home_item=view.findViewById(R.id.home_item);
        home_item.setLayoutManager(new GridLayoutManager(getContext(),3));
         adapter=new HomeAdapter(getContext(),this);
        home_item.setAdapter(adapter);
        LoaddataFromFirebase();
    }

    @Override
    public void ItemhomeClick(int id) {
        Toast.makeText(getContext(), "Item position"+id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ItemClickImage(int postion) {
        Intent intent=new Intent(getContext(),DetailhomeActivity.class);
        intent.putExtra("position", postion);
        intent.putExtra("address",location.getLocation_address());
        intent.putExtra("url",location.getLocation_image());
        startActivity(intent);
    }

    //get data from firebase
    private void LoaddataFromFirebase(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("locations").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                locationList=new ArrayList<>(queryDocumentSnapshots.size());
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                   location=documentSnapshot.toObject(Location.class);
                    Log.e("ooo", "onEvent: "+location.getLocation_image() );
                    locationList.add(location);
                }
                //eventAdapter.setEvents(events);
                adapter.AddData(locationList);
            }
        });
    }
}
