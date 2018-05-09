package Intvbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinod on 11/12/17.
 */
public class MaxContiguosSum {

    public static int maxSubArray(final List<Integer> a) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            maxSum = Math.max(sum, maxSum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }

    public static int maxSubArrayPositive(final List<Integer> a){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            maxSum = Math.max(sum, maxSum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }


    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<Integer>() {{
            add(-2);
            add(1);
            add(-3);
            add(4);
            add(-1);
            add(2);
            add(1);
            add(-5);
            add(4);
        }};
        System.out.println(maxSubArray(lst));
    }
}
