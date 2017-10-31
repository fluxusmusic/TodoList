package com.ljm.todolist.ui.viewmodle;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.ljm.todolist.obj.Todo;

import java.util.ArrayList;

/**
 * Created by mc.kim on 2017-10-31.
 */

public class TodoDataModel extends AndroidViewModel {

    public ObservableArrayList<Todo> todoList = new ObservableArrayList<>();
    public ObservableField<String> clickPosition = new ObservableField();



    public TodoDataModel(Application application) {
        super(application);
    }

    public void setTodoList(ArrayList<Todo> todoList) {
        this.todoList.addAll(todoList);
    }

    public ArrayList<Todo> getTodoList() {
        return todoList;
    }

    public void setPosition(String message){
        clickPosition.set(message);
    }


}
