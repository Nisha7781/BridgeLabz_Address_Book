import java.util.*;

class Contact
{
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;

    Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email)
    {
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
    public String toString()
    {
        return "firstName= " + firstName + "\n" +
                "lastName= " + lastName + "\n" +
                "address= " + address + "\n" +
                "city= " + city + "\n" +
                "state= " + state + "\n" +
                "zip= " + zip + "\n" +
                "phoneNumber= " + phoneNumber + "\n" +
                "email= " + email;
    }
}

public class AddressBookSystem
{
    private ArrayList<Contact> contacts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Welcome to Address Book Program.... \n");

        AddressBookSystem abs = new AddressBookSystem();
        abs.AddressBook();
    }

    public void AddressBook()
    {
        while (true)
        {
            System.out.println("Address Book System");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice...");
            }
        }
    }

    void addContact()
    {
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
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

     void editContact()
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

    void deleteContact()
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
}
