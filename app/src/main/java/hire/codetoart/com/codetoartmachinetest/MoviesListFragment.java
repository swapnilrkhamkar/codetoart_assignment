package hire.codetoart.com.codetoartmachinetest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by linux on 2/9/17.
 */

public class MoviesListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Movie> moviesArrayList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_movies, null);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Webservice webservice = new Webservice(getContext(),new DataHandler());
        moviesArrayList = webservice.getMovieArrayList();

        return view;
    }

    private class DataHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            moviesArrayList = (ArrayList<Movie>) msg.obj;
            recyclerAdapter = new RecyclerAdapter(getContext(),moviesArrayList);
            recyclerView.setAdapter(recyclerAdapter);
            recyclerAdapter.notifyDataSetChanged();
        }
    }
}
