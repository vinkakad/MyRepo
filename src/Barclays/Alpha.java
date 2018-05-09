package Barclays;

/**
 * Created by vinod on 21/4/18.
 */
class Alpha {
    public void abc(int i) {
        System.out.println("in abc of Alpha");
    }
}

class Beta extends Alpha{
    public void abc(long i) {
        System.out.println("in abc of Beta");
    }
    public static void main(String [] args){
        Alpha a = new Beta();
        Beta b = new Beta();
    }
}
