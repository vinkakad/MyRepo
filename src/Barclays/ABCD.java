package Barclays;

import java.util.Objects;

/**
 * Created by vinod on 21/4/18.
 */
class ABCD{
    int x = 10;
    static int y = 20;
}
class MNOP extends ABCD{
    int x = 30;
    static int y = 40;
}

class TestClass {
    public static void main(String[] args) {
//        System.out.println(new MNOP().x+", "+new MNOP().y);

        ABCD a = new ABCD();
        System.out.println(a instanceof Object);
    }

}
