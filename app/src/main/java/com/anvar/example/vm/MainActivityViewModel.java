package com.anvar.example.vm;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anvar.example.model.Todo;
import com.anvar.example.repos.TodoRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";

    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private LiveData<List<Todo>> todoLiveData;

    public MainActivityViewModel() {
        super();
        isLoading.setValue(true);
        TodoRepository repository = TodoRepository.getInstance();
        todoLiveData = repository.getTodos();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<List<Todo>> getTodoLiveData() {
        return todoLiveData;
    }
}
