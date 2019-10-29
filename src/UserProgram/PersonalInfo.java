package UserProgram;

public class PersonalInfo {
    private String firstName;
    private String lastName;
    private int phoneNumber;

    public PersonalInfo (String firstName, String lastName, int phoneNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;

    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return " / First name: "+firstName+" / Last name: "+lastName+"/ Phone number: "+phoneNumber;
    }
}
