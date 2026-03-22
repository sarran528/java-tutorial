package Basics;
//Write a Java program that:
//
//        * Creates a method `divide(int a, int b)`
//        * Handles division using **exception handling**
//        * Catches `ArithmeticException`
//        * Prints `"Cannot divide by zero"` if error occurs
//* Otherwise prints the result
//
//Include `main` method and test with:
//
//        * (10, 2)
//        * (5, 0)




public class practise {

    public static void main(String[] args) {
        divide(10, 2);
        divide(5, 0);
}

static void divide(int a,int b){

    try {
        int result = a / b;
        System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
        System.out.println("Cannot divide by zero");
    }
}}