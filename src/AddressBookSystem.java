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
            System.out.println("3. Exit");
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
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice...");
            }
        }
    }

     void createAddressBook() {
         System.out.print("Enter the name of the new Address Book: ");
         String newAddressBookName = sc.nextLine();

         if (addressBooks.containsKey(newAddressBookName)) {
             System.out.println("Address Book already exists!");
         } else {
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
        }
        else
        {
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
            System.out.println("4. Go Back");
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
                    System.out.println("Going back...");
                    return;
                default:
                    System.out.println("Invalid choice...");
            }
        }
    }
}

