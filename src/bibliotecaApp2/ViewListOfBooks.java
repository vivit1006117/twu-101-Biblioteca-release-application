package bibliotecaApp2;

import java.util.List;

/**
 * Created by kvivek on 15/01/15.
 */
public class ViewListOfBooks implements MenuItem {

    private Library library;
    private UserInterface userInterface;

    ViewListOfBooks(UserInterface userInterface, Library library) {
        this.userInterface = userInterface;
        this.library = library;
    }

    @Override
    public void invoke() {
        List<Book> books;
        userInterface.printDetailsOfBooksToBeDisplayed();
        books = library.getBookListFromLibrary();
        for (Book book : books) {
            if (book.isAvailable()) {
                userInterface.displayListOfBooks(book);
            }
        }
    }

    @Override
    public boolean returnToInterface() {
        return true;
    }
}
