package com.company;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;
import models.*;
import utils.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String driverInputFile = "U18a.txt";
        String carInputFile = "U18b.txt";
        String resultsFile = "Results.txt";

        new File(resultsFile).delete();

        System.out.print("Enter minimum car age: ");
        int minAge = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter maximum car age: ");
        int maxAge = Integer.parseInt(scanner.nextLine());

        LinkList<Car> carList = InOut.ReadCarFile(carInputFile);
        LinkList<Driver> driverList = InOut.ReadDriverFile(driverInputFile);

        InOut.printCarDataToConsole("Starting Car information", carList);
        InOut.printCarDataToFile("Starting Car information", carList, resultsFile);
        InOut.printDriverDataToConsole("Starting Driver information", driverList);
        InOut.printDriverDataToFile("Starting Driver information", driverList, resultsFile);

        LinkList<Taxi> taxiList = Task.CreateTaxiList(carList, driverList, minAge, maxAge);
        InOut.printTaxiDataToConsole("Taxi information", taxiList);
        InOut.printTaxiDataToFile("Taxi information", taxiList, resultsFile);

        Car mostExplotedCar = Task.FindMostExploitedCar(carList);
        LinkList<Car> mostExploitedCarList = new LinkList<>();
        mostExploitedCarList.add(mostExplotedCar);

        Driver mostExploitedCarDriver = Task.FindDriver(driverList, mostExplotedCar.carNumbers);
        LinkList<Driver> mostExploitedCarDriverList = new LinkList<>();
        mostExploitedCarDriverList.add(mostExploitedCarDriver);

        InOut.printCarDataToConsole("Most exploited car", mostExploitedCarList);
        InOut.printCarDataToFile("Most exploited car", mostExploitedCarList, resultsFile);
        InOut.printDriverDataToConsole("Most exploited car driver", mostExploitedCarDriverList);
        InOut.printDriverDataToFile("Most exploited car driver", mostExploitedCarDriverList, resultsFile);

        taxiList.sort();

        InOut.printTaxiDataToConsole("Sorted taxi information", taxiList);
        InOut.printTaxiDataToFile("Sorted taxi information", taxiList, resultsFile);

        LinkList<Taxi> uniqueManufacturers = Task.FindUniqueManufacturers(taxiList);
        InOut.printUniqueManufacturers("Unique Manufacturers", uniqueManufacturers);
        InOut.printUniqueManufacturersToFile("Unique Manufacturers", uniqueManufacturers, resultsFile);
    }
}