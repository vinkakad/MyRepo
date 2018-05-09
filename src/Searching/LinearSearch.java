package Searching;

/**
 * Created by vinod on 22/3/17.
 */
public class LinearSearch<T> implements Search<T>{

    private T arr[];

    public LinearSearch(T[] arr) {
        if(null == arr)
            throw new NullPointerException("Null can not be assigned");

        this.arr = arr;
    }

    public int find(T key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
