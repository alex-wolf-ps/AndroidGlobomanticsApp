package com.example.alexr.taskmanager.services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageService {
    @GET("message")
    Call<String> getMessage();
}
