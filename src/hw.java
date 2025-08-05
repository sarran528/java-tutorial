import java.util.Scanner;

public class hw {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//
//        divisibleOfThree();
//        OddOrEven();
//        multiplicationTableFor6();
//        multiplicationTableFor8();
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter ur age: ");
//        int a = sc.nextInt();
//        System.out.printf("%s", a>18?"eligible":"not eligible");

//        integer();
//        sumOfEven();
//        multiplicationTable();
//    bitWiseOperator();
//        Fibonacci();
//        reverse();
//        pallindrome();
//        perfectNum();
//        perfectRange();
        strongNum();

    }
static void strongNum(){
        int fact=1,strong=0;
int num = sc.nextInt();int org=num;
        while (num!=0){

            int temp = num%10;
            for(int i=1;i<=temp;i++){
                fact*= i;
            }

            strong += fact;
            fact= 1;
            num = num/10;

        }
    System.out.printf(" the %d is %s", strong, strong==org?"strong":"not strong");


}
    static void divisibleOfThree() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a range: ");
        int b = sc.nextInt();
        System.out.print("Numbers divisible by 3: ");
        for (int i = 1; i <= b; i++) {
            if (i % 3 == 0) {
                System.out.printf("%d ", i);
                sc.close();
            }
        }

    }

    static void OddOrEven() {

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int n = num;


        while (n > 1) {
            n = n % 2;
        }

        if (n == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }


    }

    static void multiplicationTableFor8() {

        System.out.print("multiplication table of 8 till : ");

        int b = sc.nextInt();
        System.out.println("Multiplication table of 8:");
        for (int i = 1; i <= b; i++) {
            System.out.printf("8 x %d = %d%n", i, 8 * i);
        }
        sc.close();
    }

    static void multiplicationTableFor6() {

        System.out.print("multiplication table of 6 till : ");

        int b = sc.nextInt();
        System.out.println("Multiplication table of 6:");
        for (int i = 1; i <= b; i++) {
            System.out.printf("6 x %d = %d%n", i, 6 * i);
        }
        sc.close();

    }

    static void integer() {


        System.out.print("Enter a integer : ");
        int a = sc.nextInt();

        if (a == 0) {

            System.out.printf(" %d is Zero", a);

        } else if (a > 0) {

            System.out.printf(" %d is positive ", a);

        } else {

            System.out.printf(" %d is negative ", a);

        }

    }

    static void sumOfEven() {

        System.out.print("Enter a range : ");
        int a = sc.nextInt();
        int b = 0;
        for (int i = 0; i <= a; i++) {
            if (i % 2 == 0) {
                b += i;
            }

        }
        System.out.printf(" %d ", b);

    }

    static void multiplicationTable() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to generate its multiplication table : ");
        int a = sc.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", a, i, a * i);
        }

    }


    static void bitWiseOperator() {


        System.out.println("Enter two values");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(~(a | b));
        System.out.println(a >> b);

    }


    static void Fibonacci() {

        System.out.print("Enter a range : ");
        int range = sc.nextInt();
        int a = 0;
        int b = 1;
        int c;
        for (int i = 0; i < range; i++) {

            System.out.printf("%d ", a);
            c = a + b;
            a = b;
            b = c;
        }
    }

    static void reverse() {
        int rev = 0;
        int num = sc.nextInt();
        sc.close();
        while (num != 0) {
            int temp = num % 10;// 587 % 10 = 58
            rev = rev * 10 + temp;// 0*10 + 8 = 8 , 8*10 + 7 = 87
            num = num / 10;
        }
        System.out.println(rev);
    }

    static void pallindrome() {
        int org, rev = 0;
        int a = sc.nextInt();
        org = a;
        while (a != 0) {

            int temp = a % 10;
            rev = rev * 10 + temp;
            a = a / 10;

        }
        System.out.printf("the number  %s", org == rev ? "is palindrome" : "is not palindrome");

    }

    static void perfectNum() {

        int num = sc.nextInt();
        int perfect = 0;

        for (int i = 1; i < num / 2; i++) {

            if (num % i == 0) {
                perfect += i;
            }

        }
        System.out.printf("the number is %s", num == perfect ? "perfect number" : "not a perfect number");


    }

    static void perfectRange() {

        int range = 1000000000;
        int perfect = 0;

        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= i / 2; j++) {

                if (i % j == 0) {
                  perfect += j;
                }
            }
            if (i == perfect) {
                System.out.println(i);

            }
            perfect=0;

        }
    }



}



