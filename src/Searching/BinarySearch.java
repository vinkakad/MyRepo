package Searching;

/**
 * Created by vinod on 22/3/17.
 */
public class BinarySearch<T> implements Search<T> {

    private T[] arr;

    public BinarySearch(T[] arr){
        if(null == arr)
            throw new NullPointerException("Value can not be null");
        this.arr = arr;
    }

    @Override
    public int find(T t) {
        return search(t,0,(arr.length-1));
    }

    private int search(T t,int start,int end) {
        try {
            while (start < end) {
                int mid = ((end-start)+start)/2;
                if (arr[mid] == t)
                    return mid;
                else if ((Integer) arr[mid] < (Integer) t) {
                    return search(t, mid, end);
                } else {
                    return search(t, start, mid);
                }
            }
        } catch (ClassCastException e) {
            throw new ClassCastException(e.getMessage());
        }
        return -1;
    }
}
