package UserProgram;

import java.util.ArrayList;

public class BookingList {
    private ArrayList<Booking> bookingArrayList;
    public BookingList(){
        bookingArrayList=new ArrayList<Booking>();
    }

    public boolean addBooking(Hotel selectedHotel, GuestList guestList,int guestId, int desiredRoom, int year, int month, int day, int numberOfNights){
        boolean operationDone=false;
        BookingDate desiredDate= new BookingDate(year, month, day, numberOfNights,0);
        if(selectedHotel.verifyAvailabilityOfRoom(desiredRoom,desiredDate)==true){
            Booking bTemp= new Booking(guestList.getGuest(guestId),selectedHotel.getRoom(desiredRoom),year,month,day, numberOfNights);
            bookingArrayList.add(bTemp);
            //add dates of booking onto the Room dates array
            BookingDate confirmedDate= new BookingDate (year, month, day, numberOfNights,bTemp.getBookingId());
            selectedHotel.getRoom(desiredRoom).getArrayDateFromRoom().add(confirmedDate);
            //add booking to user's booking history
            guestList.getGuest(guestId).addBookingHistory(bTemp);

            operationDone=true;

        }else{
            System.out.println("Room not available for selected dates.\nPlease select different room or other dates.");
        }
        return operationDone;
    }
    public boolean cancelBooking(int bookingId, Hotel selectedHotel, GuestList guestList) {
        //Cancel booking and remove booking related data stored in the selected room and in the guest
        boolean operationDone=false;
        for (int i = 0; i < bookingArrayList.size(); i++) {
            if (bookingArrayList.get(i).getBookingId() == bookingId) {
                bookingArrayList.get(i).setValid(false);
                //    remove booking from guest located in guestList
                int guestID=bookingArrayList.get(i).getGuest().getGuestId();
                guestList.getGuest(guestID).removeBookingHistory(bookingId);
                // remove BookingDate from Array<BookingDate> located in Hotel
                int roomIdTemp=bookingArrayList.get(i).getSelectedRoom().getRoomNumber();
                selectedHotel.getRoom(roomIdTemp).removeDateByBookingNumber(bookingId);
                operationDone=true;
            }

        }
        return operationDone;
    }
    public boolean showAllBookings(){
        boolean operationDone=false;
        for (int i = 0; i <bookingArrayList.size() ; i++) {
            System.out.println(bookingArrayList.get(i));
            operationDone=true;
        }
        return operationDone;
    }
    public Booking getBooking(int bookingId){
        Booking bookingTemp=null;
        for (int i = 0; i <bookingArrayList.size() ; i++) {
            if (bookingArrayList.get(i).getBookingId()==bookingId){
                bookingTemp=bookingArrayList.get(i);
                return bookingTemp;
            }
        }
        if (bookingTemp==null){
            System.out.println("Booking not found");
        }
        return bookingTemp;
    }
    public boolean getAllValidBooking(){
        boolean operationDone=false;
        for (int i = 0; i <bookingArrayList.size() ; i++) {
            if(bookingArrayList.get(i).getIsValid()==true){
                System.out.println(bookingArrayList.get(i));
                operationDone=true;
            }

        }
        if (operationDone=false){
            System.out.println("There are no valid bookings in system");
        }
        return operationDone;
    }
    public boolean getAllCancelledBooking(){
        boolean operationDone=false;
        for (int i = 0; i <bookingArrayList.size() ; i++) {
            if(bookingArrayList.get(i).getIsValid()==false){
                System.out.println(bookingArrayList.get(i));
                operationDone=true;
            }

        }
        if (operationDone=false){
            System.out.println("There are no cancelled bookings in system");
        }
        return operationDone;
    }
    @Override
    public String toString() {
        return "BookingList{" +
                "bookingArrayList=" + bookingArrayList +
                '}';
    }
}
