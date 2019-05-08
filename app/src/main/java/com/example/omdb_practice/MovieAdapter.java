package com.example.omdb_practice;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private static final String TAG = "MovieAdapter";
    private ArrayList<MovieItem> mMovieItems;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mTextView1 = itemView.findViewById(R.id.textview_1);
            mTextView2 = itemView.findViewById(R.id.textview_2);
        }
    }

    public MovieAdapter(ArrayList<MovieItem> movieItems) {
        mMovieItems = movieItems;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        MovieViewHolder mvh = new MovieViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieItem currentItem = mMovieItems.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getmTextView1());
        holder.mTextView2.setText(currentItem.getmTextView2());
        Log.d(TAG, "binded.... ");

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: size......." + mMovieItems.size());
        return mMovieItems.size();
    }


}
