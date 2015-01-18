package bibliotecaApp2;

/**
 * Created by kvivek on 16/01/15.
 */
public class ShowCustomerDetails implements MenuItem {

    UserInterface userInterface;
    private Librarian librarian;

    public ShowCustomerDetails(Librarian librarian, UserInterface userInterface) {
        this.librarian = librarian;
        this.userInterface = userInterface;
    }

    @Override
    public void invoke() {
        if (librarian.currentUser() != null) {
            librarian.displayDetails();
        } else {
            userInterface.giveMassageToLogIn();
        }
    }

    @Override
    public boolean returnToInterface() {
        return true;
    }
}
