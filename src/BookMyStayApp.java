import java.util.Queue;
import java.util.LinkedList;

/*
 * CLASS – Reservation
 * Represents a booking request from a guest
 */
class Reservation {

    // Guest name
    private String guestName;

    // Requested room type
    private String roomType;

    // Constructor
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    // Getter for guest name
    public String getGuestName() {
        return guestName;
    }

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }
}


/*
 * CLASS – BookingRequestQueue
 * Manages booking requests using FIFO queue
 */
class BookingRequestQueue {

    // Queue storing reservation requests
    private Queue<Reservation> requestQueue;

    // Constructor
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add request to queue
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    // Retrieve next request
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Check if queue has pending requests
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}


/*
 * MAIN CLASS – UseCase5BookingRequestQueue
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        // Header
        System.out.println("Booking Request Queue");

        // Initialize queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process queue in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation r = bookingQueue.getNextRequest();

            System.out.println(
                    "Processing booking for Guest: " +
                            r.getGuestName() +
                            ", Room Type: " +
                            r.getRoomType()
            );
        }
    }
}