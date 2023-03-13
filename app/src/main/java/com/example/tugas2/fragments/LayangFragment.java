package com.example.tugas2.fragments;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tugas2.R;

public class LayangFragment extends Fragment {
    View view;

    Button toLuas, toKeliling, resultBtn;
    EditText field1, field2;
    TextView resultText;
    String hitung;

    public LayangFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layang, container, false);

        toLuas = view.findViewById(R.id.to_luas);
        toKeliling = view.findViewById(R.id.to_keliling);
        field1 = view.findViewById(R.id.field_1);
        field2 = view.findViewById(R.id.field_2);
        resultBtn = view.findViewById(R.id.result_btn);
        resultText = view.findViewById(R.id.result_text);

        hitung = "luas";

        toLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLuas.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF3700B3")));
                toKeliling.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#939393")));
                field1.setHint("Diagonal 1");
                field2.setHint("Diagonal 2");
                hitung = "luas";
            }
        });

        toKeliling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLuas.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#939393")));
                toKeliling.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF3700B3")));
                field1.setHint("Sisi A");
                field2.setHint("Sisi B");
                hitung = "keliling";
            }
        });

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (hitung) {
                    case "luas":
                        double d1 = Double.parseDouble(field1.getText().toString());
                        double d2 = Double.parseDouble(field2.getText().toString());
                        double luas = (d1 * d2) / 2;

                        resultText.setText("Hasil\n\nLuas = (Diagonal 1 * Diagonal2) / 2\nLuas = (" + d1 + " * " + d2 + ") / 2\nLuas = " + luas);
                        break;
                    case "keliling":
                        double sisi1 = Double.parseDouble(field1.getText().toString());
                        double sisi2 = Double.parseDouble(field2.getText().toString());
                        double keliling = 2 * (sisi1 + sisi2);

                        resultText.setText("Hasil\n\nKeliling = 2 * (Sisi A + Sisi B)\nKeliling = 2 * (" + sisi1 + " + " + sisi2 + ")\nKeliling = " + keliling);
                        break;
                }
            }
        });

        return view;
    }
}