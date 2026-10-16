package models;

public class Car {
    public String manufacturer;
    public String model;
    public String carNumbers;
    public int manufacturingYear;
    public int mileage;

    public Car(String manufacturer, String model, String carNumbers, int manufacturingYear, int mileage) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.carNumbers = carNumbers;
        this.manufacturingYear = manufacturingYear;
        this.mileage = mileage;
    }

    public Car() {}

    @Override
    public String toString() {
        return String.format("| %-15s | %-15s | %-15s | %20d | %15d |", manufacturer, model, carNumbers, manufacturingYear, mileage);
    }
}
