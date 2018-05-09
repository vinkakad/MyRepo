package Barclays;

/**
 * Created by vinod on 21/4/18.
 */
public class X863 {

    void addTwo(int varA) {
        varA += 3;
    }

    public static void main(String[] args) {
        double number = 123.4567d;
        String numberAsString = String.format ("%,.2f", number);
        System.out.println(numberAsString);
    }
}