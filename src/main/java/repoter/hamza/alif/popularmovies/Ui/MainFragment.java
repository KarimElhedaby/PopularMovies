package repoter.hamza.alif.popularmovies.Ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import repoter.hamza.alif.popularmovies.Adapters.MoviesAdapter;
import repoter.hamza.alif.popularmovies.R;
import repoter.hamza.alif.popularmovies.Service.AppInstance;
import repoter.hamza.alif.popularmovies.model.Movie;
import repoter.hamza.alif.popularmovies.response.MoviesResponce;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {

    RecyclerView recyclerView;



    public MainFragment() {

    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerView=getActivity().findViewById(R.id.recyclerV);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        AppInstance.apiServiceInterface.getMovies().enqueue(new Callback<MoviesResponce>() {
            @Override
            public void onResponse(Call<MoviesResponce> call, Response<MoviesResponce> response) {
                ArrayList<Movie> movies = response.body().getMovies();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.recycle_row_item));
            }

            @Override
            public void onFailure(Call<MoviesResponce> call, Throwable t) {}
        });
    }

}
