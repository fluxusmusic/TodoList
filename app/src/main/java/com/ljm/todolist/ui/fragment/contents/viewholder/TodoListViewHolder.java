package com.ljm.todolist.ui.fragment.contents.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ljm.todolist.R;
import com.ljm.todolist.obj.Todo;

/**
 * Created by mc.kim on 2017-10-28.
 */

public class TodoListViewHolder extends RecyclerView.ViewHolder {

    private TextView title = null;

    public TodoListViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
    }

    public void setData(Todo data) {
        title.setText(data.getTitle());
    }


}
