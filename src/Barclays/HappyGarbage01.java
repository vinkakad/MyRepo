package Barclays;
class HappyGarbage01
{
    public static void main(String args[])
    {
        HappyGarbage01 h = new HappyGarbage01();
        h.methodA(); /* Line 6 */
    }
    Object methodA()
    {
        Object obj1 = new Object();
        Object [] obj2 = new Object[1];
        obj2[0] = obj1;
        obj1 = null;
        return obj2[0];
    }
}
