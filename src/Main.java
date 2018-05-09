import RandomTestCases.SubClass;
import RandomTestCases.SuperClass;
import Searching.BinarySearch;
import Searching.LinearSearch;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Integer arr[] = {12, 23, 44, 3, 5, 64, 43, 33, 5, 6, 12, 58};
        LinearSearch<Integer> linearSearch = new LinearSearch<>(arr);

        Arrays.sort(arr);
        BinarySearch<Integer> bSearch = new BinarySearch<>(arr);

//        System.out.println(bSearch.find(64));

        D d = new D();
        d.m();


    }

    private static void tt(int a,int b){
//        return {(a,b) -> a + b};
    }

    private  static void t1 (Integer i){
        System.out.println("Method Integer:- "+i);
    }

    private static void t1 (int i){
        System.out.println("Method int:-" +i);
    }

    public static void fromArrayToList(List<? extends SuperClass> a) {
        for (SuperClass sub : a) {
        }
    }

    interface I1{
        void test();
    }

    interface I2 extends I1{
        default void t1(){
        }
    }

    abstract class  C1 implements I2{}


    interface A {
        void m();
    }

    interface B extends A {
        void m();
    }

    interface C extends A {
         void m();
    }

    static class D extends E implements C {

    }

    static abstract class E implements C,B{

        @Override
        public void m() {

        }
    }
}
