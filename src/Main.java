import Vehicles.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Vector<Car> cars = new Vector<>();
    static Vector<Motorcycle> motorcycles = new Vector<>();
    public static void main(String[] args) {
        clearScreen();
        int choice = menu();
        switch (choice) {
            case 1:
                addNewVehicle();
                break;
            case 2:
                displayAllVehicles();
                break;
            case 3:
                exitProgram();
                break;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void exitProgram() {
        System.out.println("Thank you for using our program!");
        System.exit(0);
    }

    public static int menu() {
        do {
            System.out.println("=== Main Menu ===");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. Display all vehicles");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = sc.nextInt();
            if (choice >= 1 && choice <= 3) {
                return choice;
            } else {
                clearScreen();
                System.out.print(
                        "Error: You choose " + choice + " which is not a valid choice. Please choose again (1-3)! ");
                System.out.println();
            }
        } while (true);
    }

    public static Boolean isCar() {
        sc.nextLine(); clearScreen();
        do {
            System.out.print("Input type [Car | Motorcycle]: ");
            String type = sc.nextLine();
            if (type.equals("Car")) {
                return true;
            } else if (type.equals("Motorcycle")) {
                return false;
            } else {
                System.out.print("Error: You input " + type + " which is not a valid choice. Please input again [Car | Motorcycle]! ");
                System.out.println();
            }
        } while (true);
    }

    public static void addNewVehicle() {
        if (isCar()) {
            cars.add(new Car());
        } else {
            motorcycles.add(new Motorcycle());
        }
        System.out.println("ENTER to return");
        sc.nextLine();
        main(null);
    }

    public static void displayAllVehicles() {
        clearScreen();
        Vector<Vehicle> vehicles = new Vector<>();
        for (Car car : cars) {
            vehicles.add(car);
        }
        for (Motorcycle motorcycle : motorcycles) {
            vehicles.add(motorcycle);
        }
        Collections.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println("|-----|---------------|---------------|");
        System.out.println("|No   |Type           |Name           |");
        System.out.println("|-----|---------------|---------------|");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.printf("|%-5d|%-15s|%-15s|\n", i + 1, (vehicles.elementAt(i).isCar ? "Car" : "Motorcycle"), vehicles.elementAt(i).name);
            System.out.println("|-----|---------------|---------------|");
        }
        System.out.println("|-----|---------------|---------------|");
        System.out.println("Pick a vehicle number to test drive [Enter '0' to exit]: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice == 0) {
            main(null);
        } else if (choice > 0 && choice <= vehicles.size()) {
            System.out.println("Brand: " + vehicles.elementAt(choice - 1).brand);
            System.out.println("Name: " + vehicles.elementAt(choice - 1).name);
            System.out.println("License Plate: " + vehicles.elementAt(choice - 1).licenseNumber);
            System.out.println("Type: " + vehicles.elementAt(choice - 1).type);
            System.out.println("Gas Capacity: " + vehicles.elementAt(choice - 1).gasCapacity);
            System.out.println("Top Speed: " + vehicles.elementAt(choice - 1).topSpeed);
            System.out.println("Wheel(s): " + vehicles.elementAt(choice - 1).wheel);
            if (vehicles.elementAt(choice - 1).isCar) {
                System.out.println("Entertainment System: " + ((Car) vehicles.elementAt(choice - 1)).entertainmentSystem);
                System.out.println("Turning on entertainment system...");
                ((Car) vehicles.elementAt(choice - 1)).entertainment();
            } else {
                System.out.println("Helm: " + ((Motorcycle) vehicles.elementAt(choice - 1)).helm);
                System.out.printf("Price: ");
                int price = sc.nextInt();
                sc.nextLine();
                System.out.println("Total Price: " + ((Motorcycle) vehicles.elementAt(choice - 1)).helm * price);
                ((Motorcycle) vehicles.elementAt(choice - 1)).entertainment();
            }
            System.out.println("ENTER to return");
            sc.nextLine();
            main(null);
        } else {
            displayAllVehicles();
        }
    }
}