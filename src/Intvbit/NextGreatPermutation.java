package Intvbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vinod on 15/12/17.
 */
public class NextGreatPermutation {
    public static void nextPermutation(ArrayList<Integer> a) {
        int indexD = 0;
        boolean found = false;
        for (int i = (a.size()-1); i>0 ; i--) {

            if (a.get(i - 1) < a.get(i)) {
                indexD = i - 1;
                found = true;
                break;
            }
        }
            if(found){
                int indexS = indexD+1;
                for(int j=indexD+1; j<a.size();j++){
                    if(a.get(indexD) < a.get(j) && a.get(indexS) > a.get(j)){
                        indexS = j;
                    }
                }
                int temp = a.get(indexD);
                a.set(indexD,a.get(indexS));
                a.set(indexS,temp);

                for (int l = indexD+1, j = a.size()-1; l < a.size() && j > indexD && j > l; l++, j--) {
                    temp = a.get(l);
                    a.set(l,a.get(j));
                    a.set(j,temp);
                }
            }else {
                for(int i=0,j=a.size()-1;i<a.size() && j>=0 && i<j;j--,i++){
                    int temp = a.get(i);
                    a.set(i,a.get(j));
                    a.set(j,temp);
                }
            }


    }

    public static void main(String[] args) {

        Integer[] objects = {444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52};
//        Integer[] objects = {5,3,4,9,7,6};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(objects));
        nextPermutation(arr);
        System.out.println(arr);
    }
}
