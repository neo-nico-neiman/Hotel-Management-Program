package UserProgram;
import java.util.ArrayList;

public class Room {
    private boolean available;
    private int roomNumber;
    private int roomTypeId;
    private RoomType roomType;
    private ArrayList<BookingDate> bookingDateForRooms;
    private static int roomCounter=1;

    public Room(int roomTypeId) {
        this.available=true;
        this.roomNumber = roomCounter;
        this.roomType=RoomTypeList.getRoomType(roomTypeId);
        this.roomTypeId = roomTypeId;
        this.bookingDateForRooms =new ArrayList<BookingDate>();
        roomCounter++;

    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public ArrayList<BookingDate> getArrayDateFromRoom() {
        return bookingDateForRooms;
    }
    public boolean removeDateByBookingNumber(int bookingNumber) {
        boolean operationDone = false;
        for (int i = 0; i < bookingDateForRooms.size(); i++) {
            if (bookingDateForRooms.get(i).getBookingNumber() == bookingNumber) {
                bookingDateForRooms.remove(i);
                operationDone = true;
            }
        }
        return operationDone;
    }
    @Override
    public String toString() {
        return "roomNumber: " + roomNumber +" / " + roomType;
    }
}

