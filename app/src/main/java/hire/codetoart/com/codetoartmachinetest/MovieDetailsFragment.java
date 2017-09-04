package hire.codetoart.com.codetoartmachinetest;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by linux on 2/9/17.
 */

public class MovieDetailsFragment extends Fragment {

    private ImageView movieImage;
    private TextView movieName,movieOverview,moviePopularity;
    private Button btnView;
    private Movie movie = new Movie();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details_movie, null);

        movieImage = (ImageView) view.findViewById(R.id.movieImage);
        movieName = (TextView) view.findViewById(R.id.movieName);
        movieOverview = (TextView) view.findViewById(R.id.movieOverview);
        moviePopularity = (TextView) view.findViewById(R.id.moviePopularity);
        btnView = (Button) view.findViewById(R.id.btnView);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NameFragment nameFragment = new NameFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container,nameFragment,"Movie");
                fragmentTransaction.addToBackStack("Movie");
                fragmentTransaction.commit();

            }
        });

        Uri uri = Uri.parse(movie.getBackdrop_path());
        Picasso.with(getContext()).load(uri).into(movieImage);

        movieName.setText(movie.getTitle());
        moviePopularity.setText(movie.getOverView());
        movieOverview.setText(movie.getPopularity());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
