import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class VehicleManagement {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addVehicle(vehicleList, scanner);
                    break;
                case 2:
                    displayVehicleList(vehicleList);
                    break;
                case 3:
                    deleteVehicle(vehicleList, scanner);
                    break;
                case 4:
                    while (true) {
        System.out.println("\nSort Menu:");
        System.out.println("1. Sort by age (ascending)");
        System.out.println("2. Sort by age (descending)");
        System.out.println("3. Back to main menu");
        System.out.print("Enter your choice: ");
        int sortChoice = scanner.nextInt();
        switch (sortChoice) {
            case 1:
                sortVehicleListByAge(vehicleList, true);
                break;
            case 2:
                sortVehicleListByAge(vehicleList, false);
                break;
            case 3:
                System.out.println("Returning to main menu...\n");
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
        }
        if (sortChoice == 3) {
            break;
        }
    }
    break;                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addVehicle(ArrayList<Vehicle> vehicleList, Scanner scanner) {
        System.out.println("Enter vehicle details");
        System.out.print("Enter Registration Number: ");
        String regNo = scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Year of Manufacture: ");
        int yearOfManufacture = scanner.nextInt();
        System.out.print("Value: ");
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
        vehicleList.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private static void displayVehicleList(ArrayList<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to display.");
        } else {
            System.out.println("List of vehicles:");
            for (Vehicle vehicle : vehicleList) {
                System.out.println(vehicle);
            }
        }
    }

    private static void deleteVehicle(ArrayList<Vehicle> vehicleList, Scanner scanner) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to delete.");
            return;
        }
        System.out.print("Enter the index of the vehicle to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (index < 0 || index >= vehicleList.size()) {
            System.out.println("Invalid index.");
        } else {
            vehicleList.remove(index);
            System.out.println("Vehicle deleted successfully.");
        }
    }

    private static void sortVehicleListByAge(ArrayList<Vehicle> vehicleList, boolean ascending) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to sort.");
        } else {
        Comparator<Vehicle> comparator = Comparator.comparingInt(Vehicle::getYearOfManufacture);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        vehicleList.sort(comparator); // Sort the list
        System.out.println("List of vehicle details sorted by age (" + (ascending ? "ascending" : "descending") + "):");
        displayVehicleList(vehicleList); // Display the sorted list
        }
    }
}

class Vehicle {
    private String regNo;
    private String make;
    private int yearOfManufacture;
    private double value;

    public Vehicle(String regNo, String make, int yearOfManufacture, double value) {
        this.regNo = regNo;
        this.make = make;
        this.yearOfManufacture = yearOfManufacture;
        this.value = value;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Registration Number: " + regNo + ", Make: " + make + ", Year of Manufacture: " + yearOfManufacture + ", Value: " + value;
    }
}