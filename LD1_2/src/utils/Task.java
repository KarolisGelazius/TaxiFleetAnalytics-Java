package utils;

import models.*;
import java.time.Year;
import java.util.Iterator;

public class Task {
    public static LinkList<Taxi> CreateTaxiList(LinkList<Car> carList, LinkList<Driver> driverList, int minAge, int maxAge) {
        LinkList<Taxi> taxiList = new LinkList<>();
        int currentYear = Year.now().getValue();

        for (int i = 0; i < carList.size(); i++) {
            for (int j = 0; j < driverList.size(); j++) {
                if (carList.get(i).carNumbers.equals(driverList.get(j).carNumbers)) {
                    int age = currentYear - carList.get(i).manufacturingYear;
                    if (age >= minAge && age <= maxAge) {
                        Taxi taxi = new Taxi(carList.get(i).manufacturer, carList.get(i).model, age, driverList.get(i).firstName, driverList.get(i).lastName);
                        taxiList.add(taxi);
                    }
                }
            }
        }

        return taxiList;
    }

    public static Car FindMostExploitedCar(LinkList<Car> carList) {
        Car maxCar = null;

        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);

            if (maxCar == null || car.mileage > maxCar.mileage) {
                maxCar = car;
            }
        }

        return maxCar;
    }

    public static Driver FindDriver(LinkList<Driver> driverList, String carNumbers) {
        for (int i = 0; i < driverList.size(); i++) {
            Driver driver = driverList.get(i);

            if (driver.carNumbers.equals(carNumbers)) {
                return driver;
            }
        }

        return null;
    }

    public static LinkList<Taxi> FindUniqueManufacturers(LinkList<Taxi> taxiList) {
        LinkList<String> seenManufacturers = new LinkList<>();

        for (int i = 0; i < taxiList.size(); i++) {
            boolean alreadySeen = false;
            for (int j = 0; j < seenManufacturers.size(); j++) {
                if (taxiList.get(i).manufacturer.equals(seenManufacturers.get(j))) {
                    alreadySeen = true;
                    break;
                }
            }

            if (!alreadySeen) {
                seenManufacturers.add(taxiList.get(i).manufacturer);
            } else {
                taxiList.remove(taxiList.get(i));
                i--;
            }
        }

        return taxiList;
    }
}
