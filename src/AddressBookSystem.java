import java.util.*;

public class AddressBookSystem
{
    private HashMap<String, AddressBook> addressBooks = new HashMap<>();
    static Scanner sc = new Scanner(System.in);


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
            System.out.println("1. Create New Address Book");
            System.out.println("2. Open Address Book");
            System.out.println("3. Search Person by City or State");
            System.out.println("4. Count contact by city");
            System.out.println("5. Count contact by State");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    createAddressBook();
                    break;
                case 2:
                    openAddressBook();
                    break;
                case 3:
                    searchPersonByCityState();
                    break;
                case 4:
                    countContactsByCity();
                    break;
                case 5:
                    countContactsByState();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice...");
            }
        }
    }

    void createAddressBook()
    {
        System.out.print("Enter the name of the new Address Book: ");
        String newAddressBookName = sc.nextLine();

        if (addressBooks.containsKey(newAddressBookName))
        {
            System.out.println("Address Book already exists!");
        }
        else
        {
            AddressBook newAddressBook = new AddressBook(newAddressBookName);
            addressBooks.put(newAddressBookName, newAddressBook);
            System.out.println("New Address Book created successfully!");
            runAddressBookMenu(newAddressBook);
        }
    }

    void openAddressBook()
    {
        System.out.print("Enter the name of the Address Book : ");
        String addressBookName = sc.nextLine();

        if (addressBooks.containsKey(addressBookName))
        {
            AddressBook addressBook = addressBooks.get(addressBookName);
            runAddressBookMenu(addressBook);
        } else {
            System.out.println("Address Book does not exist!");
        }
    }

    void runAddressBookMenu(AddressBook addressBook)
    {
        System.out.println("Welcome to " + addressBook.getAddressBookName() + " Address Book...");

        while (true)
        {
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View person by city");
            System.out.println("5. View person by state");
            System.out.println("6. Go Back");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    addressBook.addContact(sc);
                    break;
                case 2:
                    addressBook.editContact(sc);
                    break;
                case 3:
                    addressBook.deleteContact(sc);
                    break;
                case 4:
                    viewPersonsByCity(addressBook);
                    break;
                case 5:
                    viewPersonsByState(addressBook);
                    break;
                case 6:
                    System.out.println("Going back...");
                    return;
                default:
                    System.out.println("Invalid choice...");
            }
        }
    }

    //Search person
    void searchPersonByCityState()
    {
        System.out.print("Enter city or state to search for persons: ");
        String cityOrState = sc.nextLine();

        List<Contact> matchingContacts = new ArrayList<>();
        for (AddressBook addressBook : addressBooks.values())
        {
            matchingContacts.addAll(addressBook.searchPersonByCityState(cityOrState));
        }

        if (matchingContacts.isEmpty())
        {
            System.out.println("No matching contacts found in any address book.");
        } else
        {
            System.out.println("Matching contacts found in the following address books:");
            for (Contact contact : matchingContacts)
            {
                System.out.println(contact);
                System.out.println();
            }
        }
    }

    //View  persons
    void viewPersonsByCity(AddressBook addressBook) {
        System.out.print("Enter the city to search: ");
        String city = sc.nextLine();
        System.out.println("Persons in " + city + ":");
        addressBook.viewPersonsByCity(city);
    }

    void viewPersonsByState(AddressBook addressBook) {
        System.out.print("Enter the state to search: ");
        String state = sc.nextLine();
        System.out.println("Persons in " + state + ":");
        addressBook.viewPersonsByState(state);
    }

    //count persons:
    void countContactsByCity() {
        System.out.print("Enter the city to count contacts: ");
        String city = sc.nextLine();
        long count = addressBooks.values().stream()
                .mapToLong(addressBook -> addressBook.countContactsByCity(city))
                .sum();
        System.out.println("\nTotal contacts in " + city + ": " + count);
    }

    void countContactsByState() {
        System.out.print("Enter the state to count contacts: ");
        String state = sc.nextLine();
        long count = addressBooks.values().stream()
                .mapToLong(addressBook -> addressBook.countContactsByState(state))
                .sum();
        System.out.println("\nTotal contacts in " + state + ": " + count);
    }
}
