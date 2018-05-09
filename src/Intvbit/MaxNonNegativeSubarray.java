package Intvbit;

import java.util.ArrayList;

/**
 * Created by vinod on 12/12/17.
 */
public class MaxNonNegativeSubarray {

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {

        ArrayList<Integer> maxSubSet = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        long maxSum = 0;
        long tempSum = 0;

        if (a == null || a.size() == 0)
            return new ArrayList<>();

        if (a.size() == 1 && a.get(0) > 0) {
            return a;
        }

        for (int i = 0; i < a.size(); i++) {

            if (a.get(i) >= 0) {
                temp.add(a.get(i));
                tempSum += a.get(i);
            } else if ((a.get(i) < 0 && temp.size() > 0) || maxSubSet == null) {
                temp = new ArrayList<>();
                tempSum = 0;
            }

            if (tempSum > maxSum || (tempSum == maxSum && maxSubSet.size() < temp.size())) {
                maxSubSet = new ArrayList<>(temp);
                maxSum = tempSum;
            }
        }
        return maxSubSet;
    }

    public static void main(String[] args) {

//        [1, 2, 5, -7, 2, 3] 39194, 51295, 33419, 63443, 68706, 26593, 31226
        //1967513926, 1540383426, -1303455736, -521595368
        //756898537, -1973594324, -2038664370, -184803526, 1424268980
        //336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421
        ArrayList<Integer> A = new ArrayList<Integer>() {{
            add(0);
            add(0);
            add(-1);
            add(0);
//            add(1424268980);
//            add(-1);
            /*add(-1369133069);
            add(1059961393);
            add(628175011);
            add(-1131176229);
            add(-859484421);*/
        }};

//        ArrayList<Integer> A = new ArrayList<Integer>(){{
//            add(1477171087);
//        }};
        System.out.println(maxset(A));
        System.out.println(1967513926 + 1967513926);
    }
}
