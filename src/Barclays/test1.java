package Barclays;

/**
 * Created by vinod on 21/4/18.
 */
public class test1 {

    public static int count = 4;

    static {

        count = 1;

    }

    void increment() {

        count++;

    }

    protected void display() {

        increment();

        System.out.print("Test1 count = "+count);

    }

}

