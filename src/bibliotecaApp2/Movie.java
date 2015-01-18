package bibliotecaApp2;

/**
 * Created by kvivek on 15/01/15.
 */
public class Movie {
    private String title;
    private int year;
    private String director;
    private int rating;
    private boolean available;

    Movie(String title, int year, String director, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.available = true;
    }

    public Movie() {
        this.available = false;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public void setAvailability(boolean value) {
        available = value;
    }

    public boolean isAvailable() {
        return available;
    }
}
