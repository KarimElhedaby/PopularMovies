package repoter.hamza.alif.popularmovies.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import repoter.hamza.alif.popularmovies.model.Review;
/**
 * Created by karim pc on 9/11/2017.
 */

public class ReviewsResponce {
    @SerializedName("results")
    ArrayList<Review> reviews;

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
