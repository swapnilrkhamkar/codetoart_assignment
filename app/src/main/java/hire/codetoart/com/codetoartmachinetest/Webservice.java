package hire.codetoart.com.codetoartmachinetest;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by linux on 2/9/17.
 */

public class Webservice {

    private Context context;
    private Handler handler;
    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private RequestQueue requestQueue;

    private static final String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=b7cd3340a794e5a2f35e3abb820b497f";
    private static final String POSTER_PATH = "http://image.tmdb.org/t/p/w300";
    private static final String BACKDROP_PATH = "http://image.tmdb.org/t/p/w300";

    public Webservice(Context context,Handler handler) {
        this.context = context;
        this.handler = handler;
    }

    public ArrayList<Movie> getMovieArrayList(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String title = jsonObject.getString("title");
                                String image  = jsonObject.getString("poster_path");
                                String releaseDate = jsonObject.getString("release_date");
                                String adult = jsonObject.getString("adult");
                                String overView = jsonObject.getString("overview");
                                String popularity = jsonObject.getString("popularity");
                                String backdrop_path = jsonObject.getString("backdrop_path");
                                Log.d("test", "size : " + movieArrayList.size());

                                Movie movie = new Movie();

                                movie.setTitle(title);
                                movie.setImage(POSTER_PATH + image);
                                movie.setReleaseDate(releaseDate);
                                movie.setAdult(adult);
                                movie.setOverView(overView);
                                movie.setPopularity(popularity);
                                movie.setBackdrop_path(BACKDROP_PATH + backdrop_path);

                                movieArrayList.add(movie);

                            }

                            Message message = new Message();
                            message.obj = movieArrayList;
                            handler.sendMessage(message);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        requestQueue.add(jsonObjectRequest);
        return movieArrayList;
    }

}
