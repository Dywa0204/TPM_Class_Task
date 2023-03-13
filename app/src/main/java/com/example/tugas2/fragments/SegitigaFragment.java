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

public class SegitigaFragment extends Fragment {

    View view;

    Button toLuas, toKeliling, resultBtn;
    EditText field1, field2, field3;
    TextView resultText;
    String hitung;

    public SegitigaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_segitiga, container, false);

        toLuas = view.findViewById(R.id.to_luas);
        toKeliling = view.findViewById(R.id.to_keliling);
        field1 = view.findViewById(R.id.field_1);
        field2 = view.findViewById(R.id.field_2);
        field3 = view.findViewById(R.id.field_3);
        resultBtn = view.findViewById(R.id.result_btn);
        resultText = view.findViewById(R.id.result_text);

        hitung = "luas";

        toLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLuas.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF3700B3")));
                toKeliling.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#939393")));
                field1.setHint("Alas");
                field2.setHint("Tinggi");
                field3.setVisibility(View.GONE);
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
                field3.setHint("Sisi C");
                field3.setVisibility(View.VISIBLE);
                hitung = "keliling";
            }
        });

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (hitung) {
                    case "luas":
                        double alas = Double.parseDouble(field1.getText().toString());
                        double tinggi = Double.parseDouble(field2.getText().toString());
                        double luas = (alas * tinggi) / 2;

                        resultText.setText("Hasil\n\nLuas = (Alas * Tinggi) / 2\nLuas = (" + alas + " * " + tinggi + ") / 2\nLuas = " + luas);
                        break;
                    case "keliling":
                        double sisi1 = Double.parseDouble(field1.getText().toString());
                        double sisi2 = Double.parseDouble(field2.getText().toString());
                        double sisi3 = Double.parseDouble(field3.getText().toString());
                        double keliling = (sisi1 + sisi2 + sisi3);

                        resultText.setText("Hasil\n\nKeliling = Sisi A + Sisi B + Sisi C\nKeliling = " + sisi1 + " + " + sisi2 + " + " + sisi3 + "\nKeliling = " + keliling);
                        break;
                }
            }
        });

        return view;
    }
}