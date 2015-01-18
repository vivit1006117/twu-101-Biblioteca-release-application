package bibliotecaApp2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kvivek on 15/01/15.
 */
public class Library {
    private List<Book> books;
    private List<Movie> movies;

    public Library(Book[] books, Movie[] movies) {
        this.books = Arrays.asList(books);
        this.movies = Arrays.asList(movies);

    }

    public List<Book> getBookListFromLibrary() {
        return books;
    }

    public Boolean availabilityOfBook(String bookName) {
        return findBook(bookName).isAvailable();
    }

    public Book findBook(String bookName) {
        for (Book book : books) {
            if (book.getTitle().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public Movie findMovie(String movieName) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(movieName)) {
                return movie;
            }
        }
        return new Movie();
    }

    public boolean availabilityOfMovie(String movieName) {
        return findMovie(movieName).isAvailable();
    }

    public void checkOutMovie(String movieName) {
        findMovie(movieName).setAvailability(false);
    }

    public List<Movie> getMovieListFromLibrary() {
        return movies;
    }

    public void checkOutBook(Book book) {
        book.changeAvailability(false);
    }
}
