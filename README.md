# Taxi Fleet Analytics

A console-based fleet analysis and driver relational mapping system built in Java, utilizing custom generic linked lists, selection sorting, and formatted tabular reporting.

---

## Features

- **Relational Joining:** Relates vehicles and drivers in-memory using registration license plate numbers as the key.
- **Dynamic Age Filtering:** Calculates vehicle age relative to the current year and filters the fleet based on user-defined minimum and maximum age bounds.
- **Utilization Analysis:** Identifies the most exploited vehicle (highest cumulative mileage) and retrieves its assigned driver.
- **In-Place Sorting:** Implements selection sort on custom linked lists using `Comparable<Taxi>` (sorted by manufacturer, then by model).
- **Duplicate Elimination:** Filters and extracts unique manufacturers from the active fleet.
- **Formatted Tabular Reporting:** Generates clean ASCII table reports printed simultaneously to standard console output and persistent file storage (`Results.txt`).

---

## Data Specifications

The application reads from two delimited plain text files. Values must be separated by a **semicolon followed by a space (`"; "`)**.

### 1. Driver Data File (`U18a.txt`)
Stores the registry of licensed drivers.
* **Format:** `<First_Name>; <Last_Name>; <License_Plate>`
* **Example:**
  ```text
  Jonas; Jonaitis; ABC123
  Petras; Petraitis; DEF456
