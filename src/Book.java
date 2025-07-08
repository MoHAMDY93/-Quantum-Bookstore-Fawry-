public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int publishedYear;
    protected double price;

    public Book(String isbn, String title, String author, int publishedYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }
    public String getISBN() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublishedYear() {
        return publishedYear;
    }
    public double getPrice() {
        return price;
    }
}
