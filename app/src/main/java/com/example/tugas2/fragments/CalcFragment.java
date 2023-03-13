package com.example.tugas2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.tugas2.HomeActivity;
import com.example.tugas2.R;

public class CalcFragment extends Fragment {

    View view;

    LinearLayout toSegitiga, toLayang;

    public CalcFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calc, container, false);

        toSegitiga = view.findViewById(R.id.to_segitiga);
        toLayang = view.findViewById(R.id.to_layang);

        toSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity) requireActivity()).openFragment(new SegitigaFragment());
            }
        });

        toLayang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity) requireActivity()).openFragment(new LayangFragment());
            }
        });

        return view;
    }
}