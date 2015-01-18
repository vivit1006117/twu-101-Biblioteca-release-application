package bibliotecaApp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Librarian {
    UserInterface userInterface;
    private List<Customer> customers;

    Librarian(UserInterface userInterface, Customer... customers) {
        this.customers = Arrays.asList(customers);
        this.userInterface = userInterface;
    }


    public void logIn(String libraryNumber, String password) {
        for (Customer customer : customers) {
            if (customer.getLoginLibraryNumber().equals(libraryNumber) && customer.getPassword().equals(password)) {
                userInterface.giveSuccessfulLoginMessage();
                customer.changeToLogged(true);
                return;
            }
        }
        userInterface.giveUnsuccessfulLoginMessage();
    }

    public Customer currentUser() {
        for (Customer customer : customers) {
            if (customer.isLoggedIn()) {
                return customer;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        currentUser().addBook(book);
    }

    public void addMovie(Movie movie) {
        currentUser().addMovie(movie);
    }

    public void removeBook(Book book) {
        int i=findBookInCustomer(book);
        if (i != -1) {
            currentUser().removeBook(i);
        }
    }

    public int findBookInCustomer(Book book) {
        int i=0;
        ArrayList<Book> books = currentUser().getBooks();
        for (Book book1 : books) {
            i++;
            if (book1.equals(book)) {
                return i-1;
            }
        }
        if(books.size()<i) {
            return -1;
        }
        return 0;
    }

    public void displayDetails() {
        for (Customer customer : customers) {
            if (customer.isLoggedIn()) {
                userInterface.print("Name: " + customer.getName());
                userInterface.print("e-mail: " + customer.getE_mail());
                userInterface.print("Phone number: " + String.valueOf((customer.getPhone_number())));
            }
        }
    }

}
