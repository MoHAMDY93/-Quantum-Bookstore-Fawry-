public class BookstoreService {
    private final InventoryManager inventory;
    public BookstoreService(InventoryManager inventory) {
        this.inventory = inventory;
    }
    public double buyBook(String isbn, int quantity, String email, String address) {
        if (!inventory.contains(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
        }
        Book book = inventory.getBook(isbn);
        if (!(book instanceof Purchasable) || !((Purchasable) book).isPurchasable()) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " is not for sale.");
        }
        if (book instanceof PaperBook) {
            ((PaperBook) book).decreaseStock(quantity);
        }
        if (book instanceof Deliverable) {
            ((Deliverable) book).deliver(email, address);
        }
        double totalCost = book.getPrice() * quantity;
        System.out.println("Book with ISBN " + isbn + " bought. Total paid: " + totalCost);
        return totalCost;
    }

}
