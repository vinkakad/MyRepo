package RandomTestCases;

/**
 * Created by vinod on 7/4/18.
 */
public class SubClass extends SuperClass {
    int a=2;

    public static int testImp = 9;

    public SubClass(int t) {
        super(t);
        this.a=15;
    }

    public void method(){
        System.out.println(a);
    }
}
