package com.example.omdb_practice.api;

import com.example.omdb_practice.models.Movies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/")
    Call<Movies> getMovies (
            @Query("i") String imdbID,
            @Query("apikey") String apikey);


}
