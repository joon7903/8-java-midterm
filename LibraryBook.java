public class LibraryBook implements Book {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;

    // 생성자 - Book 객체로부터 정보 복사
    public LibraryBook(Book book) {
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.year = book.getYear();
        this.available = book.isAvailable();
    }

    // 생성자 - ISBN, 제목, 저자, 출판년도 정보로 초기화
    public LibraryBook(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true; // 기본적으로 대출 가능
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }
}