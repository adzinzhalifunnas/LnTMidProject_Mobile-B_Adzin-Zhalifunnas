package Vehicles;
import java.util.*;

public class Motorcycle extends Vehicle {
    public int helm;

    public void entertainment() {
        System.out.println(this.name + " is standing!");
    }

    public int inputHelm() {
        do {
            System.out.print("Input helm amount [>= 1]: ");
            Scanner sc = new Scanner(System.in);
            int helm = sc.nextInt();
            if (helm >= 1) {
                return helm;
            } else {
                System.out.print("Error: You input " + helm + " which is not a valid choice. Please input again [>= 1]! ");
                System.out.println();
            }
        } while (true);
    }

    public Motorcycle() {
        this.isCar = false;
        this.brand = inputBrand();
        this.name = inputName();
        this.licenseNumber = inputLicenseNumber();
        this.topSpeed = inputTopSpeed();
        this.gasCapacity = inputGasCapacity();
        this.wheel = inputWheel();
        this.type = inputType();
        this.helm = inputHelm();
    }
}