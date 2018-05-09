package NumberSystem;

/**
 * Created by vinod on 27/11/17.
 */
public class BinaryToDecimal {
    public static void main(String[] args) {

        System.out.println(getDecimal("10110001011111100"));
    }

    private static int getDecimal(String binary){

        int n=0;
        for(int i=0;i<binary.length();i++){
            n = Integer.parseInt(String.valueOf(binary.charAt(i))) + (n * 2);
        }

        return n;
    }
}
