package com.example.proj3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.proj3.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        User user = new User("Jan", "Kowalski");
        activityMainBinding.setUser(user);
        String arr[] = {"anna","jan"};
        Random random = new Random();
        activityMainBinding.button.setOnClickListener(v->{

            user.fName = arr[random.nextInt(2)];
            activityMainBinding.setUser(user);
        });
        Movie movie = new Movie("Insomnia");
        activityMainBinding.setMovie(movie);
        activityMainBinding.editview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                movie.setTitle(activityMainBinding.editview.getText().toString());
                activityMainBinding.setMovie(movie);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Selected selected = new Selected(true);
        activityMainBinding.setSelected(selected);
        activityMainBinding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(activityMainBinding.checkbox.isChecked()){
                    selected.setChecked(false);
                }else{
                    selected.setChecked(true);
                }
                activityMainBinding.setSelected(selected);
            }
        });
    }

}