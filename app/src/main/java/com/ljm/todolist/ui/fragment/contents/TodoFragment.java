package com.ljm.todolist.ui.fragment.contents;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.OnRebindCallback;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.ljm.todolist.R;
import com.ljm.todolist.databinding.FragmentTodoBinding;
import com.ljm.todolist.obj.Todo;
import com.ljm.todolist.ui.fragment.contents.adapter.TodoListAdapter;
import com.ljm.todolist.ui.fragment.contents.listener.RecyclerViewClickListener;
import com.ljm.todolist.ui.viewmodle.TodoDataModel;
import com.ljm.todolist.ui.viewmodle.ViewModelFactory;

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

        iniMiniEpgViewModel();
    }

    private TodoDataModel mTodoDataModel = null;
    FragmentTodoBinding mTodoBinding = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View parentView = inflater.inflate(R.layout.fragment_todo, container, false);
        mTodoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo, container, false);
        mTodoBinding.setViewModel(mTodoDataModel);

        return mTodoBinding.getRoot();
    }

    private TodoListAdapter todoListAdapter = null;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView todoListView = mTodoBinding.todoList;

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        todoListView.setLayoutManager(manager);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String message) {
                mTodoDataModel.setPosition(message);
//                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        };

        todoListAdapter = new TodoListAdapter(listener);
        todoListView.setAdapter(todoListAdapter);


        todoListAdapter.setItemList(gen());


//        todoListAdapter.setItemList(gen());
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

    private RecyclerViewClickListener mRecyclerViewClickListener = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof RecyclerViewClickListener) {
            mRecyclerViewClickListener = (RecyclerViewClickListener) context;

        }
    }


    private void iniMiniEpgViewModel() {

        if (mTodoDataModel != null) {
            return;
        }
        mTodoDataModel = obtainViewModel(getActivity());
    }


    private TodoDataModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        TodoDataModel viewModel =
                ViewModelProviders.of(activity, factory).get(TodoDataModel.class);
        return viewModel;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
