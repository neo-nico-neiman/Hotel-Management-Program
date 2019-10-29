package UserProgram;

import java.util.ArrayList;

public class Guest {

    private static int guestCounter=0;
    private PersonalInfo guestInfo;
    private ArrayList<Booking> guestBookingHistory;
    private  int guestId;

    public Guest (String firstName, String lastName, int phoneNumber){
        this.guestInfo= new PersonalInfo(firstName,lastName,phoneNumber);
        this.guestId=guestCounter;
        this.guestBookingHistory=new ArrayList<Booking>();
        guestCounter++;
    }

    public static int getGuestCounter(){
        return guestCounter;
    }

    public static void setBackGuestCounter(){
        guestCounter--;
    }

    public ArrayList<Booking> getGuestBookingHistory() {
        return guestBookingHistory;
    }

    public boolean addBookingHistory(Booking newBooking){
        /*This method avoids duplicating Bookings History on guest

         */
        boolean operationDone=false;
        boolean executeOperation=true;
        /*First Check if the booking exist on Guest's history. If not, then it will add.

         */
        for (int i = 0; i <guestBookingHistory.size() ; i++) {
            if ((guestBookingHistory.get(i).getBookingId()==newBooking.getBookingId())){
                executeOperation=false;
                break;
            }
        }

        if(executeOperation==true){
            guestBookingHistory.add(newBooking);
            operationDone = true;
        }
        return operationDone;
    }

    public boolean showAllBookingsForGuest(){
        boolean operationDone=false;
        for (int i = 0; i <guestBookingHistory.size() ; i++) {
            System.out.println(guestBookingHistory.get(i));
            operationDone=true;
        }
        return operationDone;
    }

    public boolean getBookingForGuest(int bookingPosition){
        boolean operationDone=false;
        boolean executeOperation=false;
        if(bookingPosition<guestBookingHistory.size()){
            executeOperation=true;
        }else if (bookingPosition>=guestBookingHistory.size()){
            System.out.println("Invalid position");
            return operationDone;
        }
        if(executeOperation=true){
            System.out.println(guestBookingHistory.get(bookingPosition));
            operationDone=true;

        }
        return operationDone;
    }

    public boolean removeBookingHistory( int bookingId){
        /*Remove booking from guest history and append array

         */
        boolean operationDone=false;
        for (int i = 0; i <guestBookingHistory.size() ; i++) {
            if (guestBookingHistory.get(i).getBookingId()==bookingId) {
                // reallocate spaces in array
                for (int j = i; j <guestBookingHistory.size()-1 ; j++) {
                    Booking bTemp= guestBookingHistory.get(j+1);
                    guestBookingHistory.set(j,bTemp);
                    operationDone = true;
                }
                break;
            }
        }
        if (operationDone=true){
            guestBookingHistory.remove(guestBookingHistory.size()-1);

        }

        return operationDone;

    }

    public PersonalInfo getPersonalInfo(){
        return guestInfo;
    }

    public int getGuestId(){
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String toString(){
        return "\nGuest id: "+getGuestId()+ getPersonalInfo();
    }
}


