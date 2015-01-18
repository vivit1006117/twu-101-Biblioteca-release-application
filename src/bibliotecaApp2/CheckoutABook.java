package bibliotecaApp2;

public class CheckoutABook implements MenuItem {
    private UserInterface userInterface;
    private Library library;
    private Librarian librarian;

    public CheckoutABook(Librarian librarian, Library library, UserInterface userInterface) {
        this.librarian = librarian;
        this.library = library;
        this.userInterface = userInterface;
    }


    @Override
    public void invoke() {
        if (librarian.currentUser() != null) {
            String bookName = userInterface.getName();
            Book book = library.findBook(bookName);
            if (book != null) {
                if(book.isAvailable()) {
                    library.checkOutBook(book);
                    librarian.addBook(book);
                    librarian.addBook(book);
                    userInterface.giveSuccessfulBookCheckoutMessage();
                }else{
                    userInterface.giveUnsuccessfulBookCheckoutMessage();
                }
            } else {
                userInterface.giveUnsuccessfulBookCheckoutMessage();
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
