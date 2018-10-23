package com.example.demoapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.demoapplication.R;
import com.example.demoapplication.view.DogView;

public class Demo12Activity extends AppCompatActivity {

    private DogView dogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo12);
        Button button=findViewById(R.id.go);
        dogView=findViewById(R.id.dog_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogView.initCount();
                dogView.startAnimator();
            }
        });
    }
}
