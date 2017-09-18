package repoter.hamza.alif.popularmovies.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import repoter.hamza.alif.popularmovies.R;
import repoter.hamza.alif.popularmovies.model.Movie;


public class MoviesAdapter extends RecyclerView.Adapter<MovieVH> {

        private List<Movie> movies;
        private int rowLayout;

    public MoviesAdapter(List<Movie> movies, int rowLayout) {
        this.movies = movies;
        this.rowLayout = rowLayout;
    }

    @Override
    public MovieVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycle_row_item, parent, false);
        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(MovieVH holder,  final int position) {
          holder.setMovieView(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
