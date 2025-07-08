public class EBook extends Book implements Purchasable , Deliverable{
    private String fileType;
    public EBook(String isbn, String title, String author, int publishedYear, double price, String fileType) {
        super(isbn, title, author, publishedYear, price);
        this.fileType = fileType;
    }
    public String getFileType() {
        return fileType;
    }
    @Override
    public boolean isPurchasable() {
        return true;
    }
    @Override
    public void deliver(String email, String address) {
        System.out.println("Sending eBook '" + title + "' (" + fileType + ") to email: " + email);
    }
}
