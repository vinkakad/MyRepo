package Intvbit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by vinod on 14/12/17.
 */
public class WaveArray {
    public static ArrayList<Integer> wave(ArrayList<Integer> a) {

        Collections.sort(a);

        for (int i = 0; i < a.size() - 1; i=i+2) {
            int temp = a.get(i);
            a.set(i, a.get(i + 1));
            a.set((i + 1), temp);
        }

        return a;
    }

    public static void main(String[] args) {
//        5, 1, 3, 2, 4
        ArrayList<Integer> arr = new ArrayList<Integer>() {{
            add(5);
            add(1);
            add(3);
            add(2);
            add(4);
        }};

        System.out.println(wave(arr));
    }
}
