package StringManipulation;

import java.util.*;

/**
 * Created by vinod on 8/11/17.
 */
public class StringMinBreak {
    public static void main(String[] args) {
        String s = "CatMat";
        Set<String> dict = new HashSet<String>();
        //dict.add("Cat");
        //dict.add("Mat");
        dict.add("Ca");
        //dict.add("tM");
        dict.add("t");
        dict.add("a");
        dict.add("C");
        dict.add("Dog");
        dict.add("og");
        dict.add("Do");
        //dict.add("atMat");

//        int n = wordBreak(s, dict, 0, s.length());
//        System.out.println(n == s.length() ? -1 : n);
        System.out.println(getMinimumBreak(s,dict));
    }

    public static int wordBreak(String s, Set<String> dict, int l, int h) {

        if (l > h) {
            System.out.println("l is greater than h.. l is"+l +" and h is"+h);
            return s.length();
        }

        String temp = s.substring(l, h);
        if (dict.contains(temp)) {
            System.out.println("temp is " + temp + " for l"+l +" and h"+h);
            return 0;
        }

        String str = "";
        int min = s.length();
        for (int i = l; i < h; i++) {
            str += s.charAt(i);
            if (dict.contains(str)) {
                System.out.println("Dic contains "+str);
                min = Math.min(min, wordBreak(s, dict, i + 1, h)+1);
            }
        }
        return min;
    }

    public static int breakWord(String s,Set<String> dictionary){

        int min = s.length();
        if(dictionary.contains(s)){
            return 0;
        }

        for(int i=1;i<s.length();i++){
           String left = s.substring(0,i);
            if(dictionary.contains(left)){
                String right = s.substring(i,s.length());
                if(dictionary.contains(right)){
//                    min
                }
            }
        }
        return min;
    }

    private static int wordBreak(String s, Set<String> dictionary) {
        if (dictionary.contains(s))
            return 0;

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            if (dictionary.contains(left) && dictionary.contains(right))
                return 1;
        }

        for(int i=0;i<s.length();i++){

        }
        return -1;
    }


    private static int getMinimumBreak(String s, Set<String> dictionary) {

        if(dictionary.contains(s))
            return 0;

        int min = s.length();

        Iterator<String> iterator = dictionary.iterator();


        while(iterator.hasNext()){
            String str = iterator.next();
            if(s.startsWith(str)){
                min = Math.min(min,getMinimumBreak(s.substring(str.length()),dictionary)+1);
            }else{

            }
        }
        /*for(int i=0;i<spliterator.estimateSize();i++){
            if(s.startsWith(spliterator.))
        }*/


        return min;
    }
}
