package com.anvar.example.vm;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anvar.example.model.Todo;
import com.anvar.example.repos.TodoRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";

    private TodoRepository repository = TodoRepository.getInstance();

    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<List<Todo>> todoLiveData = new MutableLiveData<>();

    private Call<List<Todo>> todoCall;

    public MainActivityViewModel() {
        super();
        isLoading.setValue(true);
        todoCall = repository.getTodos();
        todoLiveData.setValue(new ArrayList<>());
        loadTodos();
    }

    private void loadTodos() {
        todoCall.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Todo>> call, @NonNull Response<List<Todo>> response) {
                isLoading.postValue(false);
                todoLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Todo>> call, @NonNull Throwable t) {
                Log.d(TAG, "Failed to fetch todo list from sever");
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<List<Todo>> getTodoLiveData() {
        return todoLiveData;
    }
}
