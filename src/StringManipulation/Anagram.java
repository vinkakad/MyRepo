package StringManipulation;

import java.util.Arrays;

/**
 * Created by vinod on 1/4/18.
 */
public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("logain", "gainlo"));
    }

    private static boolean isAnagram(String original, String anagram) {

        char[] originalArr = original.toCharArray();
        char[] anaArr = anagram.toCharArray();

        Arrays.sort(originalArr);//Nlogn
        Arrays.sort(anaArr);//+Nlogn

        original = new String(originalArr);
        anagram = new String(anaArr);

        if (original.contains(anagram)) {
            //o(1)
            return true;
        }
        return false;
    }
}
