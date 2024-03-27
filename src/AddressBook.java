import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class AddressBook
{
    private ArrayList<Contact> contacts = new ArrayList<>();
    private String addressBookName;

    AddressBook(String addressBookName)
    {
        this.addressBookName = addressBookName;
    }

    void addContact(Scanner sc) {
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        boolean isDuplicate = contacts.stream()
                .anyMatch(contact -> contact.firstName.equalsIgnoreCase(firstName) && contact.lastName.equalsIgnoreCase(lastName));

        if (isDuplicate) {
            System.out.println("Contact with the same name already exists! Cannot add duplicate entry.");
        } else {
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            System.out.print("Enter City: ");
            String city = sc.nextLine();
            System.out.print("Enter State: ");
            String state = sc.nextLine();
            System.out.print("Enter Zip: ");
            String zip = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            String phoneNumber = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
            contacts.add(contact);
            System.out.println();
            System.out.println("Contact added successfully! \n");
        }
    }

    void editContact(Scanner sc)
    {
        System.out.println("Enter the first name of the contact to edit: ");
        String fnameToEdit = sc.nextLine();
        for (Contact contact : contacts)
        {
            if (contact.firstName.equalsIgnoreCase(fnameToEdit))
            {
                System.out.println("Enter the new details:");
                System.out.print("Enter Last Name: ");
                contact.lastName = sc.nextLine();
                System.out.print("Enter Address: ");
                contact.address = sc.nextLine();
                System.out.print("Enter City: ");
                contact.city = sc.nextLine();
                System.out.print("Enter State: ");
                contact.state = sc.nextLine();
                System.out.print("Enter Zip: ");
                contact.zip = sc.nextLine();
                System.out.print("Enter Phone Number: ");
                contact.phoneNumber = sc.nextLine();
                System.out.print("Enter Email: ");
                contact.email = sc.nextLine();
                System.out.println("Contact details updated successfully! \n");
                System.out.println("Updated Contact Details:");
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    void deleteContact(Scanner sc)
    {
        System.out.println("Enter the first name of the contact to delete: ");
        String fnameToDelete = sc.nextLine();
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext())
        {
            Contact contact = iterator.next();
            if (contact.firstName.equalsIgnoreCase(fnameToDelete))
            {
                iterator.remove();
                System.out.println("Contact deleted successfully! \n");
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    String getAddressBookName() {
        return addressBookName;
    }

    //search person
    List<Contact> searchPersonByCityState(String cityOrState)
    {
        return contacts.stream()
                .filter(contact -> contact.city.equalsIgnoreCase(cityOrState) || contact.state.equalsIgnoreCase(cityOrState))
                .collect(Collectors.toList());
    }

    //View Persons
    void viewPersonsByCity(String city)
    {
        contacts.stream()
                .filter(contact -> contact.city.equalsIgnoreCase(city))
                .forEach(System.out::println);
    }

    void viewPersonsByState(String state)
    {
        contacts.stream()
                .filter(contact -> contact.state.equalsIgnoreCase(state))
                .forEach(System.out::println);
    }

    //Count contacts:
    long countContactsByCity(String city) {
        return contacts.stream()
                .filter(contact -> contact.city.equalsIgnoreCase(city))
                .count();
    }

    long countContactsByState(String state) {
        return contacts.stream()
                .filter(contact -> contact.state.equalsIgnoreCase(state))
                .count();
    }
}