package models;

public class Taxi implements Comparable<Taxi> {
    public String manufacturer;
    public String model;
    public int age;
    public String driverFirstName;
    public String driverLastName;

    public Taxi() {}

    public Taxi(String manufacturer, String model, int age, String driverFirstName, String driverLastName)
    {
        this.manufacturer = manufacturer;
        this.model = model;
        this.age = age;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
    }

    @Override
    public String toString() {
        return String.format("| %-15s | %-10s | %5d | %-10s | %-15s |", manufacturer, model, age, driverFirstName, driverLastName);
    }

    @Override
    public int compareTo(Taxi other) {
        int manufacturerCompare = this.manufacturer.compareTo(other.manufacturer);

        if (manufacturerCompare != 0) {
            return manufacturerCompare;
        }

        return this.model.compareTo(other.model);
    }
}
