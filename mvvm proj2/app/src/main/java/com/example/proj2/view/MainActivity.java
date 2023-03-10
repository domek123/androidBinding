package com.example.proj2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.proj2.R;
import com.example.proj2.databinding.ActivityMainBinding;
import com.example.proj2.viewmodel.TestViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private TestViewModel testViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        testViewModel = new ViewModelProvider(MainActivity.this).get(TestViewModel.class);
        testViewModel.setupData(22);
        testViewModel.getObservedAge().observe(MainActivity.this,s->{
            Log.d("XXX", "data changes" + s);
            activityMainBinding.setTestVievModel(testViewModel);
        });
        activityMainBinding.btn1.setOnClickListener(v->{
            String nr = activityMainBinding.tv1.getText().toString();

            Log.d("XXX",nr);
            if(Integer.parseInt(nr)%2 == 0){
                activityMainBinding.tv1.setBackgroundColor(0xFF0000FF);
            }else{
                activityMainBinding.tv1.setBackgroundColor(0x00FF00FF);
            }
            testViewModel.changeAge(Integer.parseInt(nr)+1);
        });
    }
}