package com.example.homeworkfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class DynamicFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    public EditText editTxtDynamic;
    private Button btnTransport;
    private FragmentClicker clickListener;


    private String mParam1;


    public DynamicFragment() {
        // Required empty public constructor
    }


    public static DynamicFragment newInstance(String param1) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_dynamic, container, false);
        clickListener = (FragmentClicker) getActivity();// initializing the clickListener to avoid getting null object reference!
        initView(view);
        clickListener();

        return view;
    }

    private void initView(View view) {

        editTxtDynamic = view.findViewById(R.id.dynamicTxtEdit);
        btnTransport = view.findViewById(R.id.btnDynamicTrans);
    }

    private void clickListener() {
        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.clickTextTransporter(editTxtDynamic.getText().toString());
//                clickListener.clickTextTransporter(editTxtDynamic.getText().toString()); second way of implementing the methods


            }
        });
    }
}