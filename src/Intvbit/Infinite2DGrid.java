package Intvbit;

import java.util.ArrayList;

/**
 * Created by vinod on 11/12/17.
 */
public class Infinite2DGrid {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int count = 0;

        if(X.size() == 0)
            return 0;

        if(Y.size() == 0)
            return 0;

        int startX = X.get(0);
        int startY = Y.get(0);

        for (int i = 1; i < X.size(); i++) {
            int nextX = Math.abs(startX - X.get(i));
            int nextY = Math.abs(startY - Y.get(i));

            if(nextX > nextY)
                count = count +nextX;
            else
                count = count+ nextY;

            startX = X.get(i);
            startY = Y.get(i);
        }
        return count;
    }


    public static void main(String[] args) {

        ArrayList<Integer> X = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(6);
        }};
        ArrayList<Integer> Y = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(6);
        }};

        System.out.println(coverPoints(X, Y));
    }
}
