package com.anvar.example;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anvar.example.adapter.TodoAdapter;
import com.anvar.example.model.Todo;
import com.anvar.example.vm.MainActivityViewModel;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private MainActivityViewModel mViewModel;

    RecyclerView todoListRecyclerView;
    ProgressBar loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todoListRecyclerView = findViewById(R.id.todo_recycler_view);
        loadingIndicator = findViewById(R.id.todo_loading_indicator);
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Todos");

        mViewModel.getIsLoading().observe(this, (Boolean isLoading) -> {
            if (isLoading) loadingIndicator.setVisibility(View.VISIBLE);
            else loadingIndicator.setVisibility(View.GONE);
        });

        mViewModel.getTodoLiveData().observe(this, (List<Todo> todos) -> {
            mViewModel.getIsLoading().postValue(false);
            initRecyclerView(todos);
        });
    }

    private void initRecyclerView(List<Todo> todos) {
        TodoAdapter adapter = new TodoAdapter(this, todos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        todoListRecyclerView.setLayoutManager(layoutManager);
        todoListRecyclerView.setAdapter(adapter);
    }
}
