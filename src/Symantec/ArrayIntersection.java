package Symantec;

import java.util.Arrays;

/**
 * Created by vinod on 29/5/18.
 */
public class ArrayIntersection {
    public static void main(String[] args) {

        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};

        System.out.println(Arrays.toString(getIntersectionBinary(arr1.length < arr2
                        .length ? arr1 : arr2,
                arr1.length > arr2.length ? arr1 : arr2)));

    }


    private static int[] getUnion(int[] arr1, int[] arr2) {
        int[] union = Arrays.copyOf(arr1, arr1.length + arr2.length);
        int counter = 0;

        for (int i = 0; i < union.length; i++) {
            for (int j = 0; j < arr2.length; j++) {

            }
        }
        return union;
    }


    private static int[] getIntersection(int arr1[], int arr2[]) {

        int[] intersection = Arrays.copyOf(arr1.length < arr2.length ? arr1 : arr2, arr1.length < arr2.length ? arr1.length
                : arr2.length);
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j])
                    intersection[count++] = arr1[i];
            }
        }
        return intersection;
    }

    private static int[] getIntersectionSorting(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int counter1 = 0;
        int counter2 = 0;
        int intersectionCounter = 0;
        int[] intersection = new int[arr1.length];

        for (int i = 0; i < arr2.length; i++) {
            if (arr1[counter1] > arr2[counter2]) {
                counter2++;
            } else if (arr1[counter1] < arr2[counter2]) {
                counter1++;
            } else {
                intersection[intersectionCounter] = arr1[counter1];
                counter1++;
                counter2++;
                intersectionCounter++;
            }
        }
        return intersection;
    }

    private static int[] getIntersectionBinary(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int[] interection = new int[arr1.length];
        int counter = 0;
        for (int i = 0; i < arr2.length; i++) {
            boolean found = binarySearch(arr1, arr2[i], 0, arr1.length);
            if (found) {
                interection[counter++] = arr2[i];
            }
        }

        return interection;
    }

    private static boolean binarySearch(int[] arr, int element, int start, int
            end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (element < arr[mid])
                return binarySearch(arr, element, start, mid - 1);
            else if (element > arr[mid])
                return binarySearch(arr, element, mid + 1, end);
            else
                return true;
        }
        return false;
    }
}
