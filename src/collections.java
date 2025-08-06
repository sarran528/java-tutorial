import java.util.Scanner;

public class collections {
    static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int len;
//INPUT
        System.out.println("*****************");
        System.out.print("Enter the size of the arr : ");
        len=sc.nextInt();
        int[] arr= new int[len];
        System.out.println("Enter the arr values one by one");
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
//METHODS
//        addTHeElements(arr);
//        reverseElement(arr,len);//has its own output function

//OUTPUT

//        for(int i=0;i< len;i++){
//            System.out.printf("%d",arr[i]);
//               if(i==len-1){break;}
//            System.out.print(",");
//        }

        System.out.println("\n*****************");

    }

    static void reverseElement(int[] arr,int len){

        int[] rev=new int[len];

int i=0, j=len-1;
        while (i<len) {
            rev[j]=arr[i];
            i++;
            j--;

        }
        System.out.println("This is the reversed array");
                for(int k=0;k< len;k++){
            System.out.printf("%d",rev[k]);
               if(k==len-1){break;}
            System.out.print(",");
        }






    }

    static void addTHeElements(int[] arr){


        int sum =0;
        for(int i=0;i< arr.length;i++){
            sum+= arr[i];
        }

        System.out.print(sum);

    }



}
