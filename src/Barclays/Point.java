package Barclays;

import LinkedList.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vinod on 21/4/18.
 */
public class Point {

    public static int testImp = 0;

    private double _x_, _y_;
    public double y;
    public double x;
    public Point() {
        _x_ = 0;
        _y_ = 0;
    }
    public Point(double x, double y) {
        setX(x); setY(y);
    }
    public double getX() { return _x_; }
    public double getY() { return _y_; }
    public void setX(double x) { assert x>0; _x_ = x; }
    public void setY(double y) { assert y>0; _y_ = y; }

    public double dist (Point p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }

    public static List<Point> coordinates = new ArrayList<Point>();

    public String toString() {
        return ((int)getX()+" "+(int)getY());
    }

    public double perimeter() {
        double distance = 0;
        int len = coordinates.size();
        for(int i = 0; i < len; i++) {
            distance += coordinates.get(i).dist(coordinates.get((i+1)%len));
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int noOfSticks = s.nextInt();                 // Reading input from STDIN

        for (int i = 0; i < noOfSticks; i++) {

            Point p = new Point(s.nextInt(),s.nextInt());
            coordinates.add(p);
        }
        System.out.println(new Point().perimeter());
    }
}
