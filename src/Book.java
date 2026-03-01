public class Book {
    private String isbn;
    private String title;
    private int pageCount;
    private double price;

    public String getIsbn() {
        return isbn;
    }
    public int getPageCount() {
        return pageCount;
    }
    public double getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String isbn, String title, int pageCount, double price) {
        this.isbn = isbn;
        this.title = title;
        this.pageCount=pageCount;
        this.price=price;
    }



}
