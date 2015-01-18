package bibliotecaApp2;

public class ReturnBook implements MenuItem {
    private Library library;
    private UserInterface userInterface;
    private Librarian librarian;

    ReturnBook(Library library, UserInterface userInterface, Librarian librarian) {
        this.library = library;
        this.userInterface = userInterface;
        this.librarian = librarian;
    }

    @Override
    public void invoke() {
        if (librarian.currentUser() != null) {
            String bookName = userInterface.getName();
            Book book = library.findBook(bookName);
            if (librarian.findBookInCustomer(book) != -1) {
                if (!library.findBook(bookName).getTitle().equals(".")) {
                    if (!library.availabilityOfBook(bookName)) {
                        book.changeAvailability(true);
                        librarian.removeBook(book);
                        userInterface.giveSuccessfulBookReturnMessage();
                    } else {
                        userInterface.giveUnsuccessfulBookReturnMessage();
                    }
                } else {
                    userInterface.giveUnsuccessfulBookReturnMessage();
                }
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
