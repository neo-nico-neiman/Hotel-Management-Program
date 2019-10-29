package UserProgram;

public class Main {
    public static void main(String[]args) {

//        GuestList list=new GuestList();
//        list.addGuest("Nico","Neiman",2);
//        list.editGuestLastName(0, "Nei");
//        list.addGuest("Fede","Neiman",2);
//        list.addGuest("Pol","Neiman",2);
//        System.out.println(list.toString());
//        GuestList newGuestList=new GuestList();
//        int guestId= newGuestList.addGuest("Nico","Neiman",214);
//        Booking b= new Booking(newGuestList.getGuest(guestId),);
        /*Creating Rates for different rooms

         */
//        RoomTypeList hotelPremiereRates2019= new RoomTypeList();
//        hotelPremiereRates2019.addRate("Family",50.00,300.00,45.00);
//        hotelPremiereRates2019.addRate("Business",42.20,253.20,37.98);
//        hotelPremiereRates2019.addRate("Deluxe",72.30,433.8,65.07);
//        Hotel hotelPremiere= new Hotel(3);
//        /* Adding rooms to hotel
//
//         */
//        hotelPremiere.addRoom(1,2,"Queen",1);
//        hotelPremiere.addRoom(2,4,"Double Queen",2);
//        hotelPremiere.addRoom(3,3,"Queen + Single",0);
//        /*Add dates to room*/
//
//        hotelPremiere.addDatesToRoom(1,2019,9,3,2);
//        hotelPremiere.addDatesToRoom(2,2019,9,2,2);
//
//
//        /*Adding guests
//
//         */
//        GuestList newGuestList= new GuestList();
//        int x=newGuestList.addGuest("Nico","Neiman",2046654210);
//        int y=newGuestList.addGuest("Fede","Nei",987434210);
//        int z=newGuestList.addGuest("Pol","Neimann",541654210);
//        for (int i = 0; i <Guest.getGuestCounter() ; i++) {
//            System.out.println("Guest id: "+i+newGuestList.getGuest(i));
//        }
//        /*Create date list with desired dates when guest want to stay in hotel
//
//         */
//
////        DatesList desiredDates= new DatesList();
////        desiredDates.setNewDate(2019,9,2,2);
//        /*Adding new booking
//
//         */
//        Booking hotelPremiereBookingList=new Booking(newGuestList.getGuest(1),hotelPremiere.getRoom(3),2,2019,10,8 );
//        /*Check if method that returns the rooms free for the desired dates works
//
//         */
//        System.out.println(hotelPremiereBookingList.toString());
//        hotelPremiere.roomFreeForDesiredDates(2019,9,2,2);
//
//
//        Room r= new Room(004,2,"Queen",1);
//        r.getArrayDateFromRoom().add(new BookingDate(2019,10,2,3));
//        System.out.println(r.getArrayDateFromRoom().get(0).getCheckInDate());
//        System.out.println(r.getArrayDateFromRoom().get(0).getCheckOutDate());
//
//    }
        //Creating RoomTypeList
        RoomTypeList pachamamaRoomTypeList= new RoomTypeList();
        pachamamaRoomTypeList.addRoomType("Single",1,20.10,120.6,18.09);
        pachamamaRoomTypeList.addRoomType("Double",2,40.20,241.2,36.18);
        pachamamaRoomTypeList.addRoomType("Triple",3,60.30,361.8,54.27);
        pachamamaRoomTypeList.showAllRoomType();

        //Create hotel
        Hotel pachamama=new Hotel();
        pachamama.addRoom(0);
        pachamama.addRoom(1);
        pachamama.addRoom(2);

        //create GuestList
        GuestList pachamamaGuests= new GuestList();
        System.out.println(pachamamaGuests.addGuest("Rodolfo","Rojas",2045679354));
        pachamamaGuests.addGuest("Alfonso","Santos",2087325253);

        //TESTING PROGRAM FUNCTIONALITY
        //Create  BookingList
        BookingList newBooking= new BookingList();

        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,1,3,2019,10,11,3));
        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,1,3,2019,5,11,2));
        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,1,3,2019,6,11,2));
        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,0,2,2019,1,11,2));

        System.out.println("---");
        //Trying to make a booking for Room 3 on date that is already booked: It should return false
        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,0,3,2019,10,11,2));
        System.out.println("---");
        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,0,3,2019,10,10,3));
        System.out.println("---");
        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,0,3,2019,10,12,4));

        /*Testing room 2
        Room 2 is booked on dates 2019/01/11 for 2 nights
               Check out is at 12pm and check in is at 3:00 pm, therefore next booking for ROOM 2 should be TRUE
         */
        System.out.println("---");
        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,0,2,2019,1,9,2));
        newBooking.showAllBookings();

        //Checking "cancel booking" method
        System.out.println("---");
        System.out.println("Before cancelling");
        System.out.println("---");
        System.out.println("position0");
        pachamamaGuests.getGuest(1).getBookingForGuest(0);
        System.out.println("position1");
        pachamamaGuests.getGuest(1).getBookingForGuest(1);
        System.out.println("position2");
        pachamamaGuests.getGuest(1).getBookingForGuest(2);
        System.out.println("\n---");
        //cancel bookingID 1 for guestID 1
        System.out.println(newBooking.cancelBooking(1,pachamama,pachamamaGuests));
        System.out.println("--allBookings--");
        //verify booking is cancel. If false is at the end of booking description, then booking is cancelled
        newBooking.showAllBookings();
        System.out.println("--Verify-");
        //verify that no guest contains the cancelled booking ID
        System.out.println(pachamamaGuests.getBookingSearchingAllGuests(1));
        System.out.println("\n---");
        //Checking guestId 1 Array<Booking>
        System.out.println(pachamamaGuests.getGuest(1).showAllBookingsForGuest());
        System.out.println("after cancelling");
        System.out.println("position0");
        pachamamaGuests.getGuest(1).getBookingForGuest(0);
        System.out.println("position1");
        pachamamaGuests.getGuest(1).getBookingForGuest(1);
        System.out.println("position2");
        pachamamaGuests.getGuest(1).getBookingForGuest(2);
        //Check if booking date as been removed from room
        System.out.println("\nRoom availability");
        System.out.println(newBooking.addBooking(pachamama,pachamamaGuests,0,3,2019,5,11,2));
        System.out.println(pachamama.getRoom(3).getArrayDateFromRoom());
        //retrieve all cancelled booking
        System.out.println("\nall cancelled bookings");
        newBooking.getAllCancelledBooking();
        //retrieve all valid booking
        System.out.println("\nAll valid bookings");
        newBooking.getAllValidBooking();
        //Check edit booking
        System.out.println("\nretrieve booking before edit");
        System.out.println(newBooking.getBooking(2));
        System.out.println(pachamamaGuests.addGuest("Justino","Murillo",204));
        System.out.println(pachamamaGuests.addGuest("Carlos","Rudy",204));
        newBooking.getBooking(2).setNewGuest(pachamamaGuests.getGuest(2));
        System.out.println();
        System.out.println("\nAfter");
        System.out.println(newBooking.getBooking(2));
        pachamamaGuests.showAllGuest();

        //Get guest info by last name
        System.out.println("\nGet id by last name");
        System.out.println();
        pachamamaGuests.getGuestInfoByLastName("Rudy");
        //Check remove Guest
        System.out.println("Before removing");
        pachamamaGuests.showAllGuest();
        System.out.println();
        System.out.println("Remove Guest");
        System.out.println(pachamamaGuests.removeGuest(2,"Murillo"));
        pachamamaGuests.showAllGuest();
        //Test that Guest Id order is correct
        System.out.println("Adding new guest");
        pachamamaGuests.addGuest("Santiago","Alto",220548762);
        pachamamaGuests.showAllGuest();



    }
}

