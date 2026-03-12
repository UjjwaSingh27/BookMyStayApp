import java.util.HashMap;
import java.util.Map;

/*
 * ROOM CLASS
 * Stores room details
 */
class Room {
    int beds;
    int size;
    double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }
}


/*
 * ROOM INVENTORY CLASS
 * Stores availability using HashMap
 */
class RoomInventory {

    private HashMap<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}


/*
 * ROOM SEARCH SERVICE
 * Performs read-only search
 */
class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        if (availability.get("Single") > 0) {
            System.out.println("Single Room:");
            System.out.println("Beds: " + singleRoom.beds);
            System.out.println("Size: " + singleRoom.size + " sqft");
            System.out.println("Price per night: " + singleRoom.price);
            System.out.println("Available: " + availability.get("Single"));
            System.out.println();
        }

        if (availability.get("Double") > 0) {
            System.out.println("Double Room:");
            System.out.println("Beds: " + doubleRoom.beds);
            System.out.println("Size: " + doubleRoom.size + " sqft");
            System.out.println("Price per night: " + doubleRoom.price);
            System.out.println("Available: " + availability.get("Double"));
            System.out.println();
        }

        if (availability.get("Suite") > 0) {
            System.out.println("Suite Room:");
            System.out.println("Beds: " + suiteRoom.beds);
            System.out.println("Size: " + suiteRoom.size + " sqft");
            System.out.println("Price per night: " + suiteRoom.price);
            System.out.println("Available: " + availability.get("Suite"));
        }
    }
}


/*
 * MAIN CLASS – UseCase4RoomSearch
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room singleRoom = new Room(1, 250, 1500.0);
        Room doubleRoom = new Room(2, 400, 2500.0);
        Room suiteRoom = new Room(3, 750, 5000.0);

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom);
    }
}