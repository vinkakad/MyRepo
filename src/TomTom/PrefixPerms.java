package TomTom;

import java.util.Arrays;

/**
 * Created by vinod on 10/11/17.
 */
public class PrefixPerms {

    public static void main(String[] args) {

    }

    public static int solution(int[] A) {
        int size = A.length;

        int prefCount = 0;
        int indexSum = 0;
        int arrayValueSum = 0;

        for (int i = 0; i < size; i++) {
            indexSum = i + 1 + indexSum;
            arrayValueSum = A[i] + arrayValueSum;

            if (indexSum == arrayValueSum)
                prefCount++;
        }
        return prefCount;
    }

    public static int solutionA(int[] A){

        int prefixCount =0;
        int size = A.length;

        for (int i = 0; i < size; i++) {
            int[] temp = Arrays.copyOfRange(A, 0, i + 1);
            quickSort(temp, 0, i);
            boolean prefixPerm = true;
            for (int j = 0; j < i - 1; j++) {
                if (temp[j + 1] != temp[j] + 1) {
                    prefixPerm = false;
                }
                if (prefixPerm == true)
                    prefixCount++;
            }
        }
        return prefixCount;
    }

    private static void quickSort(int[] arr,int low,int high){
        if (low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int arr[], int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {

            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;
        return i + 1;
    }





}
