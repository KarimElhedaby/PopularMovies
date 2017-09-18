package repoter.hamza.alif.popularmovies.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import repoter.hamza.alif.popularmovies.model.Movie;


public class MoviesResponce {
    @SerializedName("results")
private ArrayList<Movie> movies ;
    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
