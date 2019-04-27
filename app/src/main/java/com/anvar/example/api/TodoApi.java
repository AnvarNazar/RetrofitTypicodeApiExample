package com.anvar.example.api;

import com.anvar.example.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoApi {
    @GET("todos/")
    Call<List<Todo>> getTodos();

    @GET("todos/{id}")
    Call<Todo> getTodo(@Path("id") long id);
}
