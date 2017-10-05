package com.example.alexr.taskmanager.Services;

import com.example.alexr.taskmanager.Models.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TaskService {
    @GET("tasks")
    Call<List<Task>> getTasks();

    @GET("tasks/{id}")
    Call<Task> getTask(@Path("id") int taskId);

    @POST("tasks")
    Call<Task> createTask(@Body Task task);

    @PUT("tasks")
    Call<Task> updateTask(@Body Task task);
}
