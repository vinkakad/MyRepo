import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by vinod on 11/5/18.
 */
public class GCET {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();

        int column1Length;
        int column2Length;

        for (int index = 1; index <= t; index++) {
            column1Length = sc.nextInt();
            column2Length = sc.nextInt();

            int column1Score = 0;
            int column2Score = 0;

            for (int i = 0; i < column1Length; i++) {
                column1Score += sc.nextInt();
            }
            for (int i = 0; i < column2Length; i++) {
                column2Score += sc.nextInt();
            }
            System.out.println(column2Score > column1Score ? "C2" : "C1");
        }
    }
}
