package com.ljm.todolist.ui.fragment.contents.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ljm.todolist.R;
import com.ljm.todolist.obj.Todo;
import com.ljm.todolist.ui.fragment.contents.listener.RecyclerViewClickListener;

/**
 * Created by mc.kim on 2017-10-28.
 */

public class TodoListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title = null;
    private RecyclerViewClickListener mListener;

    public TodoListViewHolder(View itemView, RecyclerViewClickListener listener) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        mListener = listener;
        itemView.setOnClickListener(this);
    }

    public void setData(Todo data) {
        title.setText(data.getTitle());
    }

    @Override
    public void onClick(View view){
        mListener.onClick(view, title.getText().toString());
    }
}
