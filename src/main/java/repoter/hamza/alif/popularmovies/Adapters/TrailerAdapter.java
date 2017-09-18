package repoter.hamza.alif.popularmovies.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import repoter.hamza.alif.popularmovies.R;
import repoter.hamza.alif.popularmovies.model.Movie;
import repoter.hamza.alif.popularmovies.model.Trailers;

public class TrailerAdapter extends ArrayAdapter<Trailers> {
    static int resource_layout = R.layout.trailer_row_view;
    ArrayList<Trailers> trailers;
    Activity activity;

    public TrailerAdapter(Activity activity, ArrayList<Trailers> trailers) {
        super(activity, resource_layout, trailers);
        this.trailers = trailers;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource_layout, parent, false);
        TextView trailerNameTV = rowView.findViewById(R.id.trailerName);
                      if(trailers.get(position) != null) {
            trailerNameTV.setText(trailers.get(position).getName());
            }
        return rowView;
    }

    @Override
    public int getCount() {
        if(trailers != null){
            return trailers.size() < 3 ? trailers.size(): 3;
        }
        return 0;
    }
    }



