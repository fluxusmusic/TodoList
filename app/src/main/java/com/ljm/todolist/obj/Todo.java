package com.ljm.todolist.obj;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by mc.kim on 2017-10-28.
 */

public class Todo implements Parcelable {

    private String title = null;
    private String description = null;

    private long createdDate;
    private long dueDate;
    private String type;
    private int notify;
    private int priority;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNotify() {

        return notify == 1;
    }

    public void setNotify(boolean notify) {

        this.notify = notify ? 1 : 0;

    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeLong(createdDate);
        parcel.writeLong(dueDate);
        parcel.writeString(type);
        parcel.writeInt(notify);
        parcel.writeInt(priority);
    }


    public Todo() {
    }

    private Todo(Parcel in) {
        title = in.readString();
        description = in.readString();
        createdDate = in.readLong();
        dueDate = in.readLong();
        type = in.readString();
        notify = in.readInt();
        priority = in.readInt();
    }


    public static final Parcelable.Creator<Todo> CREATOR
            = new Parcelable.Creator<Todo>() {
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };
}
