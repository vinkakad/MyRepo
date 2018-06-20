package Tiaa;

/**
 * Created by vinod on 28/5/18.
 */
public class Bulbs {

    //Bulb toggling problem
    public static void main(String[] args) {

        System.out.println(getNoOfbulbsSwitchedOn(8));
    }

    private static int getNoOfbulbsSwitchedOn(int n){
        return (int) Math.sqrt(n);
    }
}
