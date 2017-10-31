package com.ljm.todolist.ui.viewmodle;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.ljm.todolist.obj.Todo;

import java.util.ArrayList;

/**
 * Created by mc.kim on 2017-10-31.
 */

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelFactory ourInstance = null;
    private final String TAG = ViewModelFactory.class.getSimpleName();

    public static ViewModelFactory getInstance(Application application) {
        if (ourInstance == null) {
            synchronized (ViewModelFactory.class) {
                ourInstance = new ViewModelFactory(application);
            }
        }
        return ourInstance;
    }


    private Application mApplication = null;

    private ViewModelFactory(Application application) {
        mApplication = application;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TodoDataModel.class)) {
            return (T) new TodoDataModel(mApplication);
        }

        return super.create(modelClass);
    }
}
