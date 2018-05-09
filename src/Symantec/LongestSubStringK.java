package Symantec;

/**
 * Created by vinod on 30/3/18.
 */
public class LongestSubStringK {

    public static void main(String[] args) {


        kUniques("aabdddfGGGGhjt",1);

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
}
