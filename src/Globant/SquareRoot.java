package Globant;

import LinkedList.TestMergeSort;

/**
 * Created by vinod on 17/4/18.
 */
public class SquareRoot {

    public static String strO  = new String("ABC");
    public static String strL = "ABC";

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Square root of "+ n + ":-" + strL == TestMergeSort.str);
    }

    private static int findSquareRoot(int n) {

        for (int i = 2; i <= n/2; i++) {
            if (i * i == n)
                return i;
        }
        return 0;
    }

    class MyClassLoader extends ClassLoader{


    }

}
