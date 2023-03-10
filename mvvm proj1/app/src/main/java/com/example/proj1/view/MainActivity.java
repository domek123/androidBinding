package com.example.proj1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.proj1.databinding.ActivityMainBinding;
import com.example.proj1.viewmodel.SettingViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private SettingViewModel settingViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        settingViewModel = new ViewModelProvider(MainActivity.this)
                .get(SettingViewModel.class);
        settingViewModel.setupSettings();
        settingViewModel.getObservedSettings().observe(MainActivity.this, s ->{
            activityMainBinding.tv.setText(s.getUrl() + ":" + s.getPort());
        });
        activityMainBinding.btn.setOnClickListener(v->{
            String url = activityMainBinding.et.getText().toString();
            String port = activityMainBinding.et2.getText().toString();
            settingViewModel.changeSettings(url,port);

        });
    }
}