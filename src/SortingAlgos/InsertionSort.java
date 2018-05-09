package SortingAlgos;

import java.util.Arrays;

/**
 * Created by vinod on 13/11/17.
 */
public class InsertionSort {

    public static void main(String[] args) {

        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        int size = arr.length;

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
