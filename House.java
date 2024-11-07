import java.util.ArrayList;

public class House extends Building {

    private ArrayList<String> residents; // List of residents
    private boolean hasDiningRoom; // Whether the house has a dining room
    private boolean hasElevator; // Indicates if the house has an elevator

    // Constructor with all properties
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors); // Call Building's constructor
        this.residents = new ArrayList<String>();
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
        System.out.println("You have built a house: 🏠");
    }

    // Overloaded constructor with default elevator option
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        this(name, address, nFloors, hasDiningRoom, false); // Defaults to no elevator
    }

    // Accessor for hasDiningRoom
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    // Accessor for hasElevator
    public boolean hasElevator() {
        return this.hasElevator;
    }

    // Returns the number of residents
    public int nResidents() {
        return this.residents.size();
    }

    // Move a resident into the house
    public void moveIn(String name) {
        this.residents.add(name);
        System.out.println(name + " has moved in.");
    }

    // Overloaded moveIn method that adds multiple residents
    public void moveIn(String[] names) {
        for (String name : names) {
            this.residents.add(name);
            System.out.println(name + " has moved in.");
        }
    }

    // Move a resident out of the house
    public String moveOut(String name) {
        if (this.residents.contains(name)) {
            this.residents.remove(name);
            System.out.println(name + " has moved out.");
            return name;
        } else {
            System.out.println(name + " is not a resident.");
            return null;
        }
    }

    // Overloaded moveOut method that removes all residents
    public void moveOut() {
        this.residents.clear();
        System.out.println("All residents have moved out.");
    }

    // Check if a person is a resident
    public boolean isResident(String person) {
        return this.residents.contains(person);
    }

    // Override showOptions to add house-specific options
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + moveIn(name) \n + moveIn(names[]) \n + moveOut(name) \n + moveOut() \n + isResident(name) \n + nResidents() \n + hasDiningRoom() \n + hasElevator()");
    }

    // Override goToFloor to allow or restrict floor navigation based on elevator availability
    @Override
    public void goToFloor(int floorNum) {
        if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {
            System.out.println("Cannot move to a non-adjacent floor without an elevator.");
        } else {
            super.goToFloor(floorNum);
        }
    }

    public static void main(String[] args) {
        House h = new House("Green House", "123 Main St", 3, true, false);
        h.showOptions();

        System.out.println("\n--- Moving in residents ---");
        h.moveIn("Alice");
        h.moveIn(new String[]{"Bob", "Charlie"});

        System.out.println("\n--- Checking residents ---");
        System.out.println("Has dining room: " + h.hasDiningRoom());
        System.out.println("Has elevator: " + h.hasElevator());
        System.out.println("Number of residents: " + h.nResidents());
        System.out.println("Is Alice a resident? " + h.isResident("Alice"));
        System.out.println("Is Dave a resident? " + h.isResident("Dave"));

        System.out.println("\n--- Moving out residents ---");
        h.moveOut("Alice");
        h.moveOut(); // Removes all remaining residents

        System.out.println("\n--- Testing floor navigation ---");
        h.enter();
        h.goToFloor(2); // Should work
        h.goToFloor(3); // Should fail if no elevator
        h.exit();
    }
}