package com.example.tugas2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.tugas2.HomeActivity;
import com.example.tugas2.R;

import java.util.Objects;

public class HomeFragment extends Fragment {

    View view;

    LinearLayout toCalc, toProfile;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        toCalc = view.findViewById(R.id.to_calculator);
        toProfile = view.findViewById(R.id.to_profile);

        toCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity) requireActivity()).setNavButtonColor("calc");
                ((HomeActivity) requireActivity()).openFragment(new CalcFragment());
            }
        });

        toProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity) requireActivity()).setNavButtonColor("profile");
                ((HomeActivity) requireActivity()).openFragment(new ProfileFragment());
            }
        });

        return view;
    }
}