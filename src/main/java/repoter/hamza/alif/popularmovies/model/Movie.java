package repoter.hamza.alif.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {

    private long id;
    @SerializedName("poster_path")
    private String photo;
    private String title;
    @SerializedName("vote_average")
    private double rate;
    @SerializedName("release_date")
    private String releaseDate;

    private ArrayList<Trailers> trailers;
    private ArrayList<Review> reviews;


    public Movie(long id, String photo, String title, double rate, String releaseDate) {
        this.id = id;
        this.photo = photo;
        this.title = title;
        this.rate = rate;
        this.releaseDate = releaseDate;

    }

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public ArrayList<Trailers> getTrailers() {
        return trailers;
    }

    public void setTrailers(ArrayList<Trailers> trailers) {
        this.trailers = trailers;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                ", title='" + title + '\'' +
                ", rate=" + rate +
                +
                '}';
}
}

