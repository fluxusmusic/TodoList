package com.ljm.todolist.ui.fragment.contents

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ljm.todolist.R
import com.ljm.todolist.ui.fragment.contents.adapter.KTodoListAdapter
import com.ljm.todolist.ui.fragment.contents.adapter.Todo
import java.util.ArrayList

/**
 * Created by user on 2017-11-14.
 */
class KTodoFragment : Fragment(){

    val KEY_TODO_LIST:String = "TODO_LIST"
    var todoList:ArrayList<Todo>?= null

    fun newInstance(todoList:ArrayList<Todo>):KTodoFragment{
        val fragment = KTodoFragment();
        val args = Bundle()
        //args.putParcelableArrayList(KEY_TODO_LIST, todoList)
        fragment.arguments = args
        return fragment
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val parentView = inflater!!.inflate(R.layout.fragment_todo, container, false);
        return parentView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val todoListView = view!!.findViewById<View>(R.id.todoList) as RecyclerView

        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        todoListView.layoutManager = manager


        val KTodoListAdapter = KTodoListAdapter()
        todoListView.adapter = KTodoListAdapter

        KTodoListAdapter.setItemList(gen())
    }


    private fun gen(): ArrayList<Todo> {
        val list = ArrayList<Todo>()

        for (i in 0..99) {
            val todo = Todo()
            todo.title = "saim [$i+1]"
            list.add(todo)
        }
        return list
    }

}