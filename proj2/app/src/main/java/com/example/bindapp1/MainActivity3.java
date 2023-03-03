package com.example.bindapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.bindapp1.databinding.ActivityMain3Binding;
import com.example.bindapp1.databinding.ActivityMainBinding;

public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        Bundle extras = getIntent().getExtras();
        int value = Integer.parseInt(extras.get("value").toString());
        activityMainBinding.mainLayout.setBackgroundColor(value);
        activityMainBinding.text.setText(value + "");
    }
}