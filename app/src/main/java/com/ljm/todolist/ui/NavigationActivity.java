package com.ljm.todolist.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ljm.todolist.R;
import com.ljm.todolist.ui.fragment.contents.TodoFragment;
import com.ljm.todolist.ui.fragment.contents.listener.RecyclerViewClickListener;

public class NavigationActivity extends AppCompatActivity implements RecyclerViewClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }

    @Override
    public void onClick(View view, String title) {
        Toast.makeText(this,title, Toast.LENGTH_LONG).show();

    }
}
