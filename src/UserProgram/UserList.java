package UserProgram;

import java.util.ArrayList;

//CLASS NOT IN USE (YET)

public class UserList {
        private ArrayList<User> userList;

        public UserList(){
            this.userList=new ArrayList<User>();
        }
        public String addUser(String firstName,String lastName, int phoneNumber, String userName, String userPassword){
            boolean operationDone=false;
            int userId=-1;
            boolean executeOperation=true;
            for (int i = 0; i <userList.size() ; i++) {
                if ((userList.get(i).getUserInfo().getFirstName() == firstName) && (userList.get(i).getUserInfo().getLastName() == lastName) && (userList.get(i).getUserInfo().getPhoneNumber() == phoneNumber)) {
                    System.out.println("The user already exist in the system");
                    executeOperation = false;
                    break;
                }
            }
            /*Only after the previous expression verify that the User does not exist on the system, Only then it will add it

             */
            if(executeOperation==true){
                userList.add(new User(firstName,lastName,phoneNumber,userName,userPassword));
                operationDone=true;
            }

                /*Search and return the Id number of the guest
                this technique is used to avoid obtaining the wrong value when more than one guest is created at the same time by other users
                 */
            for (int j = 0; j <userList.size() ; j++) {
                if((userList.get(j).getUserInfo().getFirstName()==firstName)&&(userList.get(j).getUserInfo().getLastName()==lastName)&&(userList.get(j).getUserInfo().getPhoneNumber()==phoneNumber)) {
                    userId=userList.get(j).getUserId();
                }
            }
            //If operation was successful the guestId will be other than -1
            return "Operation complete:"+operationDone+ "/ User ID: "+userId ;
        }
        public User getUser(int userId){
            User userTemp=null;
            for (int i = 0; i <userList.size() ; i++) {
                if(userList.get(i).getUserId()==userId){
                    userTemp=userList.get(i);
                    break;
                }
            }
            return userTemp;
        }
        public String getUserInfoByLastName(String lastName){
            //Get the user Id by lastName returning up to three Guests with the same last Name
            int guestId1Temp=-1;
            int guestId2Temp=-1;
            int guestId3Temp=-1;
            int counter=0;
            String returnString="";
            for (int i = 0; i <userList.size() ; i++) {
                if(userList.get(i).getUserInfo().getLastName()==lastName){
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
                returnString="There are no Users with the specified Last Name";
                return returnString;
            }else if((guestId1Temp!=-1)&&(guestId2Temp==-1)&&(guestId3Temp==-1)){
                //option to print all user info
                System.out.println(userList.get(guestId1Temp));
                //option to return string with ID
                returnString= "User Id: "+guestId1Temp;
                return returnString;
            }else if((guestId1Temp!=-1)&&(guestId2Temp!=-1)&&(guestId3Temp==-1)){
                System.out.println(userList.get(guestId1Temp));
                System.out.println(userList.get(guestId2Temp));
                returnString= "Total Guest Found: 2\n"+"User Id: "+guestId1Temp+", User Id: "+guestId2Temp;
                return returnString;
            }else if((guestId1Temp!=-1)&&(guestId2Temp!=-1)&&(guestId3Temp!=-1)){
                System.out.println(userList.get(guestId1Temp));
                System.out.println(userList.get(guestId2Temp));
                System.out.println(userList.get(guestId3Temp));

                returnString= "Total Guest Found: 3\n"+"User Id: "+guestId1Temp+", User Id: "+guestId2Temp+", User Id: "+guestId2Temp;
                return returnString;
            }
            return returnString;
        }
        public void showAllUser(){
            for (int i = 0; i <userList.size() ; i++) {
                System.out.println(userList.get(i));
            }





    }

}
