package bibliotecaApp2;

public class LogIn implements MenuItem {
    UserInterface userInterface;
    Librarian librarian;

    LogIn(UserInterface userInterface, Librarian librarian) {
        this.userInterface = userInterface;
        this.librarian = librarian;
    }

    @Override
    public void invoke() {
        if (librarian.currentUser() != null) {
            userInterface.giveMessageSomeoneIsLoggedIn();
            return;
        } else {
            String libraryNumber = userInterface.getLibraryUserNumber();
            String password = userInterface.getUserPassword();
            librarian.logIn(libraryNumber, password);
        }
    }

    @Override
    public boolean returnToInterface() {
        return true;
    }
}
