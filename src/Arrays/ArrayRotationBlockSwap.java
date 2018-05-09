package Arrays;

import java.util.Arrays;

/**
 * Created by vinod on 25/10/17.
 */
public class ArrayRotationBlockSwap {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//        block_swap(arr,3,8);
        iterativeBlockSwapLeftRotate(arr, 3, 8);
        System.out.println(Arrays.toString(arr));
    }

    static void block_swap(int[] arr, int d, int size) {

        if (d == 0 || d == size)
            return;

        if (size - d == d) {
            swap(arr, 0, size - d, d);
            return;
        }

        //If first half is shorter
        if (size - d > d) {

            swap(arr, 0, size - d, d);
            block_swap(arr, d, size-d);

        } else {
            swap(arr, 0, d, size - d);
            block_swap(arr, (2*d) - size,d);

        }
    }

    static void swap(int[] arr, int i1, int i2, int size) {

        for (int i = 0; i < size; i++) {
            int temp = arr[i1+i];
            arr[i1+i] = arr[i2+i];
            arr[i2+i] = temp;
        }
    }


    static void iterativeBlockSwapLeftRotate(int arr[], int d, int n) {
        int i, j;
        if(d == 0 || d == n)
            return;
        i = d;
        j = n - d;
        while (i != j)
        {
            if(i < j) /*A is shorter*/
            {
                swap(arr, d-i, d+j-i, i);
                j -= i;
            }
            else /*B is shorter*/
            {
                swap(arr, d-i, d, j);
                i -= j;
            }
            // printArray(arr, 7);
        }
  /*Finally, block swap A and B*/
        swap(arr, d-i, d, i);
    }


    static void iterativeApp(int[] arr, int d, int n) {

        int i, j;

        if (d == 0 || d == n)
            return;
        i = d;
        j = n - d;

        //if a is shorter
        if (i < j) {
            swap(arr, 0, n - d, n);
        } else {

        }
    }




















}

