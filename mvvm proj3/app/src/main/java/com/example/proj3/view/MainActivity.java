
package com.example.proj3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.proj3.R;
import com.example.proj3.databinding.ActivityMainBinding;
import com.example.proj3.viewmodel.PersonViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private PersonViewModel personViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        personViewModel = new ViewModelProvider(MainActivity.this).get(PersonViewModel.class);
        personViewModel.setupPerson();
        personViewModel.getObservedPerson().observe(MainActivity.this,s->{
            activityMainBinding.setPersonViewModel(personViewModel);
        });
        activityMainBinding.btn1.setOnClickListener(v->{
            String name = activityMainBinding.tv1.getText().toString();
            if(name.equals("TOMASZ")){
                personViewModel.setPersonName("ELA");
            }else{
                personViewModel.setPersonName("TOMASZ");
            }
            activityMainBinding.setPersonViewModel(personViewModel);
        });
        activityMainBinding.btn2.setOnClickListener(v -> {
            String name = activityMainBinding.tv2.getText().toString();
            if (name.equals("MALE")) {
                personViewModel.setPersonGenre("FEMALE");
            } else {
                personViewModel.setPersonGenre("MALE");
            }
            activityMainBinding.setPersonViewModel(personViewModel);
        });
        activityMainBinding.btn3.setOnClickListener(v->{
            String name = activityMainBinding.tv1.getText().toString();
            if(name.equals("TOMASZ")){
                personViewModel.changePerson("FEMALE","ELA");
            }else{
                personViewModel.changePerson("MALE","TOMASZ");
            }
            activityMainBinding.setPersonViewModel(personViewModel);
        });
    }
}