package RandomTestCases;

import static Barclays.Point.*;

import java.*;

/**
 * Created by vinod on 23/4/18.
 */
public class InterfaceTest {

    interface I1 {
        String str = "str";
        int e = 4;
        void test();
    }

    interface I2 {
        String str = "str";
        int d = 3;
    }


    abstract class abClass{
        abstract void testMethodAb();
    }

    class Impl implements I2 {

        public void test() {

        }
    }

//    static class Impl1 extends Impl{
//
//
//    }


    static public void main(String[] args) {
        System.out.println("ABC"+1+1);
        System.out.println(1+1+"ABC"+1+1);
        //List t = new ArrayList();
    }
}
