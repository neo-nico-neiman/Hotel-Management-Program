package UserProgram;

public class LoginCredentials {

    private String userName;
    private String userPassword;

    public LoginCredentials(String userName, String userPassword){
        this.userName=userName;
        this.userPassword=userPassword;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    private void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public void changePassword(String oldPassword, String newPassword){
        if(oldPassword.equals(userPassword)){
            this.userPassword=newPassword;
        }
    }

}
