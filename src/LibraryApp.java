import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    // 1. Fields (Variables) - Must be at the top!
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // 2. The Constructor - This runs the moment you start the app
    public LibraryApp() {
        // Adding "Seed Data" so the library isn't empty
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        books.add(new Book("Java Programming", "John Smith", 2022));
        books.add(new Book("Becoming", "Michelle Obama", 2018));

        // Mark one as borrowed to test your logic
        books.get(1).markAsBorrowed();
    }

    // 3. The main logic loop
    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1: printAllBooks(); break;
                case 2: addNewBook(); break;
                case 3: searchBooks(); break;
                case 4: borrowBook(); break;
                case 5: returnBook(); break;
                case 6: deleteBook(); break;
                case 7:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // --- Helper Methods ---

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }

    private void addNewBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        try {
            Book newBook = new Book(title, author, year);
            books.add(newBook);
            System.out.println("Book added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchBooks() {
        System.out.print("Enter part of the title: ");
        String query = scanner.nextLine().toLowerCase();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(query)) {
                System.out.println(b);
            }
        }
    }

    private void borrowBook() {
        System.out.print("Enter ID to borrow: ");
        int id = scanner.nextInt();
        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isAvailable()) {
                    b.markAsBorrowed();
                    System.out.println("Book borrowed.");
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void returnBook() {
        System.out.print("Enter ID to return: ");
        int id = scanner.nextInt();
        for (Book b : books) {
            if (b.getId() == id) {
                if (!b.isAvailable()) {
                    b.markAsReturned();
                    System.out.println("Book returned.");
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void deleteBook() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = books.removeIf(b -> b.getId() == id);
        if (removed) {
            System.out.println("Book deleted.");
        } else {
            System.out.println("Error: Book not found.");
        }
    }
}