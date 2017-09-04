package hire.codetoart.com.codetoartmachinetest;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by linux on 2/9/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Movie> movieArrayList;
    private Movie movie;
    Webservice webservice;

    public RecyclerAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {

        movie = movieArrayList.get(position);

        Uri uri = Uri.parse(movie.getImage());
        Picasso.with(context).load(uri).into(holder.movieImage);

        holder.movieName.setText(movie.getTitle() + "\n");
        holder.movieReleaseDate.setText(movie.getReleaseDate() + "\n");

        if (!movie.getAdult().equals("false")){

            holder.movieAdult.setText("A");
        }
        else {

            holder.movieAdult.setText("U/A");

        }

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView movieImage;
        private TextView movieReleaseDate,movieName,movieAdult;

        public MyViewHolder(View itemView) {
            super(itemView);

            movieImage = (ImageView) itemView.findViewById(R.id.movieImage);
            movieReleaseDate = (TextView) itemView.findViewById(R.id.movieReleaseDate);
            movieName = (TextView) itemView.findViewById(R.id.movieName);
            movieAdult = (TextView) itemView.findViewById(R.id.movieAdult);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();

            movie = movieArrayList.get(getAdapterPosition());
            movieDetailsFragment.setMovie(movie);

            FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container,movieDetailsFragment,"Movie");
            fragmentTransaction.addToBackStack("Movie");
            fragmentTransaction.commit();

        }
    }
}
