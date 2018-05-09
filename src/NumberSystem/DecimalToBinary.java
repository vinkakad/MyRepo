package NumberSystem;

import com.sun.deploy.util.StringUtils;

/**
 * Created by vinod on 27/11/17.
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(getBinary(90876));
    }

    private static String getBinary(int n) {

        StringBuilder binaryString = new StringBuilder();
        while (n > 0) {
           binaryString.append((n % 2));
            n = n / 2;
        }
        return binaryString.reverse().toString();
    }
}
