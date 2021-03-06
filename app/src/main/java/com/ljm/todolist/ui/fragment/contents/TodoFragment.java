package com.ljm.todolist.ui.fragment.contents;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljm.todolist.R;
import com.ljm.todolist.obj.Todo;
import com.ljm.todolist.ui.fragment.contents.adapter.TodoListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mc.kim on 2017-10-28.
 */

public class TodoFragment extends Fragment {
    //TODO list
    //

    private static final String KEY_TODO_LIST = "todoList";

    public TodoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TodoFragment newInstance(ArrayList<Todo> todoList) {
        TodoFragment fragment = new TodoFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(KEY_TODO_LIST, todoList);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_todo, container, false);
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView todoListView = (RecyclerView) view.findViewById(R.id.todoList);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        todoListView.setLayoutManager(manager);


        TodoListAdapter todoListAdapter = new TodoListAdapter();
        todoListView.setAdapter(todoListAdapter);

        todoListAdapter.setItemList(gen());
    }


    private ArrayList<Todo> gen() {
        ArrayList list = new ArrayList();

        for (int i = 0; i < 100; i++) {
            Todo todo = new Todo();
            todo.setTitle("saim [" + i + "]");
            list.add(todo);
        }
        return list;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
