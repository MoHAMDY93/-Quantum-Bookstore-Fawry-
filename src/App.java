public class App {
    public static void main(String[] args) throws Exception {
        InventoryManager inventory = new InventoryManager();
        BookstoreService service = new BookstoreService(inventory);
        
        PaperBook paper = new PaperBook("ISBN001", "Java Fundamentals", "Alice Smith", 2015, 100.0, 10);
        EBook ebook = new EBook("ISBN002", "Learn Python", "Bob Lee", 2020, 50.0, "PDF");
        ShowcaseBook showcase = new ShowcaseBook("ISBN003", "Rare Manuscript", "Dr. John", 1950, 1000.0);

        inventory.addBook(paper);
        inventory.addBook(ebook);
        inventory.addBook(showcase);

        try {
            service.buyBook("ISBN001", 2, "user@example.com", "123 Main Street");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            service.buyBook("ISBN002", 1, "user@example.com", null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            service.buyBook("ISBN003", 1, "user@example.com", "321 Broadway");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            service.buyBook("ISBN999", 1, "user@example.com", "Nowhere");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Quantum book store: Removing outdated books...");
        inventory.removeOutdatedBooks(10);
    }
}
