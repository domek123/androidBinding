package com.example.bindapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.bindapp1.databinding.ActivityMain2Binding;
import com.example.bindapp1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.bindapp1.databinding.ActivityMain2Binding activityMainBinding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);//
        Bundle extras = getIntent().getExtras();
        int value = Integer.parseInt(extras.get("value").toString());
        Log.d("XXX",value+"");
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int[] array = new int[]{0xffff0000,0xff00ff00,0xff0000ff};
        Random random = new Random();
        for(int i = 0;i<value;i++){
            View view1 = new View(MainActivity2.this);
            view1.setLayoutParams(new ViewGroup.LayoutParams(size.x,300));
            int rand = array[random.nextInt(3)];
            view1.setBackgroundColor(rand);
            view1.setOnClickListener(v->{
                Log.d("AAA","click");
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("value",rand);
                startActivity(intent);
            });
            activityMainBinding.mainLayout.addView(view1);
        }
    }
}