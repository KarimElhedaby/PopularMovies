package repoter.hamza.alif.popularmovies.Ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import repoter.hamza.alif.popularmovies.Adapters.NonScrollListView;
import repoter.hamza.alif.popularmovies.Adapters.ReviewAdapter;
import repoter.hamza.alif.popularmovies.Adapters.TrailerAdapter;
import repoter.hamza.alif.popularmovies.R;

import repoter.hamza.alif.popularmovies.Service.AppInstance;
import repoter.hamza.alif.popularmovies.model.Movie;
import repoter.hamza.alif.popularmovies.model.Review;
import repoter.hamza.alif.popularmovies.model.Trailers;
import repoter.hamza.alif.popularmovies.response.ReviewsResponce;
import repoter.hamza.alif.popularmovies.response.TraliersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieDetailsFragment extends Fragment {

    @BindView(R.id.titleTV)
    TextView movieTitleTV;
    @BindView(R.id.imageViewf)
    ImageView movieImage;
    @BindView(R.id.ratingf)
    TextView rateMovie;
    @BindView(R.id.releaseTextf)
    TextView movieDate;

    @BindView(R.id.trailersLV)
    NonScrollListView trailerLV;
    @BindView(R.id.reviewLV)
    NonScrollListView reviewLV;

    ReviewAdapter reviewAdapter;
    TrailerAdapter trailerAdapter;


    Movie movie;
    static final String MOVIE_KEY = "movie";

    public static MovieDetailsFragment newInstance(Movie movie) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MOVIE_KEY, movie);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setView();
        setReviews();
        setTrailers();

    }

    private void setView() {

        if (movie == null) {
            movie = (Movie) getArguments().getSerializable(MOVIE_KEY);
        }
        ImageView movieImage = getActivity().findViewById(R.id.imageViewf);
        movieTitleTV.setText(movie.getTitle());
        movieDate.setText(movie.getReleaseDate());

        rateMovie.setText(String.valueOf(movie.getRate()));
        Glide.with(getActivity())
                .load("http://image.tmdb.org/t/p/w185/" + movie.getPhoto())
                .asBitmap().centerCrop().into(movieImage);


    }
    private void setReviews(){

        AppInstance.apiServiceInterface.getReviews((int) movie.getId()).enqueue(new
                                                Callback<ReviewsResponce>() {
            @Override
            public void onResponse(Call<ReviewsResponce> call, Response<ReviewsResponce> response) {
                if (response.isSuccessful()) {
                    ArrayList<Review> reviews = response.body().getReviews();
                    movie.setReviews(reviews);
                    reviewAdapter = new ReviewAdapter(getActivity(), reviews);
                    reviewLV.setAdapter(reviewAdapter);
                }
            }

            @Override
            public void onFailure(Call<ReviewsResponce> call, Throwable t) {}

        });
    }

    private void setTrailers (){
        AppInstance.apiServiceInterface.getTrailerses((int) movie.getId()).enqueue(new
                                                 Callback<TraliersResponse>() {
         @Override
         public void onResponse(Call<TraliersResponse> call, Response<TraliersResponse> response) {
             if (response.isSuccessful()) {
                 final ArrayList<Trailers> trailerses = response.body().getTrailerses();
                 trailerAdapter = new TrailerAdapter(getActivity(), trailerses);
                 movie.setTrailers(trailerses);
                 trailerLV.setAdapter(trailerAdapter);
                 trailerLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                         Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                 "https://www.youtube.com/watch?v=" +trailerses.
                                         get(i).getKey()));
                                    startActivity(browserIntent);
                     }
                 });
             }
         }

         @Override
         public void onFailure(Call<TraliersResponse> call, Throwable t) {}
     });
    }
}
