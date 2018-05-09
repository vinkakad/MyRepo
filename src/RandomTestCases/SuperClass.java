package RandomTestCases;

/**
 * Created by vinod on 7/4/18.
 */
public class SuperClass implements Comparable<SuperClass>{
    int a = 1;

    public SuperClass(int t){
        this.a = t;
    }

    public void method() {
        System.out.println(this.a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuperClass that = (SuperClass) o;

        return a == that.a;

    }

    @Override
    public int hashCode() {
        return a;
    }

    @Override
    public int compareTo(SuperClass o) {
        if  (this.a > o.a)
        return 1;
        else
        return -1;
    }
}
