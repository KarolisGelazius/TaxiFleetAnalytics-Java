package models;

public class Driver {
    public String firstName;
    public String lastName;
    public String carNumbers;

    public Driver(String firstName, String lastName, String carNumbers)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.carNumbers = carNumbers;
    }

    public Driver() {}

    @Override
    public String toString() {
        return String.format("| %-15s | %-15s | %-15s |", firstName, lastName, carNumbers);
    }
}
