package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/popular")
    Call<Movie> getMovies(@Query("api_key") String apiKey);

    @POST("movie/popular")
    Call<Movie> PutMovies(@Query("api_key") String apiKey);


    @DELETE("movie/popular/{title}")
    Call<Void> deleteMovie( @Path("title") String title, @Query("api_key") String apiKey);

}
