package com.anvar.example.repos;

import com.anvar.example.api.TodoApi;
import com.anvar.example.model.Todo;
import com.anvar.example.util.ApiBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

class TodRepository {
    private static final TodRepository ourInstance = new TodRepository();
    private TodoApi api;

    static TodRepository getInstance() {
        return ourInstance;
    }

    private TodRepository() {
        api = ApiBuilder.create(TodoApi.class);
    }

    public Call<List<Todo>> getTodos() {
        return api.getTodos();
    }

    public Call<Todo> getTodo(long id) {
        return api.getTodo(id);
    }
}
