package Arrays;

/**
 * Created by vinod on 31/10/17.
 */
public class SearchInSortedRotatedArray {

    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 1, 2};
        int[] arr2 = {3, 4, 5, 1, 2};
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};

        System.out.println(binarySearch(arr1, 0,arr1.length-1, 3));
    }

    private static int search(int arr[], int n,int key) {

        if(arr[0] < arr[arr.length-1]){
         return binarySearch(arr,0,arr.length-1,key);
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int start, int end, int X) {


        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (arr[mid] == X)
            return mid;

        if (arr[start] < arr[mid]) {

            if (X >= arr[start] && X <= arr[mid])
                return binarySearch(arr, start, mid - 1, X);

            return binarySearch(arr, mid + 1, end, X);
        }


        if (X >= arr[mid] && X <= arr[end])
            return binarySearch(arr, mid + 1, end, X);

        return binarySearch(arr, start, mid - 1, X);

        /*if (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == X)/*if (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == X)
                return mid;
            else if (arr[mid] > X)
                return binarySearch(arr, start, mid - 1, X);
            else
                return binarySearch(arr, mid + 1, end, X);
        }

        return -1;*/
       /*         return mid;
            else if (arr[mid] > X)
                return binarySearch(arr, start, mid - 1, X);
            else
                return binarySearch(arr, mid + 1, end, X);
        }

        return -1;*/
    }

    private int getPivot(int[] arr, int high, int low) {

        if (high < low)
            return -1;
        if (high == low)
            return low;


        int mid = (high + low) / 2;

        if (arr[mid] > arr[mid + 1])
            return mid;
        else if (arr[mid] < arr[mid - 1])
            return mid - 1;
        else if(arr[low] >= arr[mid])
            return 0;

        return 0;
    }
}
