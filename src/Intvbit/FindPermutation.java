package Intvbit;

import java.util.ArrayList;

/**
 * Created by vinod on 18/12/17.
 */
public class FindPermutation {

    public static ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> arr = new ArrayList<Integer>();

        int i = 1, j = B;
        int l = 0;

        while (l < A.length()) {
            if (A.charAt(l) == 'I') {
                arr.add(i++);
            } else {
                arr.add(j--);
            }
            l++;
        }

        if (A.charAt(A.length() - 1) == 'I') {
            arr.add(j);
        } else {
            arr.add(i);
        }
        return arr;
    }

    public static void main(String[] args) {

        System.out.println(findPerm("ID",3));
    }
}
