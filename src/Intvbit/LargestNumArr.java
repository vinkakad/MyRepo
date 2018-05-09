package Intvbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vinod on 12/12/17.
 */
public class LargestNumArr {
    // DO NOT MODIFY THE LIST

    public static String largestNumber(final List<Integer> a) {

        List<String> strs = new ArrayList<String>();
        for(Integer i : a){
            strs.add(String.valueOf(i));
        }

        Collections.sort(strs, new MyCompartor());

        StringBuffer strBuf = new StringBuffer();
        for(String s : strs){
            if("0".equals(s) && strBuf.length() != 0) {
                continue;
            }
            strBuf.append(s);
        }

        return strBuf.toString();
    }

    static class MyCompartor implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String first = s1 + s2;
            String second = s2 + s1;
            return second.compareTo(first);
        }

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add(3);
            add(30);
            add(34);
            add(5);
            add(9);
            add(0);
        }};

//        List<Integer> list = new ArrayList<Integer>() {{
//            add(0);
//            add(0);
//            add(0);
//            add(0);
//            add(0);
//        }};
        System.out.println(largestNumber(list));
    }
}
