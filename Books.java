class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private int yearOfPublication;

    public Book(String title, String author, int numberOfPages, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.yearOfPublication = yearOfPublication;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void displayInfo() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Число страниц: " + numberOfPages);
        System.out.println("Год публикации: " + yearOfPublication);
    }

    public int getAge() {
        return 2024 - yearOfPublication;
    }

    public boolean isManyThomes() {
        return numberOfPages > 500;
    }

    public String getSummary() {
        return title + " автор " + author + " (" + yearOfPublication + ")";
    }
}

class LibraryBook extends Book {
    private String libraryCode;

    public LibraryBook(String title, String author, int numberOfPages, int yearOfPublication, String libraryCode) {
        super(title, author, numberOfPages, yearOfPublication);
        this.libraryCode = libraryCode;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Библиотечный код: " + libraryCode);
    }

    public void setLibraryCode(String libraryCode) {
        this.libraryCode = libraryCode;
    }

    public boolean isOldBook() {
        return getAge() > 100;
    }

    public String getLibraryInfo() {
        return "Библиотечный код: " + libraryCode + ", " + getSummary();
    }

    public String getShelf() {
        return "Книга " + getSummary() + " расположена на второй полке.";
    }
}

public class Books {
    public static void main(String[] args) {
        Book book = new Book("Война и мир", "Федор Достоевский", 960, 1867);
        book.displayInfo();
        System.out.println("Возраст книги: " + book.getAge() + " лет");
        System.out.println("У книги больше одного тома? " + book.isManyThomes());
        System.out.println("Общая информация: " + book.getSummary());
        System.out.println();

        LibraryBook libraryBook = new LibraryBook("Мертвые души", "Николай Гоголь", 352, 1842, "ИВ12345");
        libraryBook.displayInfo();
        System.out.println("Это старая книга? " + libraryBook.isOldBook());
        System.out.println("Библиотечная информация: " + libraryBook.getLibraryInfo());
        System.out.println("Расположение: " + libraryBook.getShelf());
    }
}