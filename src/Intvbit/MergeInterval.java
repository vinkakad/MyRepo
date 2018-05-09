package Intvbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by vinod on 13/12/17.
 */
public class MergeInterval {


        public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

            ArrayList<Interval> finalIntervals = new ArrayList<Interval>();

            finalIntervals = new ArrayList<>();

            boolean inserted = false;
            int i = 0;

            for (Interval in : intervals) {
                if (in.start > newInterval.start) {
                    intervals.add(i, newInterval);
                    inserted = true;
                    break;
                }
                i++;
            }
            if (!inserted)
                intervals.add(newInterval);


            Stack<Interval> stack = new Stack<>();
            stack.push(intervals.get(0));
            for(i=1;i<intervals.size();i++){

                Interval in = intervals.get(i);
                Interval stTop = stack.peek();
//                new.st > in.st && new.st < in.end
                if(stTop.end >= in.start){
                    Interval intv = mergeIntervals(in, stTop);
                    stack.pop();
                    stack.push(intv);
                }else {
                    stack.push(in);
                }
            }
            while(!stack.empty()){
                finalIntervals.add(stack.pop());
            }
            Collections.reverse(finalIntervals);
        return finalIntervals;
    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Interval{");
            sb.append("start=").append(start);
            sb.append(", end=").append(end);
            sb.append('}');
            return sb.toString();
        }
    }

    private static Interval mergeIntervals(Interval a, Interval b) {
        Interval merged = new Interval();
        merged.start = Math.min(a.start, b.start);
        merged.end = Math.max(a.end, b.end);
        return merged;
    }

    public static void main(String[] args) {
        ArrayList<Interval> arr = new ArrayList<Interval>(){{
            add(new Interval(1, 2));
            add(new Interval(3, 5));
            add(new Interval(6, 7));
            add(new Interval(8, 10));
            add(new Interval(12, 16));
        }};

        Interval newInt = new Interval(4,9);
        System.out.println(Arrays.toString(insert(arr, newInt).toArray()));
    }
}
