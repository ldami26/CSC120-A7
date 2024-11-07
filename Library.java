import java.util.Hashtable;

public class Library extends Building {

    private Hashtable<String, Boolean> collection; // Collection of books
    private boolean hasElevator; // Indicates if the library has an elevator

    // Constructor with an elevator option
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
        this.hasElevator = hasElevator;
        System.out.println("You have built a library: 📚");
    }

    // Overloaded constructor without specifying elevator (default to false)
    public Library(String name, String address, int nFloors) {
        this(name, address, nFloors, false);
    }

    // Add a title to the collection
    public void addTitle(String title) {
        this.collection.put(title, true);
        System.out.println("Added \"" + title + "\" to the collection.");
    }

    // Overloaded addTitle to add multiple titles at once
    public void addTitle(String[] titles) {
        for (String title : titles) {
            this.collection.put(title, true);
            System.out.println("Added \"" + title + "\" to the collection.");
        }
    }

    // Remove a title from the collection
    public String removeTitle(String title) {
        if (this.collection.remove(title) != null) {
            System.out.println("Removed \"" + title + "\" from the collection.");
            return title;
        } else {
            System.out.println("The title \"" + title + "\" was not found in the collection.");
            return null;
        }
    }

    // Check out a book
    public void checkOut(String title) {
        if (this.collection.containsKey(title) && this.collection.get(title)) {
            this.collection.put(title, false);
            System.out.println("Checked out \"" + title + "\".");
        } else {
            System.out.println("The title \"" + title + "\" is not available.");
        }
    }

    // Overloaded checkOut to check out multiple books at once
    public void checkOut(String[] titles) {
        for (String title : titles) {
            checkOut(title);
        }
    }

    // Return a book
    public void returnBook(String title) {
        if (this.collection.containsKey(title) && !this.collection.get(title)) {
            this.collection.put(title, true);
            System.out.println("Returned \"" + title + "\".");
        } else {
            System.out.println("The title \"" + title + "\" was not checked out.");
        }
    }

    // Check if a title exists in the collection
    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    // Check if a book is available
    public boolean isAvailable(String title) {
        return this.collection.getOrDefault(title, false);
    }

    // Print the entire collection with availability
    public void printCollection() {
        System.out.println("Library Collection:");
        for (String title : this.collection.keySet()) {
            System.out.println(title + " - " + (this.collection.get(title) ? "Available" : "Checked out"));
        }
    }

    // Override showOptions to display library-specific methods
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(title) \n + addTitle(titles[]) \n + removeTitle(title) \n + checkOut(title) \n + checkOut(titles[]) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection()");
    }

    // Override goToFloor to allow navigation based on elevator availability
    @Override
    public void goToFloor(int floorNum) {
        if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {
            System.out.println("Cannot move to a non-adjacent floor without an elevator.");
        } else {
            super.goToFloor(floorNum);
        }
    }

    public static void main(String[] args) {
        Library lib = new Library("Campus Library", "456 College Ave", 4, true);
        
        System.out.println("\n--- Adding and checking collection ---");
        lib.addTitle("The Great Gatsby by F. Scott Fitzgerald");
        lib.addTitle("1984 by George Orwell");
        lib.addTitle(new String[]{"To Kill a Mockingbird by Harper Lee", "Moby Dick by Herman Melville"});
        lib.printCollection();

        System.out.println("\n--- Checking out and returning books ---");
        lib.checkOut("1984 by George Orwell");
        lib.checkOut(new String[]{"The Great Gatsby by F. Scott Fitzgerald", "Moby Dick by Herman Melville"});
        System.out.println("Is '1984' available? " + lib.isAvailable("1984 by George Orwell"));
        lib.printCollection();
        lib.returnBook("1984 by George Orwell");
        lib.printCollection();

        System.out.println("\n--- Testing floor navigation ---");
        lib.enter();
        lib.goToFloor(2); // Should work
        lib.goToFloor(4); // Should work if elevator exists
        lib.exit();
    }
}