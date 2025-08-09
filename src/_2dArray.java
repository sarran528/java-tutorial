import java.util.Scanner;

public class _2dArray {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        //2d array input
        System.out.print("Enter the no of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter the no of columns4" +
                " : ");
        int n = sc.nextInt();

        int[][] arr = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.printf("Enter the value for array element %d %d :", i + 1, j + 1);
                arr[i][j] = sc.nextInt();

            }
        }
        //2d array output

        System.out.printf("%dx%d Matrix is:\n",m,n);

//        System.out.print("{");
        for (int i = 0; i < m; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j++) {

                System.out.print(arr[i][j]);
                if (j!= n-1) {
                    System.out.print(",");

                }
            }System.out.print("|");
            if (i != m-1){
            System.out.print("\n");}

        }
//        System.out.print("}");
    }
}
