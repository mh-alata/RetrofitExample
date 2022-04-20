package com.example.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {

    private Context context;
    private List<Movie> movieList;
    private int rowLayout;

    public RecyclerAdapter(Context context, List<Movie> movieList, int rowLayout) {
        this.context = context;
        this.movieList = movieList;
        this.rowLayout = rowLayout;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyviewHolder holder, int position) {

        holder.textViewMovieName.setText(movieList.get(position).getTitle());



        Glide.with(context).load(movieList.get(position).getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.imgMovie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {

        TextView textViewMovieName;
        LinearLayout moviesLayout;
        ImageView imgMovie;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

          //  moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            textViewMovieName = (TextView) itemView.findViewById(R.id.textViewMovieName);
            imgMovie=(ImageView) itemView.findViewById(R.id.movieImage);

        }
    }
}
