package bibliotecaApp2;

import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {


    public static void print(String name) {
        System.out.println(name);
    }

    public String getName() {
        System.out.println("Enter the of item you want to checkout");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void welcomeMess() {
        System.out.println("Welcome to Biblioteca");
    }

    public void showMenuOptions() {
        System.out.println("Option to be selected are");
        System.out.println("1. View list of books");
        System.out.println("2. View list of movies");
        System.out.println("3. Checkout book");
        System.out.println("4. Checkout Movie");
        System.out.println("5. Return");
        System.out.println("6. Logged In");
        System.out.println("7. Show user Details");
        System.out.println("8. Quit");
    }

    public int askForOption() {
        System.out.println("Give the option to be selected");
        return Integer.parseInt(getInputFromUser());
    }

    public int performTheItemSelected(HashMap<Integer, MenuItem> menus, int option) {
        if (menus.size() < option) {
            System.out.println("Wrong option selected");
            return 1;
        }
        menus.get(option).invoke();
        return option;
    }

    public String getLibraryUserNumber() {
        System.out.println("Enter your Library User number");
        return getInputFromUser();
    }

    public String getUserPassword() {
        System.out.println("Enter your user password");
        return getInputFromUser();
    }

    public String getInputFromUser() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void displayListOfBooks(Book book) {
        System.out.println(String.format("%30s %30s %30s", book.getTitle(), book.getAuthor(), book.getYear()));
    }

    public void printDetailsOfBooksToBeDisplayed() {
        System.out.println("Title    \t\t  Author    \t\t   Year");
    }

    public void giveMassageToLogIn() {
        System.out.println("Please Log In");

    }

    public void displayListOfMovies(Movie movie) {
        System.out.println(String.format("%-30s %-30d %-30s %3d", movie.getTitle(), movie.getYear(), movie.getDirector(), movie.getRating()));
    }

    public void printDetailsOfMovieToBeDisplayed() {
        System.out.println("Name of movies    \t\t      Year   \t\t\t\t      Director     \t\t\t    Rating\n");
    }

    public void giveSuccessfulBookCheckoutMessage() {
        System.out.println("Thank you! Enjoy the book");
    }

    public void giveUnsuccessfulBookCheckoutMessage() {
        System.out.println("That book is not available");
    }

    public void giveSuccessfulMovieCheckoutMessage() {
        System.out.println("Thank you! Enjoy the movie");
    }

    public void giveUnsuccessfulMovieCheckoutMessage() {
        System.out.println("That movie is not available");
    }

    public void giveSuccessfulLoginMessage() {
        System.out.println("you are logged in");
    }

    public void giveUnsuccessfulLoginMessage() {
        System.out.println("your logged in credential's are wrong");
    }

    public void giveSuccessfulBookReturnMessage() {
        System.out.println("Thank you for returning the book");
    }

    public void giveUnsuccessfulBookReturnMessage() {
        System.out.println("That is not a valid book to return.");
    }

    public void giveMessageSomeoneIsLoggedIn() {
        System.out.println("Some one is already logged in!!");
    }
}
