/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

class GFG {
    public static void main (String[] args) {
        BlockingQueue bq = new ArrayBlockingQueue(10);
        bq.offer(100);
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();

        for(int index=0;index<t;index++){
            String inputString = sc.next();
            boolean gp = false,f = false;
            int count = 0;
            for(int i=0;i<inputString.length();i++){

                if(inputString.charAt(i) == 'g' && gp == false){
                    gp = true;
                    continue;
                }

                if(inputString.charAt(i) == 'f' && gp == true && f == false){
                    f= true;
                    continue;
                }

                if(inputString.charAt(i) == 'g' && gp == true
                        && f == true){
                    count++;
                }
                gp=false;f=false;
            }
            System.out.println(count == 0 ? -1 : count);
        }
    }



    /*While attending Geeks Classes, Shivani went through a question in which an array was given and she was asked to maximize the sum of array so that after selecting an element A[i] from array, delete one occurrence of A[i]-1. But, she got stucked and asked you for help. Help Shivani in solving this question.
            Note : Elements to be selected are from maximum to minimum.

            Input :
    The first line of the input contains T  denoting the number of the test cases. For each test case T, the first line contains an integer N denoting the size of the array. Next line contains N space separated integers denoting the elements of the array.

            Output :
    For each test case, the output is an integer displaying the maximum sum of selected numbers.

    Constraints :
            1<=T<=100​
            1<=n<=50
            1<=A[i]<=20

    Example :
    Input
    2
            3
            1 2 3
            6
            1 2 2 2 3 4
    Output
    4
            10*/
}