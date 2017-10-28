package com.ljm.todolist.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ljm.todolist.R;
import com.ljm.todolist.ui.fragment.contents.TodoFragment;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }

}
