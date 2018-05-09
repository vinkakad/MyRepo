package Assignments;

/**
 * Created by vinod on 10/11/17.
 */
public class BuildPyramid {

    public boolean isPyramidPossible(int bricks) {
        int rowBricks = 1;
        while(bricks > 0) {
            bricks -= rowBricks;
            rowBricks += 2;
        }

        return bricks == 0;
    }

    public static void main(String[] args) {
        BuildPyramid buildPyramid = new BuildPyramid();
        System.out.println( String.format("Input: %d, Possible: %s", 4,buildPyramid.isPyramidPossible(4)) );
        System.out.println( String.format("Input: %d, Possible: %s", 9,buildPyramid.isPyramidPossible(9)) );
        System.out.println( String.format("Input: %d, Possible: %s", 15,buildPyramid.isPyramidPossible(7)) );
    }

}