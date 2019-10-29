package UserProgram;

public class User {

    private static int userCounter;
    private final int userId;
    private PersonalInfo userInfo;
    private LoginCredentials userLogin;

    public User (String firstName, String lastName, int phoneNumber, String userName, String userPassword){
        this.userInfo=new PersonalInfo(firstName, lastName, phoneNumber);
        setUserLogin(userName, userPassword);
        this.userId=userCounter;
        userCounter++;
    }
    public static int getUserCounter(){
        return userCounter;
    }
    public void setUserLogin(String userName, String userPassword){
        this.userLogin= new LoginCredentials(userName,userPassword);
    }
    public PersonalInfo getUserInfo() {
        return userInfo;
    }
    public int getUserId(){
        return userId;
    }
    public String toString(){
        return "User Id: "+userId+ userInfo;
    }
}
