package Vehicles;
import java.util.*;

public class Vehicle {
    public Boolean isCar;
    public String brand;
    public String licenseNumber;
    public String name;
    public String type;
    public int topSpeed, gasCapacity, wheel;

    public Boolean getIsCar() {
        return isCar;
    }

    static String inputBrand() {
        do {
            System.out.print("Input brand [>= 5]: ");
            Scanner sc = new Scanner(System.in);
            String brand = sc.nextLine();
            if (brand.length() >= 5) {
                return brand;
            } else {
                System.out.print("Error: You input " + brand + " which is not a valid choice. Please input again [>= 5]! ");
                System.out.println();
            }
        } while (true);
    }

    static String inputName() {
        do {
            System.out.print("Input name [>= 5]: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            if (name.length() >= 5) {
                return name;
            } else {
                System.out.print("Error: You input " + name + " which is not a valid choice. Please input again [>= 5]! ");
                System.out.println();
            }
        } while (true);
    }

    static String inputLicenseNumber() {
        do {
            System.out.print("Input license number [A-Z 0-9 A-Z]: ");
            Scanner sc = new Scanner(System.in);
            String licenseNumber = sc.nextLine();
            if (licenseNumber.matches("^[A-Z]{1} [0-9]{1,4} [A-Z]{1,3}$")) {
                return licenseNumber;
            } else {
                System.out.print("Error: You input " + licenseNumber + " which is not a valid choice. Please input again [A-Z 0-9 A-Z]! ");
                System.out.println();
            }
        } while (true);
    }

    static int inputTopSpeed() {
        do {
            System.out.print("Input top speed [100 <= Top Speed <= 250]: ");
            Scanner sc = new Scanner(System.in);
            int topSpeed = sc.nextInt();
            if (topSpeed >= 100 && topSpeed <= 250) {
                return topSpeed;
            } else {
                System.out.print("Error: You input " + topSpeed + " which is not a valid choice. Please input again [100 <= Top Speed <= 250]! ");
                System.out.println();
            }
        } while (true);
    }

    static int inputGasCapacity() {
        do {
            System.out.print("Input gas capacity [30 <= Gas Capacity <= 60]: ");
            Scanner sc = new Scanner(System.in);
            int gasCapacity = sc.nextInt();
            if (gasCapacity >= 30 && gasCapacity <= 60) {
                return gasCapacity;
            } else {
                System.out.print("Error: You input " + gasCapacity + " which is not a valid choice. Please input again [30 <= Gas Capacity <= 60]! ");
                System.out.println();
            }
        } while (true);
    }

    public int inputWheel() {
        do {
            if (getIsCar()) {
                System.out.print("Input wheel [4 <= Wheel <= 6]: ");
            } else {
                System.out.print("Input wheel [2 <= Wheel <= 3]: ");
            }
            Scanner sc = new Scanner(System.in);
            int wheel = sc.nextInt();
            if (getIsCar()) {
                if (wheel >= 4 && wheel <= 6) {
                    return wheel;
                } else {
                    System.out.print("Error: You input " + wheel + " which is not a valid choice. Please input again [4 <= Wheel <= 6]! ");
                    System.out.println();
                }
            } else {
                if (wheel >= 2 && wheel <= 3) {
                    return wheel;
                } else {
                    System.out.print("Error: You input " + wheel + " which is not a valid choice. Please input again [2 <= Wheel <= 3]! ");
                    System.out.println();
                }
            }
        } while (true);
    }

    public String inputType() {
        do {
            if (getIsCar()) {
                System.out.print("Input type [SUV | Supercar | Minivan]: ");
            } else {
                System.out.print("Input type [Automatic | Manual]: ");
            }
            Scanner sc = new Scanner(System.in);
            String type = sc.nextLine();
            if (getIsCar()) {
                if (type.equals("SUV") || type.equals("Supercar") || type.equals("Minivan")) {
                    return type;
                } else {
                    System.out.print("Error: You input " + type + " which is not a valid choice. Please input again [SUV | Supercar | Minivan]! ");
                    System.out.println();
                }
            } else {
                if (type.equals("Automatic") || type.equals("Manual")) {
                    return type;
                } else {
                    System.out.print("Error: You input " + type + " which is not a valid choice. Please input again [Automatic | Manual]! ");
                    System.out.println();
                }
            }
        } while (true);
    }
}