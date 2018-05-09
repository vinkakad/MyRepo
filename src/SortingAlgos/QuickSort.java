package SortingAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by vinod on 17/11/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {66, 88, 11, 22, 33, 44, 91, 31, 54, 888, 77, 99, 101};
        //quickSort(arr, 0, arr.length - 1);
        //sort(arr,0,arr.length-1);
        merge_sort_test(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.sort(integers);
    }

    private static void quickSort(int[] arr,int start,int end){

        if (start < end) {

            int partIndex = partition_hoare(arr, start, end);

            quickSort(arr, start, partIndex);
            quickSort(arr, partIndex + 1, end);
        }
    }

    private static int partition_hoare(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (true) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;

            if (j > i) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            } else
                return j;
        }

    }

    static int partition_lomuto(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition_lomuto(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }


    static void merge_sort_test(int[] arr,int low,int high){

        if (low < high) {

            int mid = low + ((high - low) / 2);
            merge_sort_test(arr, low, mid);
            merge_sort_test(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }

    }

    static void merge(int[] arr,int low,int mid,int high){

        int[] temp = new int[high+1];

        int i=low;
        int j=mid+1;
        int k=low;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while(i<=mid)
            temp[k++] = arr[i++];

        while(j<=high)
            temp[k++] = arr[j++];

        for (i = low; i <= high; i++) {
             arr[i] = temp[i];
        }
    }

}
