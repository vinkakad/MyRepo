package Assignments;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vinod on 10/11/17.
 */
public class StringPartition {

    public int wordBreak(String s, Set<String> dict) {
        int leftStart = (s.length()/2);
        int rightStart = leftStart + 1;

        for(int i = leftStart, j = rightStart; i >= 0 & j < s.length(); i--, j++) {
            String wordL = s.substring(0, i);
            String wordR = s.substring(j, s.length());
            if(!dict.contains(wordL)  && !dict.contains(wordR)) {
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "CatMat";
        String[] dict = {"Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"};
        StringPartition stringPartition = new StringPartition();
        Set<String> dictSet = new HashSet<>();
        for(String word: dict) {
            dictSet.add(word);
        }
        System.out.println(stringPartition.wordBreak(s, dictSet));
    }

}
