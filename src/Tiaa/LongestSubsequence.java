package Tiaa;

import java.util.Arrays;

/**
 * Created by vinod on 28/5/18.
 * Longest subsequence from array whose sum is less than K.
 */
public class LongestSubsequence {

    public static void main(String[] args) {

        int[] arr = new int[]{60, 10, 9, 8, 7, 2, 13, 101, 59};
        System.out.println(Arrays.toString(getLongestSubsequence(arr, 49)));

    }

    private static int[] getLongestSubsequence(int[] arr, int K) {
        int[] subsequence = null;
        int maxCount = 0;
        for(int i=0;i<arr.length;i++){
            int count = 0;
            int sum = 0;
            int j = i;
            for (;j<arr.length;j++){
                 sum+=arr[j];
                if(sum < K){
                    count++;
                }else{
                    break;
                }
            }

            if(count > maxCount){
                maxCount = count;
                int counter = i;
                subsequence  = new int[j-i];
                for (int l=0;l<j-i;l++){
                    subsequence[l] = arr[counter++];
                }
            }
        }
        return subsequence;
    }
}
