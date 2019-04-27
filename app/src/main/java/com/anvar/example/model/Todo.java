package com.anvar.example.model;

import com.google.gson.annotations.SerializedName;

public class Todo {
    @SerializedName("id")
    public long id;
    @SerializedName("userId")
    public long userId;
    @SerializedName("title")
    public String title;
    @SerializedName("completed")
    public boolean isCompleted;
}
