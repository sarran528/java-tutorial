package Basics;

public class ExceptionHandling {
    public static void main(String[] args) {

        int a = 5;
        int b = 7;

        try {
            int c = a * b;
            if (c == 35)
                throw new Exception("c is 35");
            System.out.print(c);
        } catch (Exception e) {
            System.out.print("Error");


        }
    }}
        ////////////////////////////////////////////////////////////////
        //////////////////////////////////@////////////////////////////
