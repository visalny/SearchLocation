package com.weather.pc.finalckcc_java.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.weather.pc.finalckcc_java.R;
import com.weather.pc.finalckcc_java.adapter.HomeAdapter;
import com.weather.pc.finalckcc_java.adapter.NewItemAdapter;
import com.weather.pc.finalckcc_java.callback.ItemCallBackListener;


public class NewFragment extends Fragment implements ItemCallBackListener {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    public NewFragment() {
        // Required empty public constructor
    }

    private RecyclerView new_item;
    public static NewFragment newInstance(String param1, String param2) {
        NewFragment fragment = new NewFragment();
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
        return inflater.inflate(R.layout.fragment_new, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        new_item=view.findViewById(R.id.new_item);
        new_item.setLayoutManager(new GridLayoutManager(getContext(),3));
        NewItemAdapter adapter=new NewItemAdapter(this,getContext());
        new_item.setAdapter(adapter);
    }

    @Override
    public void ItemhomeClick(int id) {
        Toast.makeText(getContext(), ""+id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ItemClickImage(int position) {

    }
}
