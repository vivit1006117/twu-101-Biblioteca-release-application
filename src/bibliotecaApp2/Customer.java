package bibliotecaApp2;

import java.util.ArrayList;

/**
 * Created by kvivek on 16/01/15.
 */
public class Customer {
    private String loginLibraryNumber;
    private String password;
    private String name;
    private String e_mail;
    private String phone_number;
    private boolean loggedIn;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();


    Customer(String loginLibraryNumber, String password, String name, String e_mail, String phone_number) {
        this.loginLibraryNumber = loginLibraryNumber;
        this.password = password;
        this.name = name;
        this.e_mail = e_mail;
        this.phone_number = phone_number;
        loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getPassword() {
        return password;
    }

    public String getLoginLibraryNumber() {
        return loginLibraryNumber;
    }

    public void changeToLogged(boolean value) {
        this.loggedIn = value;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeBook(int index) {
        books.remove(index);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

}
