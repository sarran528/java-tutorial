package Basics;
import java.util.Arrays;

public class Rough {


    class Solution {
        public double suma(int[] nums1, int[] nums2) {
            System.arraycopy(nums2,0,nums1,nums1.length,nums2.length);
            //want to return nums1
            return nums1[0];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 2, 3, 5, 1};
        int[] unique = Arrays.stream(arr).distinct().sorted() .toArray();


        System.out.println(Arrays.toString(unique));


    }

}
