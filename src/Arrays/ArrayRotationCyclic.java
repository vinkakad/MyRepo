package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vinod on 30/10/17.
 */
public class ArrayRotationCyclic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for(int j=0;j<size;j++){
                arr[j] = scanner.nextInt();
            }
            rotateCyclic(arr,size);
            System.out.println(Arrays.toString(arr));
        }

    }

    private static void rotateCyclic(int arr[],int n){
        int temp = arr[0];
        for(int i=0;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = temp;
    }
}
