package repoter.hamza.alif.popularmovies.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import repoter.hamza.alif.popularmovies.R;
import repoter.hamza.alif.popularmovies.model.Review;

public class ReviewAdapter  extends ArrayAdapter<Review>  {

    ArrayList<Review> reviews;
    static int resource = R.layout.review_row;
    Activity activity;

    public ReviewAdapter(Activity activity, ArrayList<Review> reviews) {
        super(activity, resource, reviews);
        this.reviews = reviews;
        this.activity = activity;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);
        TextView authorTV =  rowView.findViewById(R.id.authorTV);
        TextView contentTV =  rowView.findViewById(R.id.contentreviewTV);
        authorTV.setText(reviews.get(position).getAuthor());
        contentTV.setText(reviews.get(position).getContent());
        return rowView;
    }

    @Override
    public int getCount() {
        if(reviews != null){
            return reviews.size() < 2 ? reviews.size(): 2;
        }
        return 0;
    }
    }

