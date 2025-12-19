public class Book {
    // Private fields [cite: 31-37]
    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    // 1. Default Constructor [cite: 41-43]
    public Book() {
        this.id = idGen++;
        this.available = true; // Book is available by default [cite: 43]
    }

    // 2. Constructor with parameters [cite: 44-47]
    public Book(String title, String author, int year) {
        this(); // Calls the default constructor to set the ID
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    // Setters with Validation [cite: 49-52]
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty"); // [cite: 51]
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty"); // [cite: 51]
        }
        this.author = author;
    }

    public void setYear(int year) {
        // Range: 1500 to current year (2025) [cite: 52]
        if (year < 1500 || year > 2025) {
            throw new IllegalArgumentException("Year must be between 1500 and 2025");
        }
        this.year = year;
    }

    // Methods to change status [cite: 53-54]
    public void markAsBorrowed() { this.available = false; }
    public void markAsReturned() { this.available = true; }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Author: " + author +
                " | Year: " + year + " | Available: " + available; // [cite: 55]
    }
}
