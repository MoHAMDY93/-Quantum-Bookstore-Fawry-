public class PaperBook extends Book implements Purchasable , Deliverable{
    private int stock;
    public PaperBook(String isbn, String title, String author, int publishedYear, double price, int stock) {
        super(isbn, title, author, publishedYear, price);
        this.stock = stock;
    }
    public int getStock() {
        return stock;
    }
    public void decreaseStock(int quantity) {
        if (stock < quantity) {
            throw new IllegalArgumentException("Not enough stock for ISBN " + isbn);
        }
        stock -= quantity;
    }
    @Override
    public boolean isPurchasable() {
        return stock > 0;
    }
    @Override
    public void deliver(String email, String address) {
        System.out.println("Shipping paper book '" + title + "' to address: " + address);
    }
}
