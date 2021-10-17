package com.saini.databindingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.saini.databindingapplication.databinding.ActivityMainBinding;
import com.saini.databindingapplication.model.User;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        mActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(mActivityMainBinding.getRoot());
//        mActivityMainBinding.setMyVariable("Devendra Saini");

        User user = new User("Devendra", 24, true, "https://picsum.photos/seed/picsum/200/300");
        mActivityMainBinding.setUser(user);
        mActivityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "User profile created..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}