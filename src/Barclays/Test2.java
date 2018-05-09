package Barclays;

/**
 * Created by vinod on 21/4/18.
 */

public class Test2 extends test1 {

    static {

        count++;

    }

    public void display() {

        super.display();

        count++;

        System.out.print("Test2 count = " + count);

    }

    public static void main(String args[]) {

        test1 tst = new Test2();

        tst.display();

    }
}
