import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}