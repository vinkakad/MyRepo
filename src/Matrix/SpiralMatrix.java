package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinod on 29/11/17.
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SolutionTest se = new SolutionTest();
        SolutionFastest sf = new SolutionFastest();
        SolutionTestDir sdr = new SolutionTestDir();
        List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> inner = new ArrayList<Integer>();
        inner.add(1);
        inner.add(2);
        inner.add(3);
        inner.add(4);

        A.add(inner);

        inner = new ArrayList<>();
//        inner.add(4);
        inner.add(5);
        inner.add(6);
        inner.add(7);
        inner.add(8);

        A.add(inner);

        inner = new ArrayList<>();
//         inner.add(7);
//         inner.add(8);
        inner.add(9);
        inner.add(10);
        inner.add(11);
        inner.add(12);
//
        A.add(inner);

        inner = new ArrayList<>();
        inner.add(13);
        inner.add(14);
        inner.add(15);
        inner.add(16);

        A.add(inner);

        List B = getArrayList();

       // System.out.println(se.spiralOrder(A));
        System.out.println(sf.spiralOrder(B));
        System.out.println(sdr.spiralOrder(B));
    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> inner = a.get(i);
            for (int j = 0; j < inner.size(); j++) {
                result.add(inner.get(j));
            }
            break;
        }



        return result;
    }



    public static class SolutionEditorial {
        // DO NOT MODIFY THE LIST
        public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Populate result;
            int m, n;

            m = A.size();
            n = A.get(0).size();

            if (m == 0)
                return result;

            int len;
            int dir = 0; // right
            int row, col, layer;
            row = col = layer = 0;

            result.add(A.get(0).get(0));


            for (int step = 1; step < m * n; step++) {

                switch(dir) {

                    // Go right
                    case 0:

                        if (col == n - layer - 1) {
                            dir = 1;
                            row++;
                        } else {
                            col++;
                        }

                        break;

                    // Go down
                    case 1:

                        if (row == m - layer - 1) {
                            dir = 2;
                            col--;
                        } else {
                            row++;
                        }

                        break;

                    // Go left
                    case 2:

                        if (col == layer) {
                            dir = 3;
                            row--;
                        } else {
                            col--;
                        }

                        break;

                    // Go up
                    case 3:

                        if (row == layer + 1) {
                            dir = 0;
                            col++;
                            layer++;
                        } else {
                            row--;
                        }

                        break;

                }

                //System.out.println(row + " " + col);
                result.add(A.get(row).get(col));

            }




            return result;
        }
    }


    public static class SolutionFastest {
        // DO NOT MODIFY THE LIST
        public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
            ArrayList<Integer> result = new ArrayList<Integer>();

            int current = 1;
            // Start in the corner
            int x = 0, y = 0, dx = 1, dy = 0;

            int columnSize = a.size();
            int rowSize = a.get(0).size();
            int spiral[][]= new int[columnSize][rowSize];

            while (current <= columnSize*rowSize) {
                // Go in a straight line
               // System.out.print(a.get(y).get(x) + " ");
                result.add(a.get(y).get(x));
                spiral[y][x] = current++;
                int nx = x + dx, ny = y + dy;

                // When you hit the edge...
                if (nx < 0 || nx == rowSize || ny < 0 || ny == columnSize || spiral[ny][nx] != 0) {
                    // ...turn right
                    int t = dy;
                    dy = dx;
                    dx = -t;
                }
                x += dx;
                y += dy;
            }



            return result;
        }
    }

    public static class SolutionLightWeight {
        // DO NOT MODIFY THE LIST
        public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Populate result;
            int col=a.get(0).size(),row=a.size();

            int top=0,right=a.get(0).size()-1,bottom=a.size()-1,left=0;
            int count=a.get(0).size()*a.size();
            int i=0,j=0,k=0,l=0,m=0;
            while(i<count){
                for(j=top;j<col-top;j++){
                    if(count==i){
                        return result;
                    }
                    result.add(a.get(top).get(j));
                    i++;
                    // System.out.println(a.get(top).get(j));
                }
                top++;
                for(k=top;k<(row-top);k++){
                    if(count==i){
                        return result;
                    }
                    result.add(a.get(k).get(right));
                    i++;
                    // System.out.println(a.get(k).get(right));
                }
                right--;
                for(l=right+1;l>=left;l--){
                    if(count==i){
                        return result;
                    }
                    result.add(a.get(bottom).get(l));
                    i++;
                    // System.out.println(a.get(bottom).get(l));
                }
                bottom--;
                for(m=bottom;m>=top;m--){
                    if(count==i){
                        return result;
                    }
                    result.add(a.get(m).get(left));
                    i++;
                    //  System.out.println(a.get(m).get(left));
                }
                left++;
                //   System.out.println("ewt");

            }

            return result;
        }
    }

    public static class SolutionTest{
        public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
         ArrayList<Integer> result = new ArrayList<Integer>();
            int rowSize = a.size();
            int columnSize = a.get(0).size();

            int rowIndex = 1;
            int columnIndex = 0;

            int currentRow =0;
            int currentColumn = 0;

          /*  if(rowSize == 1){
                for(currentColumn=columnIndex;currentColumn<columnSize;currentColumn++){
                    result.add(a.get(currentRow).get(currentColumn));
                }
                return result;
            }*/

            while (rowIndex <= rowSize && columnIndex < columnSize) {

                for(currentColumn=columnIndex;currentColumn<columnSize;currentColumn++){
                    result.add(a.get(currentRow).get(currentColumn));
                }
                currentColumn--;

                for(currentRow = rowIndex;currentRow<rowSize;currentRow++){
                    result.add(a.get(currentRow).get(currentColumn));
                }

                currentRow--;
                currentColumn--;

                for(;currentColumn>=columnIndex && rowSize > 1; currentColumn--){
                    result.add(a.get(currentRow).get(currentColumn));
                }

                columnIndex++;
                currentColumn++;
                currentRow--;

                for(;currentRow>rowIndex;currentRow--){
                    result.add(a.get(currentRow).get(currentColumn));
                }

                rowIndex++;
                currentRow++;
                rowSize--;
                columnSize--;
            }

            return result;
        }
    }

    public static class SolutionTestDir {
        public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
            ArrayList<Integer> result = new ArrayList<Integer>();

            int dir = 0;
            int rowSize = a.size();
            int columnSize = a.get(0).size();


            int elementCount = 1;
            int matrixLevel = 0;

            int column = 0;
            int row = 0;
            while (elementCount <= rowSize * columnSize) {
                switch (dir) {
                    //Go right same row but increase columnIndex
                    case 0:
                        result.add(a.get(row).get(column));
                        if (column == (columnSize - matrixLevel - 1)) {
                            row++;
                            dir = 1;
                        } else {
                            column++;
                        }
                        break;
                    //Go down
                    case 1:
                        result.add(a.get(row).get(column));
                        if (row == (rowSize - matrixLevel - 1)) {
                            column--;
                            dir = 2;
                        } else {
                            row++;
                        }
                        break;
                    //Go left
                    case 2:
                        result.add(a.get(row).get(column));
                        if (column == matrixLevel) {
                            row--;
                            dir = 3;
                        } else {
                            column--;
                        }
                        break;
                    //Go up
                    case 3:
                        result.add(a.get(row).get(column));
                        if(row == matrixLevel +1){
                            column++;
                            dir=0;
                            matrixLevel++;
                        }else{
                            row--;
                        }
                        break;
                }
                elementCount++;
            }
            return result;
        }
    }


    private static List<ArrayList<Integer>> getArrayList(){

        List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> inner = new ArrayList<Integer>() {{
            add(313);
            add(157);
            add(290);
            add(113);
            add(119);
            add(118);
            add(187);
            add(360);
            add(104);
            add(365);
            add(197);
            add(103);
            add(355);
            add(240);
            add(337);
            add(174);
            add(138);
            add(252);
        }};

        A.add(inner);

       /* ArrayList<Integer> inner = new ArrayList<Integer>() {
            {
                add(11);
                add(217);
                add(223);
                add(213);
                add(178);
                add(226);
                add(166);
                add(212);
                add(121);
                add(277);
                add(188);
                add(5);
                add(56);
                add(354);
                add(6);

            }
        };

        A.add(inner);

        inner = new ArrayList<Integer>() {{
            add(69);
            add(384);
            add(201);
            add(369);
            add(72);
            add(174);
            add(320);
            add(265);
            add(61);
            add(397);
            add(152);
            add(10);
            add(385);
            add(288);
            add(23);
        }};

        A.add(inner);*/

        /*ArrayList<Integer> inner = new ArrayList<Integer>() {
            {
               add(1);
            }};
        A.add(inner);

        inner = new ArrayList<Integer>() {{
            add(2);
        }};

        A.add(inner);
        inner = new ArrayList<Integer>(){{
            add(3);
        }};
        A.add(inner);*/
        return A;
    }
}