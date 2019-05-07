package com.example.omdb_practice;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.omdb_practice.api.ApiInterface;
import com.example.omdb_practice.models.Movies;
import com.example.omdb_practice.models.Rating;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final String BASE_URL = "http://www.omdbapi.com/";

    ApiInterface apiInterface;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.results);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiInterface = retrofit.create(ApiInterface.class);

        getMovies();
    }

    public void getMovies() {

        Call<Movies> call = apiInterface.getMovies("tt4154796", "8eeefbee");

        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                /*checks if response is not successful */
                if (!response.isSuccessful()) {
                    tvResult.setText(" " + response.body());
                    Log.d(TAG, "onResponse: " + response.body());
                }

                /* gets the data from the web server then display */
                Movies movies1 = response.body();
                String content = "";
                content += "Title: " + movies1.getTitle() + "\n";
                content += "Year: " + movies1.getYear() + "\n";
                content += "Rated: " + movies1.getRated() + "\n";
                content += "Released: " + movies1.getReleased() + "\n";
                content += "Runtime: " + movies1.getRuntime() + "\n";
                content += "Genre: " + movies1.getGenre() + "\n";
                content += "Director: " + movies1.getDirector() + "\n";
                content += "Writer: " + movies1.getWriter() + "\n";
                content += "Actors: " + movies1.getActors() + "\n";
                content += "Plot: " + movies1.getPlot() + "\n";
                content += "Language: " + movies1.getLanguage() + "\n";
                content += "Country: " + movies1.getCountry() + "\n";
                content += "Awards: " + movies1.getAwards() + "\n";
                content += "Poster: " + movies1.getPoster() + "\n";
                content += "Metascore: " + movies1.getMetascore() + "\n";
                content += "imdbRating: " + movies1.getImdbRating() + "\n";
                content += "imdbVotes: " + movies1.getImdbVotes() + "\n";
                content += "imdbID: " + movies1.getImdbID() + "\n";
                content += "Type: " + movies1.getType() + "\n";
                content += "DVD: " + movies1.getDvd() + "\n";
                content += "BoxOffice: " + movies1.getBoxoffice() + "\n";
                content += "Production: " + movies1.getProd() + "\n";
                content += "Website: " + movies1.getWeb() + "\n";
                content += "Response: " + movies1.getResponse() + "\n";

                tvResult.append(content);

            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

                Log.d(TAG, "failed....: " + t.getMessage());
            }
        });


    }

}

