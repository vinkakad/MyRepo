package Barclays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vinod on 21/4/18.
 */
public class FizzBuzz {
    public static void main(String args[]){
        try{
            int gross = 100;
            int divisor = 0;
            int result = gross/divisor;
            System.out.print("Done");
        }
        catch(ArithmeticException e){
            System.out.print("Exception");
        }
        finally{
            System.out.print("Finally");
        }


            Thread t = Thread.currentThread();
            t.setName("mythread");
            System.out.println(t);
    }
}
