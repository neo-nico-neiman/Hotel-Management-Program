package UserProgram;


public class Booking {
    private static int bookingCounter=0;
    private Guest newGuest;
    private Room selectedRoom;
    private BookingDate bookingDate;
    private int bookingId;
    private boolean valid;

    public Booking(Guest newGuest, Room selectedRoom, int year, int month, int day, int numberOfNights) {
        this.newGuest = newGuest;
        this.selectedRoom = selectedRoom;
        this.bookingId=bookingCounter;
        this.bookingDate=new BookingDate(year,month,day,numberOfNights,bookingId);
        this.valid=true;
        bookingCounter++;
    }

    public Guest getGuest() {
        return newGuest;
    }

    public void setNewGuest(Guest newGuest) {
        this.newGuest = newGuest;
    }

    public Room getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }

    public BookingDate getBookingDate() {
        return bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public boolean getIsValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    public String toString(){
        return "\nBooking ID: "+bookingId+ newGuest+" \n"+selectedRoom+"\n"+bookingDate+"\n"+valid;
    }
}
