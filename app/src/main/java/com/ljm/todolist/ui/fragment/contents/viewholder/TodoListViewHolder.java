package com.ljm.todolist.ui.fragment.contents.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.ljm.todolist.R;
import com.ljm.todolist.obj.Todo;
import com.ljm.todolist.ui.fragment.contents.listener.RecyclerViewClickListener;

/**
 * Created by mc.kim on 2017-10-28.
 */

public class TodoListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnKeyListener {

    private TextView title = null;
    private RecyclerViewClickListener mListener;

    public TodoListViewHolder(View itemView, RecyclerViewClickListener listener) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        mListener = listener;
        itemView.setOnClickListener(this);
        itemView.setOnKeyListener(this);
        itemView.setTag("");
    }

    public void setData(Todo data) {
        title.setText(data.getTitle());
    }

    @Override
    public void onClick(View view) {
        mListener.onClick(view, title.getText().toString());
    }


    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        // DPAD RIGHT
        mListener.onClick(view,title.getText().toString());
        return false;
    }
}
