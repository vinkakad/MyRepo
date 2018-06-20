package Symantec;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vinod on 30/3/18.
 */
public class LongestSubStringK {

    public static void main(String[] args) {


        //kUniques("aabdddfGGGGhjt", 1);
        System.out.println(getKuniqueString("aabdddddfGGGGhjt", 8));
        System.out.println("*****************************");
        System.out.println(getOptimizedKUniqueString("aabdddddfGGGGhjt",8));

    }

    public static void kUniques(String s, int k) {
        int u = 0; // number of unique characters
        int n = s.length();

        // Associative array to store the count of characters
        int count[] = new int[256];
//        memset(count, 0, sizeof(count));

        // Traverse the string, Fills the associative array
        // count[] and count number of unique characters
        for (int i = 0; i < n; i++) {

            //Character.isDigit('2');
            int charAt= s.charAt(i);
            int charPosition = s.charAt(i) - 'A';
            if (count[charPosition] == 0)
                u++;
            count[charPosition]++;
        }

        if (u < k) {
            System.out.println("Not enough unique chars");
            return;
        }

        int current_start =0,current_end = 0;
        int max_window_size=0,max_window_start = 1;

        count = new int[256];
        count[s.charAt(0) - 'a']++;

        for (int i = 1; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            current_end++;


            while(!isValid(count,k)){
                count[s.charAt(current_start) - 'a']--;
                current_start++;
            }

            if((current_end-current_start+1) > max_window_size){
                max_window_size = current_end-current_start+1;
                max_window_start = current_start;
            }
        }

        System.out.println("Longest substring "+s.substring(max_window_start,max_window_start+max_window_size));
    }

    private static boolean isValid(int[] count,int k){
        int val=0;
        for(int i=0;i<count.length;i++){
            if(count[i] != 0)
                val++;
        }
        return k >= val;
    }

    private static String getKuniqueString(String s, int k) {
        String longestString = s;
        int maxCount = 0;
        boolean foundString =false;
        Map<Character, Integer> characterMap = null;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int uCount = 0;
            characterMap = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                if (!characterMap.containsKey(s.charAt(j))) {
                    characterMap.put(s.charAt(j), 1);
                    uCount++;
                } else {
                    Integer integer = characterMap.get(s.charAt(j));
                    characterMap.put(s.charAt(j), integer + 1);
                }
                count++;
                if (uCount == k && count > maxCount) {
                    maxCount = count;
                    foundString = true;
                    longestString = s.substring(i, j + 1);
                    break;
                }
            }
        }
        if(!foundString)
            return  "Not enough unique chars";
        return longestString;
    }

    private static String getOptimizedKUniqueString(String s, int k) {
        int start = 0;
        int end = 0;
        int windowSize = 1;
        int windowStart = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put(s.charAt(0), 1);

        for (int i = 1; i < s.length(); i++) {

            if (!charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), 1);
            } else {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            }
            end++;

            while (!isLessThanK(charMap, k)) {
                Integer integer = charMap.get(s.charAt(start));
                if (null != integer)
                    if (integer == 1)
                        charMap.remove(s.charAt(start));
                    else {
                        charMap.put(s.charAt(start), integer - 1);
                    }
                start++;
            }

            if (windowSize < end - start + 1) {
                windowSize = end - start + 1;
                windowStart = start;
            }
        }
        if (charMap.size() < k)
            return "Not enough unique chars";
        return s.substring(windowStart, windowStart + windowSize);
    }


    private static boolean isLessThanK(Map<Character, Integer> charMap, int k) {

        if (charMap.size() > k)
            return false;

        return true;
    }
}
