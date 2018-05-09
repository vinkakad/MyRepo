package Arrays;

import java.util.Arrays;

/**
 * Created by vinod on 17/10/17.
 */
public class ArrayRotation {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] arr = {1, 3, 5, 6, 7, 8, 9, 10, 12, 45, 17, 87};
//        rotateArray(arr, 3, 7);
        leftRotate(arr,6,8);
        System.out.println(Arrays.toString(arr));
    }



    private static void rotateArray(int[] arr,int d,int n){
       int j=0, i=d;
        for(;j<d;j++){
            leftRotate(arr,d,n);
        }
        System.out.println(Arrays.toString(arr));

       /*for(;i<n && j<n ;i++,j++){
           temp[j] = arr[i];
       }

       for(i=0;i<d;i++){
           temp[j++] = arr[i];
       }

       System.out.println(Arrays.toString(temp));*/
    }


    static void leftRotate(int arr[], int d, int n) {
        int i, j, k, temp;
        int gcd = gcd(d, n);
        for (i = 0; i < gcd; i++) {
    /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    private static void leftRotateByOne(int arr[], int n){
        int i=0;
        int temp = arr[0];
        for(i=0;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
    }

    static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }
}
