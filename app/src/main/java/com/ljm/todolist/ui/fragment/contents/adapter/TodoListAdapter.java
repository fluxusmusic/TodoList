package com.ljm.todolist.ui.fragment.contents.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljm.todolist.R;
import com.ljm.todolist.obj.Todo;
import com.ljm.todolist.ui.fragment.contents.listener.RecyclerViewClickListener;
import com.ljm.todolist.ui.fragment.contents.viewholder.TodoListViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mc.kim on 2017-10-28.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListViewHolder> {

    private RecyclerViewClickListener mListener;
    private ArrayList<Todo> mItemList = null;

    public TodoListAdapter(RecyclerViewClickListener listener) {
        mListener = listener;
    }

    public void setItemList(ArrayList itemList) {
        this.mItemList = itemList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return R.layout.item_todo;
    }

    @Override
    public void onBindViewHolder(TodoListViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    /***
     *
     *
     *
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public TodoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View convertView = inflater.inflate(viewType, parent, false);

        TodoListViewHolder viewHolder = new TodoListViewHolder(convertView, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodoListViewHolder holder, int position) {
        holder.setData(mItemList.get(position));
    }

    @Override
    public int getItemCount() {

        if (mItemList == null) {
            return 0;
        } else {
            return mItemList.size();
        }
    }
}
