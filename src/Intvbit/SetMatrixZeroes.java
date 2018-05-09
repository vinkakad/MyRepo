package Intvbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vinod on 14/12/17.
 */
public class SetMatrixZeroes {

    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int foundRow = 0;
        int foundCol = 0;

        int[] foundRows = new int[a.size()];
        int[] foundCols = new int[a.get(0).size()];

//        int[][] foundij = new int[a.size()][a.get(0).size()];
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    foundRows[i] = 1;
                    foundCols[j] = 1;
                }
            }
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
               if(foundRows[i] == 1 || foundCols [j] == 1){
                   a.get(i).set(j,0);
               }
            }
        }
    }

    public static void setZeroesIB(ArrayList<ArrayList<Integer>> a) {

        boolean colFirst = false;
        boolean rowFirst = false;

        int n = a.size();
        int m = a.get(0).size();

        for(int i=0;i<n;++i){
            if(a.get(i).get(0)==0){
                colFirst = true;
                break;
            }
        }

        for(int i=0;i<m;++i){
            if(a.get(0).get(i)==0){
                rowFirst = true;
                break;
            }
        }

        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                if(a.get(i).get(j)==0){
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }

        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                if(a.get(i).get(0)==0 || a.get(0).get(j)==0){
                    a.get(i).set(j, 0);
                }
            }
        }

        if(colFirst){
            for(int i=0;i<n;++i){
                a.get(i).set(0, 0);
            }
        }

        if(rowFirst){
            for(int i=0;i<m;++i){
                a.get(0).set(i, 0);
            }
        }
    }

    public static void main(String[] args) {
//        [
//        [0, 0]
//        [1, 0]
//        ]

        ArrayList<ArrayList<Integer>> arrayLis = new ArrayList<>();

        ArrayList<Integer> inner = new ArrayList<Integer>();
        inner.add(1);
        inner.add(1);

        arrayLis.add(inner);

        inner = new ArrayList<>();
        inner.add(0);
        inner.add(0);

        arrayLis.add(inner);
//        setZeroes(arrayLis);
        setZeroesIB(arrayLis);
        System.out.println(arrayLis);
    }



}
