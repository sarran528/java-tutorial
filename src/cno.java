import java.util.Scanner;

public class cno {
    public static void main(String[] args) {
        String name;
        int s1, s2, s3;



        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ur name: ");
        name = sc.nextLine();
        System.out.print("Subject 1 marks: ");
        s1 = sc.nextInt();
        System.out.print("Subject 2 marks: ");
        s2 = sc.nextInt();
        System.out.print("Subject 3 marks: ");
        s3 = sc.nextInt();

        System.out.println("Student: " + name);
        System.out.println("Total Marks: " + totalMarks(s1, s2, s3));
        System.out.println("Average: " + totalAverage(s1, s2, s3));
        System.out.println("Result: " + Result(totalAverage(s1, s2, s3)));

//        System.out.println("Student: ");
//        System.out.println("Total Marks: ");
//        System.out.println("Average: ");
//        System.out.println("Result: ");

    }


    static int totalMarks(int a, int b, int c) {
        return a + b + c;

    }

    static float totalAverage(int a, int b, int c) {
        return (float) (a + b + c) / 3;
    }

    static String Result(float a) {
        String result;
        if (a < 35) {
            result = "FAIL";

        } else {

            result = "PASS";

        }
        return result;
    }
}
