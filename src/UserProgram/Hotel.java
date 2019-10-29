package UserProgram;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room>roomArray;

    public Hotel(){
        this.roomArray= new ArrayList<Room>();
    }
    public void addRoom(int roomTypeId){

        roomArray.add(new Room(roomTypeId));
    }
    public ArrayList<Room> getRoomArray() {
        return roomArray;
    }
    public Room getRoom(int roomNumber){
//        return roomArray.get(roomNumber-1);
        Room roomTemp=null;
        for (int i = 0; i <roomArray.size() ; i++) {
            if (roomArray.get(i).getRoomNumber()==roomNumber){
                roomTemp=roomArray.get(i);
                break;
            }
        }
        if(roomTemp==null){
            System.out.println("Room does not exist");
        }
        return roomTemp;
    }
    public boolean verifyAvailabilityOfRoom(int roomNumber, BookingDate desiredDate){
        //Method to avoid creating a booking on a room that is already booked
        //Based on date
        boolean roomAvailable=true;

            for (int j = 0; j <roomArray.get(roomNumber-1).getArrayDateFromRoom().size() ; j++) {
                LocalDate guest1CheckIn=roomArray.get(roomNumber-1).getArrayDateFromRoom().get(j).getCheckInDate();
                LocalDate guest1CheckOut=roomArray.get(roomNumber-1).getArrayDateFromRoom().get(j).getCheckOutDate();

                /*
                Guest1 represents all existing guests
                Guest2 represents a new guest that wants to create a new booking
                 */
                LocalDate guest2CheckIn=desiredDate.getCheckInDate();
                LocalDate guest2CheckOut=desiredDate.getCheckOutDate();

                //Date equal or in between
                if((guest2CheckIn.isAfter(guest1CheckIn)||guest2CheckIn.isEqual(guest1CheckIn))
                        &&
                        ((guest2CheckOut.isEqual(guest1CheckOut)||guest2CheckOut.isBefore(guest1CheckOut)))){
                    roomAvailable=false;
                    break;
                }
                //Date starting before checkIn and concluding on anytime after checkIn
                else if ((guest2CheckIn.isBefore(guest1CheckIn))
                        &&
                        (guest2CheckOut.isAfter(guest1CheckIn))){
                    roomAvailable=false;
                    break;
                }
                //Date starting after checkIn but before checkOut
                else if ((guest2CheckIn.isAfter(guest1CheckIn))&&(guest2CheckIn.isBefore(guest1CheckOut))){
                    roomAvailable=false;
                    break;
                }
        }
            return roomAvailable;
    }

    }

