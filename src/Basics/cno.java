import java.util.Scanner;

// 📦 This is the main class (entry point of the program)
public class cno {
    public static void main(String[] args) {

        // 👇 Creating an object of the Car class using the constructor
        Car benz = new Car("Mercedes-Benz", 2022);
        Car bugatti = new Car("red", 2023);
        benz.setSpeed(120); // Setting attribute using method

        // 🖨️ Accessing object data (attribute and method)
        System.out.println("Brand: " + benz.brand);         // Attribute
        System.out.println("Model Year: " + benz.modelYear); // Attribute
        System.out.println("Speed: " + benz.getSpeed());     // Method


        System.out.println("Brand: " + bugatti.brand);         // Attribute
        System.out.println("Model Year: " + bugatti.modelYear);

        // 🎯 Method Overloading: same method name but different parameters
        benz.display(); // No parameter
        benz.display("This car is premium.");benz.display("This car"); // With one String parameter
    }
}


// 🚗 Class Definition
class Car {

    // 🔧 Attributes (also called fields or variables)
    String brand;
    int modelYear;
    int speed;

    // 🚀 Constructor (called when an object is created)
    Car(String brandName, int year) {
        brand = brandName;     // Assigning value to attribute
        modelYear = year;
        speed = 0;             // Default speed
    }

    // 🧠 Method to set speed
    void setSpeed(int s) {
        speed = s;
    }

    // 📥 Method to get current speed
    int getSpeed() {
        return speed;
    }

    // 📢 Simple method without parameters
    void display() {
        System.out.println("This is a car object.");
    }

    // 📢 Overloaded method: same name, but takes one parameter
    void display(String message) {
        System.out.println(message);
    }
}
