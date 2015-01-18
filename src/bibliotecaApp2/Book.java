package bibliotecaApp2;

/**
 * Created by kvivek on 15/01/15.
 */
public class Book {

    private boolean available;
    private String title;
    private String author;
    private String year;

    Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public Book() {
        this.title = ".";
        this.available = false;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }


    public void changeAvailability(boolean value) {
        this.available = value;
    }
}
