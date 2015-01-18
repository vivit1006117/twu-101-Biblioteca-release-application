package bibliotecaApp2;

import java.util.List;

/**
 * Created by kvivek on 15/01/15.
 */
public class ViewListOfMovies implements MenuItem {
    private Library library;
    private UserInterface userInterface;

    ViewListOfMovies(UserInterface userInterface, Library library) {
        this.userInterface = userInterface;
        this.library = library;
    }

    @Override
    public void invoke() {
        List<Movie> movies;
        userInterface.printDetailsOfMovieToBeDisplayed();
        movies = library.getMovieListFromLibrary();
        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                userInterface.displayListOfMovies(movie);
            }
        }
    }

    @Override
    public boolean returnToInterface() {
        return true;
    }
}
