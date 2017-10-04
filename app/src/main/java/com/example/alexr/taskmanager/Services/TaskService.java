package com.example.alexr.taskmanager.Services;

import com.example.alexr.taskmanager.Models.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TaskService {
    @GET("tasks")
    Call<List<Task>> getTasks();

    @GET("tasks/{id}")
    Call<Task> getTask(@Path("id") int taskId);
}
