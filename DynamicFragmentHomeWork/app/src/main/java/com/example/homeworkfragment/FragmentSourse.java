package com.example.homeworkfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentSourse extends Fragment {


    private Button btnHide;
    private Button btnShow;
    private FragmentClicker clickListener;
    private String mParam1;

    public FragmentSourse() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sourse, container, false);
        clickListener = (FragmentClicker) getActivity();
        initView(view);
        initListener();
        return view;
    }

    private void initListener() {
        btnHide.setOnClickListener(v -> clickListener.clickHideFragment());
        btnShow.setOnClickListener(v -> clickListener.clickShowFragment());
    }

    private void initView(View view) {
        btnShow = view.findViewById(R.id.buttonShow);
        btnHide = view.findViewById(R.id.buttonHide);
    }
}