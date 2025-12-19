public class Rectangle {
    // These are the "Fields" - what the rectangle knows about itself
    private double width;  // [cite: 10]
    private double height; // [cite: 11]
    private int id;        // The specific number for THIS rectangle [cite: 12]
    private static int idGen = 1; // A shared counter for ALL rectangles [cite: 13]

    // 1. Default Constructor: Used when you say "new Rectangle()"
    public Rectangle() {
        this.width = 1.0;  // Default width [cite: 16]
        this.height = 1.0; // Default height [cite: 16]
        this.id = idGen++; // Gives it a number (1, then 2, then 3...)
    }

    // 2. Constructor with parameters: Used when you say "new Rectangle(5, 10)"
    public Rectangle(double width, double height) {
        this(); // This magic line calls the code above to set the ID first
        setWidth(width);   // Sets the width using our safety check
        setHeight(height); // Sets the height using our safety check
    }

    // SETTERS: These are the "Security Guards" for your data
    public void setWidth(double width) {
        if (width <= 0) { // Check if the number is valid [cite: 23]
            throw new IllegalArgumentException("Width must be positive!"); //
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) { // Check if the number is valid [cite: 23]
            throw new IllegalArgumentException("Height must be positive!"); //
        }
        this.height = height;
    }

    // GETTERS: Let other parts of the program "see" the private data [cite: 22]
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public int getId() { return id; }

    // MATH METHODS: Calculations [cite: 26, 27]
    public double area() {
        return width * height; // Area formula
    }

    public double perimeter() {
        return 2 * (width + height); // Perimeter formula
    }

    // toString: How the rectangle describes itself in words [cite: 28]
    @Override
    public String toString() {
        return "Rectangle ID: " + id + " [Width: " + width + ", Height: " + height + "]";
    }
}