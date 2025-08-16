import java.util.Scanner;
import java.util.Stack;

public class collections {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


//        LinkedList list = new LinkedList();
//        list.insertAtBeginning(1);
//        list.insertAtBeginning(2);
//        list.insertAtBeginning(3);
//        list.display();
//        list.insertAtPos(2, 4);
//        list.display();
//        list.deleteAtPos(0);
//        list.display();
//        list.insertAtEnd(5);
//        list.display();
Stack<Integer> stk = new Stack<>();
        stk.push(15);
        stk.push(14);
        stk.push(12);
        stk.push(11);
        System.out.println(stk);
        System.out.println(stk.peek());
        stk.pop();
        System.out.println(stk);




//        int len;
//INPUT
//        System.out.println("*****************");
//        System.out.print("Enter the size of the arr : ");
//        len=sc.nextInt();
//        int[] arr= new int[len];
//        System.out.println("Enter the arr values one by one");
//        for(int i=0;i<len;i++){
//            arr[i]=sc.nextInt();
//               }
//METHODS
//        addTHeElements(arr);
//        reverseElement(arr,len);//has its own output function
//        findThe2ndLargestElement();
//        ascendingOrderSort(arr);
//        pattern();

//OUTPUT
//        System.out.print("{");
//        for(int i=0;i< len;i++){
//            System.out.printf("%d",arr[i]);
//               if(i==len-1){break;}
//            System.out.print(",");
//        }
//
//        System.out.print("}");

    }

    static void pattern() {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }


            System.out.print("\n");
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }


            System.out.print("\n");
        }
    }

    static void ascendingOrderSort(int[] arr) {
//        int[] arr = {5, 7, 11, 16, 12};
        int temp;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    static void findThe2ndLargestElement() {

        int[] arr = {5, 7, 11, 16, 12};
        int l1 = 0;
        int l2 = 1;


        for (int i = 0; i < 5; i++) {

            if (arr[i] > l1) {

                l2 = l1;
                l1 = arr[i];

            } else if (arr[i] > l2) {

                l2 = arr[i];

            }


        }
        System.out.println(l2);


    }

    static void reverseElement(int[] arr, int len) {

        int[] rev = new int[len];

        int i = 0, j = len - 1;
        while (i < len) {
            rev[j] = arr[i];
            i++;
            j--;

        }
        System.out.println("This is the reversed array");
        for (int k = 0; k < len; k++) {
            System.out.printf("%d", rev[k]);
            if (k == len - 1) {
                break;
            }
            System.out.print(",");
        }


    }

    static void addTHeElements(int[] arr) {


        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.print(sum);

    }


}
