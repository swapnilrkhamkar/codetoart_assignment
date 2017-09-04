package hire.codetoart.com.codetoartmachinetest;

import java.io.Serializable;

/**
 * Created by linux on 2/9/17.
 */

public class Movie implements Serializable {

    private String title;
    private String image;
    private String releaseDate;
    private String adult;
    private String overView;
    private String popularity;
    private String backdrop_path;

    public Movie(String title, String image, String releaseDate, String adult, String overView, String popularity, String backdrop_path) {
        this.title = title;
        this.image = image;
        this.releaseDate = releaseDate;
        this.adult = adult;
        this.overView = overView;
        this.popularity = popularity;
        this.backdrop_path = backdrop_path;
    }

    public Movie(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", adult='" + adult + '\'' +
                ", overView='" + overView + '\'' +
                ", popularity='" + popularity + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                '}';
    }
}
