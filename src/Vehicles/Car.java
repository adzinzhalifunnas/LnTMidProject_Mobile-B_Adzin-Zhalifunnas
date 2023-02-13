package Vehicles;
import java.util.*;

public class Car extends Vehicle {
    public int entertainmentSystem;

    public void entertainment() {
        if (this.type.equals("Supercar")) {
            System.out.println("Boosting!");
        }
    }

    public int inputEntertainmentSystem() {
        do {
            System.out.print("Input entertainment system amount [>= 1]: ");
            Scanner sc = new Scanner(System.in);
            int entertainmentSystem = sc.nextInt();
            if (entertainmentSystem >= 1) {
                return entertainmentSystem;
            } else {
                System.out.print("Error: You input " + entertainmentSystem + " which is not a valid choice. Please input again [>= 1]! ");
                System.out.println();
            }
        } while (true);
    }

    public Car() {
        this.isCar = true;
        this.brand = inputBrand();
        this.name = inputName();
        this.licenseNumber = inputLicenseNumber();
        this.topSpeed = inputTopSpeed();
        this.gasCapacity = inputGasCapacity();
        this.wheel = inputWheel();
        this.type = inputType();
        this.entertainmentSystem = inputEntertainmentSystem();
    }
}