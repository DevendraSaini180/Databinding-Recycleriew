package com.saini.databindingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.saini.databindingapplication.databinding.ActivityMainBinding;
import com.saini.databindingapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserAdapter adapter = new UserAdapter(getUserList(), this);
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private List<User> getUserList() {
        List<User> users = new ArrayList<>();

        users.add(new User("Rajesh", 21, true, "https://picsum.photos/id/237/200"));
        users.add(new User("Mahesh", 19, true, "https://picsum.photos/id/238/200"));
        users.add(new User("Mukesh", 32, false, "https://picsum.photos/id/239/200"));
        users.add(new User("Suresh", 43, true, "https://picsum.photos/id/240/200"));
        users.add(new User("Devesh", 25, false, "https://picsum.photos/id/241/200"));

        return users;
    }
}