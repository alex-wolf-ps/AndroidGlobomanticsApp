package com.example.alexr.taskmanager.Services;

import com.example.alexr.taskmanager.Models.Idea;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IdeaService {
    @GET("ideas")
    Call<List<Idea>> getIdeas();

    @GET("ideas/{id}")
    Call<Idea> getIdea(@Path("id") int taskId);

    @POST("ideas")
    Call<Idea> createIdea(@Body Idea task);

    @PUT("ideas")
    Call<Idea> updateIdea(@Body Idea task);

    @DELETE("ideas/{id}")
    Call<Idea> deleteIdea(@Path("id") int taskId);
}