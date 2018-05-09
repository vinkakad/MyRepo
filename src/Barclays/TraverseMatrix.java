package Barclays;

/**
 * Created by vinod on 3/5/18.
 */
public class TraverseMatrix {


    public static void main(String[] args) {
        int[][] matrix = createMatrix(5, 5);
        traverseMatrix(matrix, 5, 5);
    }

    private static void traverseMatrix(int[][] matrix, int rows, int columns) {

        int i = rows-1, j = columns-1;
        int elements = rows * columns;

        int k = 0;
        while (k < elements) {

            for (; i >= 0 && j >= 0; j--) {
                System.out.print("\t"+matrix[i][j]);
                k++;
            }
            System.out.println();
            i--;
            j++;

            if (k == elements)
                break;

            for (; i >= 0 && j < columns; j++) {
                System.out.print("\t" + matrix[i][j]);
                k++;
            }
            System.out.println();
            j--;
            i--;
        }
    }

    private static int[][] createMatrix(int rows, int columns) {

        int matrix[][] = new int[rows][columns];
        int count = 1;

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                matrix[currentRow][currentColumn] = count++;
            }
        }
        return matrix;
    }
}
