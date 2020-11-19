package com.example.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class ChangeFragment extends Fragment implements Ifragments{

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Destinations> list;


    private final static  String ARG_PARAM = "param";
    private final static  String ARG_PARAM2 = "param2";
    private final static  String ARG_PARAM3 = "param3";
    private String mParam;
    private String mParam2;
    private int mParam3;



    public static ChangeFragment newInstance(String param,String param2,int param3){
        ChangeFragment textFragment = new ChangeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM,param);
        bundle.putString(ARG_PARAM2,param2);
        bundle.putInt(ARG_PARAM3,param3);
        textFragment.setArguments(bundle);
        return textFragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }

    }


    public ChangeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_change, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        setUpRecyclerView(view);
        return view;

    }

    public void setUpRecyclerView(View view){

        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list,getContext());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);

        list.add(new Destinations(mParam,mParam2,mParam3));
        list.add(new Destinations("title2","description2",R.drawable.ic_account));

    }


    @Override
    public void onDisplayDetails(String title,String description) {
            MainActivity activity = (MainActivity) getActivity();
            activity.displayDeteils(title,description);
    }
}