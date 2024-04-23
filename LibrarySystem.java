public class LibrarySystem {

    private Book[] booklist;
    private static int bookCount = 0;
    private static final int NUM_BOOKS = 10; // 최대 도서 개수

    public LibrarySystem() {
        this.booklist = new Book[NUM_BOOKS]; // 생성자
    }

    // 책 추가
    public void addBook(Book book) {
        if (bookCount < NUM_BOOKS) {
            booklist[bookCount++] = book;
            System.out.println("'" + book.getTitle() + "' 도서를 추가했습니다.");
        } else {
            System.out.println("도서 개수가 최대치(10)에 도달했습니다. 도서를 추가할 수 없습니다.");
        }
    }

    // 제목으로 책 삭제
    public void removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                for (int j = i; j < bookCount - 1; j++) {
                    booklist[j] = booklist[j + 1];
                }
                booklist[--bookCount] = null;
                System.out.println("'" + title + "' 도서를 삭제했습니다.");
                return;
            }
        }
        System.out.println("# 오류: '" + title + "' 도서를 찾을 수 없습니다.");
    }

    // 제목으로 책 빌림
    public void borrowBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                if (booklist[i].isAvailable()) {
                    booklist[i].setAvailable(false);
                    System.out.println("'" + title + "' 도서를 빌렸습니다.");
                    return;
                } else {
                    System.out.println("'" + title + "' 도서가 이미 대출 중입니다.");
                }
            }
        }
        System.out.println("# 오류: '" + title + "' 도서를 찾을 수 없습니다.");
    }

    // 제목으로 책 반납
    public void returnBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                if (!booklist[i].isAvailable()) {
                    booklist[i].setAvailable(true);
                    System.out.println("'" + title + "' 도서를 반납했습니다.");
                    return;
                } else {
                    System.out.println("'" + title + "' 도서가 이미 반납되어 있습니다.");
                }
            }
        }
        System.out.println("# 오류: '" + title + "' 도서를 찾을 수 없습니다.");
    }

    // 모든 책 정보 출력
    public void displayAllBooks() {
        System.out.println("========== 전체 도서 목록 ==========");
        for (int i = 0; i < bookCount; i++) {
            System.out.printf("%-10s | %-25s | %-10s | %-8s\n",
                    booklist[i].getIsbn(), booklist[i].getTitle(), booklist[i].getAuthor(),
                    booklist[i].isAvailable() ? "대출 가능" : "대출 중");
        }
        System.out.println("==========  ==========  ===========");
    }
}