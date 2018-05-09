package Intvbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by vinod on 14/12/17.
 */
public class FirstMissinginteger {

    public static int firstMissingPositive(ArrayList<Integer> a) {
        Collections.sort(a);
        int val = 0;
        boolean found = false;
        int numCheck = 0;

        if (a.get(a.size() - 1) <= 0)
            val = 0;

        for (int i = 0; i < (a.size() - 1); i++) {
            if (a.get(i) <= 0) {
                continue;
            }

            if ((numCheck + 1) != a.get(i)) {
                val = numCheck + 1;
                break;
            }
            numCheck=numCheck+1;
        }

        if (val == 0 && a.get(a.size() - 1) < 0)
            val = 1;
        else if (val == 0)
            val = a.get(a.size() - 1) + 1;

        return val;

    }

    public static void main(String[] args) {
       Integer[] arr = new Integer[] {45,-4,-6,-7,2,5, 4, -6,-1, 1,};

        System.out.println(firstMissingPositiveIB(new ArrayList<>(Arrays.asList(arr))));
    }

    public static int firstMissingPositiveIB(ArrayList<Integer> A) {

        int n = A.size() + 1;
        int count;
        int idx = 0;
        int size = A.size();
        count = size - 1;

        for (idx = size - 1; idx >= 0; idx--) {

            int num = A.get(idx);

            if (num < 0) {
                int val = A.get(count);
                A.set(idx, val);
                A.set(count, num);
                count--;
            }

        }

        for (idx = 0; idx <= count; idx++) {

            int num = A.get(idx);

            num = Math.abs(num);

            if (num > 0 && num < n) {

                int index = num - 1;
                int val = A.get(index);
                A.set(index, -val);

            }

        }

        for (idx = 0; idx <= count; idx++) {

            int num = A.get(idx);

            if (num > 0) {
                return idx + 1;
            }

        }

        return idx + 1;

    }
}
