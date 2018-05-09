package Intvbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vinod on 15/12/17.
 */
public class RotateMatrix {
    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int[][] arr = new int[a.size()][a.get(0).size()];
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<a.size();i++){
             arrList.add((ArrayList<Integer>)a.get(i).clone());
        }

        for (int i = 0; i < arrList.size(); i++) {
            for (int j = 0; j < arrList.get(0).size(); j++) {
                a.get(j).set((arrList.size() - i - 1), arrList.get(i).get(j));
                arr[j][(arrList.size() - i - 1)] = arrList.get(i).get(j);
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }

    private static void rotateInplace(ArrayList<ArrayList<Integer>> a){
        int S = a.size() - 1;

        for(int i = 0 ; i < a.size() / 2 ; i++){

            for(int j = i; j < S - i; ++j){

                int temp1 = a.get(S-j).get(i);
                int temp2 = a.get(S-i).get(S-j);
                int temp3 = a.get(j).get(S-i);
                int temp4 = a.get(i).get(j);

                // swap
                a.get(i).set(j,temp1);
                a.get(S-j).set(i,temp2);
                a.get(S-i).set(S-j,temp3);
                a.get(j).set(S-i,temp4);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrLl = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(1);
        inner.add(2);
        inner.add(3);
        inner.add(4);

        arrLl.add(inner);

        inner = new ArrayList<>();
        inner.add(5);
        inner.add(6);
        inner.add(7);
        inner.add(8);

        arrLl.add(inner);

        inner = new ArrayList<>();
        inner.add(9);
        inner.add(10);
        inner.add(11);
        inner.add(12);

        arrLl.add(inner);

        inner = new ArrayList<>();
        inner.add(13);
        inner.add(14);
        inner.add(15);
        inner.add(16);

        arrLl.add(inner);
        rotateInplace(arrLl);
        //rotate(arrLl);
        System.out.println(arrLl);
    }
}