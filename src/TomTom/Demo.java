package TomTom;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vinod on 10/11/17.
 */
public class Demo {

    public static void main(String[] args) {
        int[] arr = { 1,1,0,-1,-2};
        System.out.println(smallestPositiveInt(arr,arr.length));
    }

    private static int smallestPositiveInt(int[] arr, int size) {

        Set<Integer> intSet = new HashSet<Integer>();
        int maxVal = 1;
        for (int i = 0; i < size; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            }
            if (arr[i] > 0) {

                intSet.add(arr[i]);
            }
        }
        for (int j = 1; j <= maxVal; j++) {
            if (!intSet.contains(j))
                return j;
        }
        return maxVal + 1;

    }
}
