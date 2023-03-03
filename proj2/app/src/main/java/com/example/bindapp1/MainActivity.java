package com.example.bindapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import com.example.bindapp1.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        activityMainBinding.button.setOnClickListener(v->{
           Editable text = activityMainBinding.text.getText() ;
            if(text.length() == 0){
                Snackbar s = Snackbar.make(view, "text", Snackbar.LENGTH_LONG);
                s.setAction("OK", a -> activityMainBinding.text.setText("5"));
                s.show();
            }else{
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("value",text);
                startActivity(intent);
            }
        });
    }
}