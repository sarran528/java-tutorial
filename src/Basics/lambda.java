package Basics;

public class lambda {
   interface A{
        void Print(char A);
   }

    public static void main(String [] args){


       A  obj = (i) -> System.out.println("this is " +i);

   obj.Print('A');

    }

}
