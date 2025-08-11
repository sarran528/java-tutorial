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
//        System.out.print("Enter a number: ");
//        integer();
//        sumOfEven();
//        multiplicationTable();
//        bitWiseOperator();
//        Fibonacci();
//        reverse();
//        palindrome();
//        perfectNum();
//        perfectRange();
//        strongNum();
//        autoMorphicNum();
//ascaasasasfasfsa
//        harshad();
//        harshadRange();
//        neonNum();
//        neonRange();
//        System.out.print(27*27);
        autoMorphicRange();

    }

    static void autoMorphicRange() {

        int range = sc.nextInt();

        boolean isMorphic = true;
        int i;

        for(i=1;i<=range;i++) {
            int org = i;
            int square = org * org;
            while (org != 0) {

                if (org%10==square%10){isMorphic=true;}
                else { isMorphic=false;break;}
                org/=10;
                square/=10;

            }

            if (isMorphic){System.out.println(i);}

        }
    }

    static void neonRange() {
        int range = sc.nextInt();

        for (int i = 1; i <= range; i++) {
            int square = i * i;
            int sum = 0;

            while (square != 0) {
                int temp = square % 10;
                sum += temp;
                square /= 10;
            }

            if (sum == i) {
                System.out.println(i);
            }
        }
    }

    static void neonNum() {
        int num = sc.nextInt();
        int square = num * num;
        int sum = 0;

        while (square != 0) {
            int temp = square % 10;
            sum += temp;
            square /= 10;
        }

        System.out.printf("the number %d is %s", num, sum == num ? "neon" : "not neon");
    }

    static void harshadRange() {
        int range = sc.nextInt();
//        int org = num;

        for (int i = 1; i <= range; i++) {
            int sum = 0;
            int x = i;
            while (x != 0) {
                int temp = x % 10;
                sum += temp;
                x /= 10;
            }

            if (i % sum == 0) {
                System.out.println(i);
            }
        }
    }

    static void harshad() {

        int num = sc.nextInt();
        int org = num;
        int sum = 0;

        while (num != 0) {
            int temp = num % 10;
            sum += temp;
            num /= 10;
        }

        System.out.printf("the %d is %s", org, org % sum == 0 ? "harshad number" : "not a harshad number");
    }

    static void autoMorphicNum() {

        int num = sc.nextInt();
        int square = num*num;
        boolean isMorphic=false;

        while(num!=0){

            if (num%10==square%10){isMorphic=true;}
            else { isMorphic=false;break;}
            num/=10;
            square/=10;

        }
        System.out.printf(" number is %s",isMorphic?"Automorphic":"not Automorphic "  );

    }

    static void strongNum() {
        int fact = 1, strong = 0;
        int num = sc.nextInt();
        int org = num;
        while (num != 0) {

            int temp = num % 10;
            for (int i = 1; i <= temp; i++) {
                fact *= i;
            }

            strong += fact;
            fact = 1;
            num = num / 10;

        }
        System.out.printf(" the %d is %s", strong, strong == org ? "strong" : "not strong");


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

    static void palindrome() {
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
            perfect = 0;

        }
    }


}



