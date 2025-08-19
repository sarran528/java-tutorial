package Basics;

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

//        sumOfDiagonal(arr,m,n);
        MaxMinvalue(arr, m, n);

//          2d array output

        System.out.printf("%dx%d Matrix is:\n", m, n);

//      System.out.print("{");
        for (int i = 0; i < m; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j++) {

                System.out.print(arr[i][j]);
                if (j != n - 1) {
                    System.out.print(",");

                }
            }
            System.out.print("|");
            if (i != m - 1) {
                System.out.print("\n");
            }

        }

//        int[][] jagged = {
//                {1, 2, 3},
//                {4, 5},
//                {6, 7, 8, 9}
//        };

//        System.out.print("}");
    }

    static void MaxMinvalue(int[][] arr, int m, int n) {
        int Max = arr[0][0];
        int Min = arr[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                

            }
        }

    }

    static void sumOfDiagonal(int[][] arr, int m, int n) {

        int diagonalSum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    diagonalSum += arr[i][j];
                }
            }
        }
        System.out.println("the left diagonal sum is : " + diagonalSum);
        diagonalSum = 0;

        int i = m - 1, j = 0;
        while (i >= 0) {

            diagonalSum += arr[i][j];
            i--;
            j++;
        }
        System.out.println("the Right diagonal sum is : " + diagonalSum);

    }
}
