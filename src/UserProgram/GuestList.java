package UserProgram;
import java.util.ArrayList;

public class GuestList {
    private ArrayList<Guest> guestList;

    public GuestList(){
        this.guestList=new ArrayList<Guest>();
    }
    public String addGuest(String firstName,String lastName, int phoneNumber){
        boolean operationDone=false;
        int guestId=-1;
        boolean executeOperation=true;
        for (int i = 0; i <guestList.size() ; i++) {
            if ((guestList.get(i).getPersonalInfo().getFirstName() == firstName) && (guestList.get(i).getPersonalInfo().getLastName() == lastName) && (guestList.get(i).getPersonalInfo().getPhoneNumber() == phoneNumber)) {
                System.out.println("The user already exist in the system");
                executeOperation = false;
                break;
            }
        }
        /*Only after the previous expression verify that the User does not exist on the system, Only then it will add it

         */
        if(executeOperation==true){
            guestList.add(new Guest(firstName,lastName,phoneNumber));
            operationDone=true;
        }

                /*Search and return the Id number of the guest
                this technique is used to avoid obtaining the wrong value when more than one guest is created at the same time by other users
                 */
                for (int j = 0; j <guestList.size() ; j++) {
                    if((guestList.get(j).getPersonalInfo().getFirstName()==firstName)&&(guestList.get(j).getPersonalInfo().getLastName()==lastName)&&(guestList.get(j).getPersonalInfo().getPhoneNumber()==phoneNumber)) {
                    guestId=guestList.get(j).getGuestId();
                    }
                }
                //If operation was successful the guestId will be other than -1
        return "Operation complete:"+operationDone+ "/ Guest ID: "+ guestId;
    }
    public Guest getGuest(int guestID){
        Guest guestTemp=null;
        for (int i = 0; i <guestList.size() ; i++) {
            if(guestList.get(i).getGuestId()==guestID){
                guestTemp=guestList.get(i);
                break;
            }
        }
        return guestTemp;
    }
    public String getGuestInfoByLastName(String lastName){
        //Get the Guest Id by lastName returning up to three Guests with the same last Name
        int guestId1Temp=-1;
        int guestId2Temp=-1;
        int guestId3Temp=-1;
        int counter=0;
        String returnString="";
        for (int i = 0; i <guestList.size() ; i++) {
            if(guestList.get(i).getPersonalInfo().getLastName()==lastName){
                if(counter==0){
                    guestId1Temp=i;
                } else if (counter==1){
                    guestId2Temp=i;
                } else if(counter==3){
                    guestId3Temp=i;
                }
                counter++;
            }

            }
        if(guestId1Temp==-1){
            returnString="There are no Guests with the specified Last Name";
            return returnString;
        }else if((guestId1Temp!=-1)&&(guestId2Temp==-1)&&(guestId3Temp==-1)){
            //option to print all user info
            System.out.println(guestList.get(guestId1Temp));
            //option to return string with ID
            returnString= "Guest Id: "+guestId1Temp;
            return returnString;
        }else if((guestId1Temp!=-1)&&(guestId2Temp!=-1)&&(guestId3Temp==-1)){
            System.out.println(guestList.get(guestId1Temp));
            System.out.println(guestList.get(guestId2Temp));
            returnString= "Total Guest Found: 2\n"+"Guest Id: "+guestId1Temp+", Guest Id: "+guestId2Temp;
            return returnString;
        }else if((guestId1Temp!=-1)&&(guestId2Temp!=-1)&&(guestId3Temp!=-1)){
            System.out.println(guestList.get(guestId1Temp));
            System.out.println(guestList.get(guestId2Temp));
            System.out.println(guestList.get(guestId3Temp));

            returnString= "Total Guest Found: 3\n"+"Guest Id: "+guestId1Temp+", Guest Id: "+guestId2Temp+", Guest Id: "+guestId2Temp;
            return returnString;
        }
            return returnString;
        }
    public boolean removeGuest(int guestId, String guestLastName){
        boolean operationDone=false;
        for (int i = 0; i <guestList.size() ; i++) {
            if((guestList.get(i).getGuestId()==guestId)&&(guestList.get(i).getPersonalInfo().getLastName()==guestLastName)){

                for (int k = i; k <guestList.size()-1 ; k++) {
                        //reallocate spaces in array
                        Guest gTemp= guestList.get(k+1);
                        guestList.set(k,gTemp);
                        //reallocate GuestId
                        guestList.get(k).setGuestId(guestList.get(k).getGuestId()-1);
                }
                operationDone=true;
                break;
            }
        }
        if (operationDone=true){
            guestList.remove(guestList.size()-1);
            Guest.setBackGuestCounter();
        }
        return operationDone;

    }
    public void showAllGuest(){
        for (int i = 0; i <guestList.size() ; i++) {
            System.out.println(guestList.get(i));
        }
    }
    public Booking getBookingSearchingAllGuests( int bookingId){
        Booking bTemp=null;
        for (int i = 0; i <guestList.size() ; i++) {
            for (int j = 0; j < guestList.get(i).getGuestBookingHistory().size(); j++) {
                //Check if booking exist in array.
                if (guestList.get(i).getGuestBookingHistory().get(j).getBookingId()==bookingId) {
                    bTemp=guestList.get(i).getGuestBookingHistory().get(j);
                    break;
                    }

            }
        }return bTemp;

    }

}
