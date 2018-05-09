package Intvbit;

import java.util.HashMap;
import java.util.List;

/**
 * Created by vinod on 14/12/17.
 */
public class DuplicateNumber {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        HashMap<Integer,Integer> duplicate = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            if (duplicate.containsKey(a.get(i)))
                return a.get(i);
            else
                duplicate.put(a.get(i), 1);
        }
        return -1;
    }

    public static int main(String[] args) {
        List<Integer> a = null;
        final int n = a.size() - 1;
        // int[] A = new int[a.size()];
        int x = 0;
        for (int i = 1; i <= n; i++) {
            x = x ^ i;
        }
        for (int e : a) {
            x = x ^ e;
        }
        if (x == 0) return -1;
        else return x;
	    /*for (int x : a) {
	        if (A[x] != 0) {
	            return x;
	        } else {
	            A[x] += 1;
	        }
	    }
	    return -1;
	    */
    }
}
