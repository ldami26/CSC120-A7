public class Cafe extends Building {

    private int nCoffeeOunces; // Coffee in ounces
    private int nSugarPackets; // Sugar packets
    private int nCreams; // Cream portions
    private int nCups; // Cups available

    // Constructor for Cafe with inventory parameters
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    // Overloaded Constructor with default inventory values
    public Cafe(String name, String address) {
        super(name, address, 1); // Assumes a default of 1 floor for a cafe
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 50;
        this.nCreams = 30;
        this.nCups = 20;
        System.out.println("You have built a cafe with default inventory: ☕");
    }

    // Sell a cup of coffee and adjust inventory
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(); // Calls default restock method if any inventory is insufficient
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Sold a coffee with " + size + "oz, " + nSugarPackets + " sugar, " + nCreams + " cream.");
    }

    // Overloaded method to sell coffee with default sugar and cream
    public void sellCoffee(int size) {
        sellCoffee(size, 1, 1); // Default to 1 sugar packet and 1 cream
    }

    // Private method to restock inventory
    private void restock(int coffee, int sugar, int cream, int cups) {
        this.nCoffeeOunces += coffee;
        this.nSugarPackets += sugar;
        this.nCreams += cream;
        this.nCups += cups;
        System.out.println("Restocked with " + coffee + " oz coffee, " + sugar + " sugar packets, " + cream + " creams, " + cups + " cups.");
    }

    // Overloaded restock method with default quantities
    private void restock() {
        restock(50, 20, 20, 10); // Default restock values
    }

    // Override showOptions to add cafe-specific options
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size, sugar, cream)\n + sellCoffee(size)\n + restock(coffee, sugar, cream, cups)\n + restock()");
    }

    // Override goToFloor to prevent floor navigation in a single-story cafe
    @Override
    public void goToFloor(int floorNum) {
        if (nFloors == 1) {
            System.out.println("This cafe is a single-floor building; floor navigation is unavailable.");
        } else {
            super.goToFloor(floorNum); // Allows floor navigation if more than 1 floor
        }
    }

    public static void main(String[] args) {
        // Testing Cafe functionality
        Cafe campusCafe = new Cafe("Campus Cafe", "789 University Rd", 1, 100, 50, 30, 20);
        campusCafe.showOptions();
        
        System.out.println("\n--- Selling coffee ---");
        campusCafe.sellCoffee(12, 2, 3);  // Selling a coffee with specified sugar and cream
        campusCafe.sellCoffee(8);         // Selling a coffee with default sugar and cream

        System.out.println("\n--- Restocking ---");
        campusCafe.restock();             // Restock with default values
        campusCafe.restock(100, 50, 30, 40); // Custom restock quantities

        System.out.println("\n--- Testing floor navigation ---");
        campusCafe.enter();
        campusCafe.goToFloor(1); // Should indicate single-floor restriction
        campusCafe.exit();
    }
}