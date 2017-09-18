package repoter.hamza.alif.popularmovies.Adapters;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import repoter.hamza.alif.popularmovies.R;
import repoter.hamza.alif.popularmovies.Ui.MovieDetailsFragment;
import repoter.hamza.alif.popularmovies.model.Movie;


public class MovieVH extends RecyclerView.ViewHolder {

    ImageView posterIMG;

    public MovieVH(View itemView) {
        super(itemView);
        posterIMG = itemView.findViewById(R.id.posterIMG);
    }

    public void setMovieView(final Movie movieView) {
        if (posterIMG != null) {
            Glide.with(itemView.getContext())
                    .load("http://image.tmdb.org/t/p/w185/" + movieView.getPhoto())
                    .asBitmap().centerCrop().into(posterIMG);

        posterIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity) itemView.getContext())
                        .getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, MovieDetailsFragment.newInstance(movieView))
                        .addToBackStack(null).commit();
                }
            });
        }
    }
}




