package UserProgram;

import java.time.LocalDate;

public class BookingDate {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfNights;
    private int bookingNumber;

    public BookingDate(int year, int month, int day, int numberOfNights, int bookingNUmber){
        this.checkInDate= LocalDate.of(year,month,day);
        this.checkOutDate=checkInDate.plusDays(numberOfNights-1);
        this.bookingNumber=bookingNUmber;
        this.numberOfNights=numberOfNights;
    }

    public int getBookingNumber(){
        return bookingNumber;
    }

    public void setCheckInDate(int year, int month, int day) {
        this.checkInDate = LocalDate.of(year,month,day);
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckOutDate(int numberOfNights) {
        this.checkOutDate = checkInDate.plusDays(numberOfNights);
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public String toString (){
        return "Check-in: "+checkInDate+"/ Check-out: "+checkOutDate+"/ Nights: "+numberOfNights+"---Confirmation Booking ID:" +bookingNumber ;
    }
}
