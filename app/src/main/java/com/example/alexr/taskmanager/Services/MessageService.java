package com.example.alexr.taskmanager.Services;

import com.example.alexr.taskmanager.Models.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MessageService {
    @GET("message")
    Call<String> getMessage();
}
