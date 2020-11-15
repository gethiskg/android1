package com.example.homeworkfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FragmentRecycler extends Fragment implements MessageCarrier {


    private RecyclerView recyclerView;
    private ArrayList<String> list;
    private MyAdapter myAdapter;
    private DynamicFragment dynamicFragment;
    private FragmentClicker clicker;


    public FragmentRecycler() {
        // Required empty public constructor
    }


    public static FragmentRecycler newInstance(String param1) {
        FragmentRecycler fragment = new FragmentRecycler();
        Bundle args = new Bundle();


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerInFragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(list, this.getContext());
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void getMessage(String message) {
        myAdapter.addOn(message);
    }
}

