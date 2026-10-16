# Taxi Fleet Analytics

A console-based fleet analysis and driver relational mapping system built in Java, utilizing custom generic linked lists, selection sorting, and formatted tabular reporting[cite: 6, 7, 8, 9, 10, 11, 12, 13].

---

## Features

- **Relational Joining:** Relates vehicles and drivers in-memory using registration license plate numbers as the relational key[cite: 13].
- **Dynamic Age Filtering:** Calculates vehicle age relative to the current year and filters the fleet based on user-defined minimum and maximum age bounds[cite: 9, 13].
- **Utilization Analysis:** Identifies the most exploited vehicle (highest cumulative mileage) and retrieves its assigned driver[cite: 13].
- **In-Place Sorting:** Implements selection sort on custom linked lists using `Comparable<Taxi>` (sorted by manufacturer, then by model)[cite: 8, 11].
- **Duplicate Elimination:** Filters and extracts unique manufacturers from the active fleet[cite: 13].
- **Formatted Tabular Reporting:** Generates clean ASCII table reports printed simultaneously to standard console output and persistent file storage (`Results.txt`)[cite: 9, 10].

---

## Data Specifications

The application reads from two delimited plain text files[cite: 9, 10]. Values must be separated by a **semicolon followed by a space (`"; "`)**[cite: 10].

### 1. Driver Data File (`U18a.txt`)
Stores the registry of licensed drivers[cite: 9, 10].
```text
Format:
<First_Name>; <Last_Name>; <License_Plate>

Example:
Jonas; Jonaitis; ABC123
Petras; Petraitis; DEF456
```

### 2. Vehicle Data File (`U18b.txt`)
Stores technical details and odometer readings of the fleet[cite: 6, 9, 10].
```text
Format:
<Make>; <Model>; <License_Plate>; <Manufacture_Year>; <Mileage>

Example:
Toyota; Prius; ABC123; 2018; 185000
Volkswagen; Passat; DEF456; 2014; 290000
```

---

## Project Structure

```text
├── models/
│   ├── Car.java       # Vehicle entity (manufacturer, model, plate, year, mileage)
│   ├── Driver.java    # Driver entity (firstName, lastName, plate)
│   └── Taxi.java      # Combined relational entity implementing Comparable
├── utils/
│   ├── List.java      # Custom generic list interface
│   ├── LinkList.java  # Singly-linked list implementation (Node, Sort, Iterator)
│   ├── InOut.java     # File parsing and formatted table reporting
│   └── Task.java      # Business logic (filtering, finding max, deduplication)
├── Main.java          # Application entry point
├── U18a.txt           # Input: Driver data
├── U18b.txt           # Input: Vehicle data
└── Results.txt        # Generated output report
```

---

## How to Run

### Option A: Via IntelliJ IDEA
1. Open the project root folder in **IntelliJ IDEA**.
2. Verify that the Project SDK is configured for **Java 11+** (`File` → `Project Structure` → `Project`).
3. Ensure input files (`U18a.txt` and `U18b.txt`) are present in the project working directory[cite: 9].
4. Open `Main.java` and click **Run** (`Shift + F10`)[cite: 9].

### Option B: Via Command Line (Terminal)
1. Navigate to the `src` directory:
```bash
javac -d ../out $(find . -name "*.java")
cd ..
```
2. Execute the compiled application[cite: 9]:
```bash
java -cp out com.company.Main
```

---

## Program Execution Workflow

```text
1. Input Prompt
   Enter minimum car age: 3
   Enter maximum car age: 10

2. Ingestion
   Reads U18a.txt and U18b.txt into generic LinkList structures.

3. Processing
   - Performs relational match on license plates.
   - Filters vehicles by calculated age bounds.
   - Detects the vehicle with maximum mileage and pairs its driver.
   - Applies in-place selection sort on taxis (by make, then model).
   - Eliminates redundant manufacturers.

4. Output
   Streams tabular reports to standard console output and writes Results.txt.
```
