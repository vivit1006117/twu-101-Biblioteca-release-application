package bibliotecaApp2;

import java.util.HashMap;

public class Launcher {

    public static void main(String args[]) {

        UserInterface userInterface = new UserInterface();

        Movie movies[] = new Movie[]{new Movie("Thor", 2011, "Kenneth Branagh", 7), new Movie("Happy new year", 2014, "Farah khan", 6), new Movie("Next", 2007, " Lee Tamahori", 6), new Movie("PK", 2014, "Rajkumar Hirani", 9), new Movie("Mirchi", 2013, "Koratalla Siva", 8)};

        Book books[] = new Book[]{new Book("Head first java", "O'Reilly", "2010"), new Book("Let us C", "Yaswant Kanetker", "2007"), new Book("Complete reference to C++", "Herb Schildt", "2006"), new Book("Ruby on Rails", "David Heinemeier Hansson", "2004"), new Book("Agile development", "Ken Schwaber", "2009")};

        Customer customers[] = new Customer[]{new Customer("100-6667", "qwerty", "vivek patil", "vivek@thoughtworks.com", "9099900000"), new Customer("111-3456", "asdfgh", "nishkarsh", "nishkarsh@gmail.com", "1092837465"), new Customer("111-2345", "qwertyu", "ram", "ram@yahoo.com", "9876543210")};

        Library library = new Library(books, movies);

        Librarian librarian = new Librarian(userInterface, customers);


        HashMap<Integer, MenuItem> menuItemMap = new HashMap<Integer, MenuItem>();

        menuItemMap.put(1, new ViewListOfBooks(userInterface, library));
        menuItemMap.put(2, new ViewListOfMovies(userInterface, library));
        menuItemMap.put(3, new CheckoutABook(librarian, library, userInterface));
        menuItemMap.put(4, new CheckoutAMovie(librarian, library, userInterface));
        menuItemMap.put(5, new ReturnBook(library, userInterface, librarian));
        menuItemMap.put(6, new LogIn(userInterface, librarian));
        menuItemMap.put(7, new ShowCustomerDetails(librarian, userInterface));
        menuItemMap.put(8, new Quit());

        int option;

        userInterface.welcomeMess();

        do {
            userInterface.showMenuOptions();
            option = userInterface.askForOption();
            option=userInterface.performTheItemSelected(menuItemMap, option);
        } while (menuItemMap.get(option).returnToInterface());
    }
}
