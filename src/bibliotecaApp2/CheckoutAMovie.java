package bibliotecaApp2;

/**
 * Created by kvivek on 15/01/15.
 */
public class CheckoutAMovie implements MenuItem {
    private UserInterface userInterface;
    private Library library;
    private Librarian librarian;
    private LogIn loggedIn = new LogIn(userInterface, librarian);

    public CheckoutAMovie(Librarian librarian, Library library, UserInterface userInterface) {
        this.librarian = librarian;
        this.library = library;
        this.userInterface = userInterface;
    }

    @Override
    public void invoke() {
        if (librarian.currentUser() != null) {
            String movieName = userInterface.getName();
            if (library.availabilityOfMovie(movieName)) {
                library.checkOutMovie(movieName);
                librarian.addMovie(library.findMovie(movieName));
                userInterface.giveSuccessfulMovieCheckoutMessage();
            } else {
                userInterface.giveUnsuccessfulMovieCheckoutMessage();
            }
        } else {
            userInterface.giveMassageToLogIn();
            new LogIn(userInterface, librarian).invoke();
            if (librarian.currentUser() != null) {
                invoke();
            }
        }
    }

    @Override
    public boolean returnToInterface() {
        return true;
    }
}
