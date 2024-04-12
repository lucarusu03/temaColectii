package ro.ulbs.tema;

public class Contact {
    String firstName;
    String lastName;
    String phoneNumber;
    String phoneType;

    public Contact(String firstName, String lastName, String phoneNumber, String phoneType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    public void printContact(){
        System.out.println(this.firstName + " " + this.lastName + " " + this.phoneNumber
        + " " + this.phoneType);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public String toString() {
        return firstName + " " + lastName + " " + phoneNumber + " " + phoneType;
    }
}
