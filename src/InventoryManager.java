import java.util.*;

public class InventoryManager {
    private Map<String, Book> inventory = new HashMap<>();
    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
        System.out.println("Added book with ISBN " + book.getISBN());
    }
    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }
    public Book removeBook(String isbn) {
        Book removed = inventory.remove(isbn);
        if (removed != null) {
            System.out.println("Removed book with ISBN " + isbn);
        }
        return removed;
    }
    public List<Book> removeOutdatedBooks(int olderThanYears) {
        List<Book> removedBooks = new ArrayList<>();
        List<String> toRemove = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Map.Entry<String, Book> entry : inventory.entrySet()) {
            Book book = entry.getValue();
            if (currentYear - book.getPublishedYear() > olderThanYears) {
                removedBooks.add(book);
                toRemove.add(entry.getKey());
            }
        }
        for (String isbn : toRemove) {
            inventory.remove(isbn);
            System.out.println("Removed outdated book with ISBN " + isbn);
        }
        return removedBooks;
    }
    public boolean contains(String isbn) {
        return inventory.containsKey(isbn);
    }
    public Collection<Book> getAllBooks() {
        return inventory.values();
    }
}
