package com.example.fragment;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class TextFragment extends Fragment implements  CarrierData{
    private TextView txtView;
    private TextView txtDesc;

    private final static  String ARG_PARAM = "param";
    private final static  String ARG_PARAM2 = "param2";
    private String mParam;
    private String mParam2;


    public static TextFragment newInstance(String param,String param2){
        TextFragment textFragment = new TextFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM,param);
        bundle.putString(ARG_PARAM2,param2);
        textFragment.setArguments(bundle);
        return textFragment;
    }

    public TextFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_text, container, false);
        txtView = view.findViewById(R.id.textTitle);
        txtDesc = view.findViewById(R.id.descText);
        if (mParam != null && mParam2 != null){
            txtView.setText(mParam);
            txtDesc.setText(mParam2);
        }
        return view;
    }


    public void displayDetails(String title, String desc){
        Log.d("TAG", "displayDetails: ");
        txtView.setText(title);
        txtDesc.setText(desc);
        }


    @Override
    public void getDataToDeliver(String title, String desc) {
        displayDetails(title,desc);
    }
}