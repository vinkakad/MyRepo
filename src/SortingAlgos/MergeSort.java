package SortingAlgos;

import java.util.Arrays;

/**
 * Created by vinod on 15/11/17.
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {66, 88, 11, 22, 33, 44, 66, 77, 99, 101};
        divide(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void divide(int arr[], int start, int end) {

        if (start < end) {
            int mid = (start + end)/ 2;

            divide(arr, start, mid);
            divide(arr, mid + 1, end);

            conquer(arr, start, mid, end);
        }

    }

    private static void conquer(int[] arr,int start,int mid,int end){

        int[] temp = new int[end+1];

        int i=start;
        int j=mid+1;
        int k=start;

        while(i<=mid && j<= end){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i<=mid){
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j<=end){
            temp[k] = arr[j];
            k++;
            j++;
        }
        for(int l=start;l<=end;l++){
            arr[l] = temp[l];
        }
    }
}
