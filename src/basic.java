/*public class basic {
    public static void main(String []args){
        System.out.print("Hello World");
        System.out.print(" from Java!\n");
        System.out.println("This is a basic Java program.");
    }
}*/
/*                    data type: java
there are two types of data types in java
           1. primitive data types :byte, short, int, long, float, double, char, boolean (stack memory)
           2. Reference data types :String, Array, Class, Interface, etc. (heap memory)

 to creating a variable - 1.declare eg  (int a)
                          2.initialize eg (a=10;)
public class basic {
    public static void main(String []args){
        int a = 10; // declaration and initialization
        System.out.print("there are " +a+ " types");
    }
}

import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        int eligibleAge = 18;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter exit to to terminate");
            System.out.println("Enter a number:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.print("program terminated");
                break;
            }
            try {
                int age = Integer.parseInt(input);


                if (age >= eligibleAge) {
                    System.out.println("indeed eligible");
                }
                else{
                    System.out.println("hell nah!! kido");
                }

            }
            catch(NumberFormatException e){
                System.out.println("u can read right??");
            }
        }
    }
}
                          */

// billing

import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        int quantity;
        float price;
        double total;
        String product;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Product Billing ---");

            System.out.print("Enter your product name: ");
            product = sc.nextLine();

            System.out.print("Enter the price: ");
            price = sc.nextFloat();

            System.out.print("Enter the quantity: ");
            quantity = sc.nextInt();
            sc.nextLine(); // consume newline

            total = price * quantity;
            System.out.println("The total amount for " + product + " is: " + total);

            System.out.print("Do you want to continue? (yes/no): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                System.out.println("Thank you for using the billing system!");
                break;
            }
        }

        sc.close();
    }
}



















