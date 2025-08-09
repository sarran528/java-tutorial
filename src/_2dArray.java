import java.util.Scanner;

public class _2dArray {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        //2d array input
        System.out.print("Enter the no of columns : ");
        int m = sc.nextInt();
        System.out.print("Enter the no of rows : ");
        int n = sc.nextInt();

        int[][] arr = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.printf("Enter the value for array element %d %d :",i+1,j+1);
                arr[i][j]=sc.nextInt();

        //2d array output
            }


        }

    }
}
