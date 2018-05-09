package Intvbit;

import java.util.ArrayList;

/**
 * Created by vinod on 11/12/17.
 */
public class Add1ToNumber {

    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        ArrayList<Integer> addedOne = new ArrayList<>();


        int carry = 1;
        int number = 0;

        for (int i = (a.size() - 1); i >=0 ; i--) {
            int i1 = a.get(i) + carry;

            number = i1 % 10;

            carry = i1 / 10;

            addedOne.add(number);
        }

        if(carry != 0)
            addedOne.add(carry);

        ArrayList<Integer> addedOneRev = new ArrayList<>();

        int i=0,j=(addedOne.size()-1);

        while(addedOne.get(j) == 0){
            j--;
        }

        for (i=0;j >= 0 && i < addedOne.size(); j--, i++) {
            addedOneRev.add(addedOne.get(j));
        }
        return addedOneRev;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>() {{
            add(9);
            add(9);
            add(9);
            add(9);
            add(9);
            add(9);
            add(9);add(9);add(9);add(9);add(9);add(9);add(9);add(9);add(9);add(9);add(9);add(9);add(9);
        }};
        System.out.println(plusOne(arrayList));
    }
}
