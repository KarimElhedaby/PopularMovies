package repoter.hamza.alif.popularmovies.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import repoter.hamza.alif.popularmovies.model.Trailers;

public class TraliersResponse  {
    @SerializedName("results")
    private ArrayList<Trailers> trailerses ;
    public ArrayList<Trailers> getTrailerses() {
        return trailerses;
    }
}
