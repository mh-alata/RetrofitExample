package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Movie> movieList;
    private final static String API_KEY = "030b12efc22a46765380f30ee2bb8708";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        getMovies();
        deleteMovies();






    }

    public void getMovies(){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Movie> call = apiService.getMovies(API_KEY);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                List<Movie> movies = response.body().getResults();
                Log.d("Success : ", "Number of movies received: " + movies);


                movieList= response.body().getResults();

                recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(), movieList, R.layout.recycler_layout));


            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.e("Error", t.toString());

            }
        });
    }

    public void deleteMovies(){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Void> call = apiService.deleteMovie( "The Batman", API_KEY);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Log.d("Success : ", "Delete: " + response.code());



            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Error Delete", t.toString());

            }
        });

    }
}