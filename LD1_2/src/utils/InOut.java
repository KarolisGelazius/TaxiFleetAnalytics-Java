package utils;

import models.Car;
import models.Driver;
import models.Taxi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InOut {
    public static LinkList<Car> ReadCarFile(String fileName) {
        LinkList<Car> carList = new LinkList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));

            for (String line : lines) {
                String[] parts = line.split("; ");

                String manufacturer = parts[0];
                String model = parts[1];
                String carNumbers = parts[2];
                int manufacturingYear = Integer.parseInt(parts[3]);
                int mileage = Integer.parseInt(parts[4]);

                carList.add(new Car(manufacturer, model, carNumbers, manufacturingYear, mileage));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return carList;
    }

    public static LinkList<Driver> ReadDriverFile(String fileName) {
        LinkList<Driver> driverList = new LinkList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));

            for (String line : lines) {
                String[] parts = line.split("; ");

                String firstName = parts[0];
                String lastName = parts[1];
                String carNumbers = parts[2];

                driverList.add(new Driver(firstName, lastName, carNumbers));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return driverList;
    }

    public static void printCarDataToConsole(String title, LinkList<Car> carList) {
        System.out.println("-".repeat(96));
        System.out.printf("| %-92s |%n", title);
        System.out.println("-".repeat(96));
        System.out.printf("| %-15s | %-15s | %-15s | %-20s | %-15s |%n", "Manufacturer", "Model", "Car Numbers", "Manufacturing Year", "Mileage");
        System.out.println("-".repeat(96));
        for (Car car : carList) {
            System.out.println(car.toString());
        }
        System.out.println("-".repeat(96));
        System.out.println();
    }

    public static void printCarDataToFile(String title, LinkList<Car> carList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("-".repeat(96));
            writer.newLine();
            writer.write(String.format("| %-92s |%n", title));
            writer.write("-".repeat(96));
            writer.newLine();
            writer.write(String.format("| %-15s | %-15s | %-15s | %-20s | %-15s |%n", "Manufacturer", "Model", "Car Numbers", "Manufacturing Year", "Mileage"));
            writer.write("-".repeat(96));
            writer.newLine();
            for (Car car : carList) {
                writer.write(car.toString());
                writer.newLine();
            }
            writer.write("-".repeat(96));
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printDriverDataToConsole(String title, LinkList<Driver> driverList) {
        System.out.println("-".repeat(55));
        System.out.printf("| %-51s |%n", title);
        System.out.println("-".repeat(55));
        System.out.printf("| %-15s | %-15s | %-15s |%n", "First Name", "Last Name", "Car Numbers");
        System.out.println("-".repeat(55));
        for (Driver driver : driverList) {
            System.out.println(driver.toString());
        }
        System.out.println("-".repeat(55));
        System.out.println();
    }

    public static void printDriverDataToFile(String title, LinkList<Driver> driverList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("-".repeat(55));
            writer.newLine();
            writer.write(String.format("| %-51s |%n", title));
            writer.write("-".repeat(55));
            writer.newLine();
            writer.write(String.format("| %-15s | %-15s | %-15s |%n", "First Name", "Last Name", "Car Numbers"));
            writer.write("-".repeat(55));
            writer.newLine();
            for (Driver driver : driverList) {
                writer.write(driver.toString());
                writer.newLine();
            }
            writer.write("-".repeat(55));
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printTaxiDataToConsole(String title, LinkList<Taxi> taxiList) {
        System.out.println("-".repeat(71));
        System.out.printf("| %-67s |%n", title);
        System.out.println("-".repeat(71));
        System.out.printf("| %-15s | %-10s | %-5s | %-10s | %-15s |%n", "Manufacturer", "Model", "Age", "First Name", "Last Name");
        System.out.println("-".repeat(71));
        for (Taxi taxi : taxiList) {
            System.out.println(taxi.toString());
        }
        System.out.println("-".repeat(71));
        System.out.println();
    }

    public static void printTaxiDataToFile(String title, LinkList<Taxi> taxiList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("-".repeat(71));
            writer.newLine();
            writer.write(String.format("| %-67s |%n", title));
            writer.write("-".repeat(71));
            writer.newLine();
            writer.write(String.format("| %-15s | %-10s | %-5s | %-10s | %-15s |%n", "Manufacturer", "Model", "Age", "First Name", "Last Name"));
            writer.write("-".repeat(71));
            writer.newLine();
            for (Taxi taxi : taxiList) {
                writer.write(taxi.toString());
                writer.newLine();
            }
            writer.write("-".repeat(71));
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printUniqueManufacturers(String title, LinkList<Taxi> taxiList) {
        System.out.println("-".repeat(24));
        System.out.printf("| %-20s |%n", title);
        System.out.println("-".repeat(24));
        System.out.printf("| %-20s |%n", "Manufacturer");
        System.out.println("-".repeat(24));
        for (Taxi taxi : taxiList) {
            System.out.printf("| %-20s |%n", taxi.manufacturer);
        }
        System.out.println("-".repeat(24));
        System.out.println();
    }

    public static void printUniqueManufacturersToFile(String title, LinkList<Taxi> taxiList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("-".repeat(24));
            writer.newLine();
            writer.write(String.format("| %-20s |%n", title));
            writer.write("-".repeat(24));
            writer.newLine();
            writer.write(String.format("| %-20s |%n", "Manufacturer"));
            writer.write("-".repeat(24));
            writer.newLine();
            for (Taxi taxi : taxiList) {
                writer.write(String.format("| %-20s |%n", taxi.manufacturer));
            }
            writer.write("-".repeat(24));
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
