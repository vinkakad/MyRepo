package Barclays;

/**
 * Created by vinod on 21/4/18.
 */
class Check
{
    public static void main(String [] args)
    {
        Check p = new Check();
        p.start();
    }

    void start()
    {
        boolean b1 = false;
        boolean b2 = fix(b1);
        System.out.println(b1 + " " + b2);
    }

    boolean fix(boolean b1)
    {
        b1 = true;
        return b1;
    }
}
