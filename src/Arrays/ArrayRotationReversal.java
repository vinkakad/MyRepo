package Arrays;

import java.util.Arrays;

/**
 * Created by vinod on 24/10/17.
 */
public class ArrayRotationReversal {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        rotate(arr,1,8);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    static void rotate(int[] arr,int k,int n){
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
    }
}
