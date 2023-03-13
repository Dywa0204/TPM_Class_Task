package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tugas2.fragments.CalcFragment;
import com.example.tugas2.fragments.HomeFragment;
import com.example.tugas2.fragments.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    Button navCalcButton, navHomeButton, navProfileButton;
    TextView appBarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navCalcButton = findViewById(R.id.nav_calculate_btn);
        navHomeButton = findViewById(R.id.nav_home_btn);
        navProfileButton = findViewById(R.id.nav_profile_btn);
        appBarText = findViewById(R.id.app_bar_text);

        navCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNavButtonColor("calc");
                openFragment(new CalcFragment());
            }
        });

        navHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNavButtonColor("home");
                openFragment(new HomeFragment());
            }
        });

        navProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNavButtonColor("profile");
                openFragment(new ProfileFragment());
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home_container, new HomeFragment())
                .commit();
    }

    @SuppressLint({"UseCompatTextViewDrawableApis", "SetTextI18n"})
    public void setNavButtonColor(String button) {
        navCalcButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        navCalcButton.setTextColor(Color.parseColor("#ffffff"));
        navHomeButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        navHomeButton.setTextColor(Color.parseColor("#ffffff"));
        navProfileButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        navProfileButton.setTextColor(Color.parseColor("#ffffff"));

        switch (button) {
            case "calc":
                navCalcButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#f3a1f7")));
                navCalcButton.setTextColor(Color.parseColor("#f3a1f7"));
                appBarText.setText("CALCULATOR");
                break;
            case "home":
                navHomeButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#f3a1f7")));
                navHomeButton.setTextColor(Color.parseColor("#f3a1f7"));
                appBarText.setText("HOME");
                break;
            case "profile":
                navProfileButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#f3a1f7")));
                navProfileButton.setTextColor(Color.parseColor("#f3a1f7"));
                appBarText.setText("PROFILE");
                break;
        }
    }

    public void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home_container, fragment)
                .commit();
    }
}