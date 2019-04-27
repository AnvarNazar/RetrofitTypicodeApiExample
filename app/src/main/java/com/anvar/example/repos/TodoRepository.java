package com.anvar.example.repos;

import com.anvar.example.api.TodoApi;
import com.anvar.example.model.Todo;
import com.anvar.example.util.ApiBuilder;

import java.util.List;

import retrofit2.Call;

public class TodoRepository {
    private static final TodoRepository ourInstance = new TodoRepository();
    private TodoApi api;

    public static TodoRepository getInstance() {
        return ourInstance;
    }

    private TodoRepository() {
        api = ApiBuilder.create(TodoApi.class);
    }

    public Call<List<Todo>> getTodos() {
        return api.getTodos();
    }

    public Call<Todo> getTodo(long id) {
        return api.getTodo(id);
    }
}
