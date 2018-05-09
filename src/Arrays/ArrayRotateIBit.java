package Arrays;

import java.util.ArrayList;

/**
 * Created by vinod on 28/11/17.
 */
public class ArrayRotateIBit {

        public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            /*while(B >= A.size())
                B = B-A.size();*/
            for (int i = 0; i < A.size(); i++) {
                ret.add(A.get((i+B)%A.size()));
            }
            /*for(int j=0; j<B;j++){
                ret.add(A.get(j));
            }*/
            return ret;
        }

    static ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>() {{
            add(5);
            add(10);
            add(2);
            add(1);
        }};
        ArrayList<Integer> B = performOps(A);
        for (int i = 0; i < B.size(); i++) {
            System.out.print(B.get(i) + " ");
        }
    }

}
