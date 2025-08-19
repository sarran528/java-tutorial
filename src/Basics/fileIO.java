package Basics;
import java.io.File;

public class fileIO {
    static class Utils {
        // Generic method
        public static <T> void printTwice(T item) {
            System.out.println(item);
            System.out.println(item);
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Utils.printTwice("Hello");   // works with String
            Utils.printTwice(42);        // works with Integer
            Utils.printTwice(3.14);      // works with Double
        }
    }


}
