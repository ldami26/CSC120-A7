import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("--> Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("--> Successfully removed " + b.getName() + " from the map.");
        return b;
    }

    /**
     * Prints a directory of buildings in the CampusMap
     * @return A formatted string of the campus map directory
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i+1) + ". " + this.buildings.get(i).getName() 
                         + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        
        // Add a variety of buildings to the campus map
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court, Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5, true));
        myMap.addBuilding(new Library("Young Science Library", "15 Science Quad, Northampton, MA 01063", 3));
        myMap.addBuilding(new Cafe("Campus Cafe", "789 University Rd, Northampton, MA 01063", 1, 200, 100, 50, 40));
        myMap.addBuilding(new Cafe("Compass Cafe", "120 Elm Street, Northampton, MA 01063", 2, 150, 80, 30, 20));
        myMap.addBuilding(new House("Green Street House", "102 Green Street, Northampton, MA 01063", 3, true));
        myMap.addBuilding(new House("Chase House", "10 Prospect Street, Northampton, MA 01063", 4, false));
        myMap.addBuilding(new House("Lamont House", "60 Elm Street, Northampton, MA 01063", 3, true));
        myMap.addBuilding(new Building("Alumnae Gymnasium", "83 Green Street, Northampton, MA 01063", 2));
        
        // Print the directory of buildings on the campus map
        System.out.println("\n" + myMap);
    }
}
