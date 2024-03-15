import java.util.*;
class Contact {
     String firstName;
     String lastName;
     String address;
     String city;
     String state;
     String zip;
     String phoneNumber;
     String email;

     Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Override
    public String toString() {
        return
                "firstName= " + firstName + "\n" +
                "lastName= " + lastName + "\n" +
                "address= " + address + "\n" +
                "city= " + city + "\n" +
                "state= " + state + "\n" +
                "zip= " + zip + "\n" +
                "phoneNumber= " + phoneNumber + "\n" +
                "email= " + email ;
    }

}

public class AddressBookSystem {



    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program....");
        System.out.println("Contact created...");
        Contact c = new Contact("Nisha","Mali", "a/p Gadmudshingi", "Kolhapur",
                "Maharashtra", "416119","9808080867", "nishamali@gmail.com");

        System.out.println("Contacts: \n"+ c);

    }


}
