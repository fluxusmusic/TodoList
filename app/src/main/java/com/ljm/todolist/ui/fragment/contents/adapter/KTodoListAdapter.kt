package com.ljm.todolist.ui.fragment.contents.adapter

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ljm.todolist.R

/**
 * Created by user on 2017-11-14.
 */
class Todo : Parcelable {

    var title: String?=null
    var description: String?=null
    var createdDate: Long  = -1
    var dueDate:Long = -1
    var type:String?=null
    var notify:Int= 0
    var priority:Int= 0

    private fun Todo(p0:Parcel){
        title = p0.readString()
        description = p0.readString()
        createdDate = p0.readLong()
        dueDate = p0.readLong()
        type = p0.readString()
        notify = p0.readInt()
        priority = p0.readInt()
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeLong(createdDate)
        parcel.writeLong(dueDate)
        parcel.writeString(type)
        parcel.writeInt(notify)
        parcel.writeInt(priority)
    }

    override fun describeContents(): Int {
        return 0
    }

    val CREATOR: Parcelable.Creator<Todo> = object : Parcelable.Creator<Todo> {
        override fun createFromParcel(p0: Parcel?): Todo {
            return Todo()
        }

        override fun newArray(size: Int): Array<Todo?> {
            return arrayOfNulls<Todo>(size)
        }
    }
}


class TodoListViewHolder(view:View) :RecyclerView.ViewHolder(view){

    val title:TextView = itemView.findViewById<View>(R.id.title) as TextView

    fun setData(data: Todo) {
        title.text = data.title
    }

}

class KTodoListAdapter :RecyclerView.Adapter<TodoListViewHolder>(){

    var mItemList:ArrayList<Todo>?= null


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoListViewHolder {
        var inflater = LayoutInflater.from(parent?.context)
        val mainView:View = inflater.inflate(R.layout. item_todo,parent,false)
        return TodoListViewHolder(mainView)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder?, position: Int) {
        holder?.setData(mItemList!!.get(position))
    }


    override fun getItemCount(): Int = mItemList!!.size;

    fun setItemList(itemList:ArrayList<Todo>) {
        this.mItemList = itemList
        notifyDataSetChanged()
    }
}