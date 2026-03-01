public class Librarian {
    private long employeeID;
    private String name;
    private int age;
    private Book[] books;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public long getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Book[] getBook() {
        return books;
    }
    public void setBook(Book[] book) {
        this.books= book;
    }


    Librarian(long employeeID, String name, int age) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        books = new Book[5];
    }

    public void addBook(Book book) {
        for (int i = 0; i < 5; i++) {
            if (books[i] == null) {
                books[i] = book;
                System.out.println(book.getIsbn() + " is added.");
                break;
            }
        }
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < books.length; i++){
            if(books[i].getIsbn().equals(isbn)){
                books[i] = null;
            }
        }
    }


    public Book findBook(String isbn){
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null && books[i].getIsbn().equals(isbn)){
                return books[i];
            }
        }
        return null;
    }

    public void updatePrice(Book book, double newprice) {
        for (int i = 0; i < books.length; i++) {
            books[i].setPrice(newprice);

        }
    }

    public void findBookAndApplyDiscount(String isbn, double discountPercentage){
        Book b = findBook(isbn);
        double discount=(1-discountPercentage)*(b.getPrice());
        b.setPrice(discount);
    }

    public void displayAllBooks(){
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null){
                System.out.println(books[i].getIsbn());
            }

        }
    }




}
