package repoter.hamza.alif.popularmovies.Service;


import repoter.hamza.alif.popularmovies.response.MoviesResponce;
import repoter.hamza.alif.popularmovies.response.ReviewsResponce;
import repoter.hamza.alif.popularmovies.response.TopRatedResponce;
import repoter.hamza.alif.popularmovies.response.TraliersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceInterface {
    @GET("popular?api_key=" + Constant.API_KEY)
    Call<MoviesResponce> getMovies();

    @GET("{id}/videos?api_key="+Constant.API_KEY)
    Call<TraliersResponse> getTrailerses(@Path("id") int id);

    @GET("{id}/reviews?api_key="+Constant.API_KEY)
    Call<ReviewsResponce> getReviews(@Path("id") int id);

    @GET("top_rated?api_key=" + Constant.API_KEY)
    Call<TopRatedResponce> getRatedMovies();
}
