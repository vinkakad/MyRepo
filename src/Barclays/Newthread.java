//package Barclays;
//
///**
// * Created by vinod on 21/4/18.
// */
//class Newthread extends Thread {
//
//        Thread t;
//
//        String name;
//
//        Newthread(String threadname) {
//
//        name = threadname;
//
//        t = new Thread(this,name);
//
//        t.start();
//
//        }
//
//public void run() {}
//
//        }
//
//        Class Multithreaded_programing {
//
//public static void main(String args[]) {
//
//        Newthread obj1 = new Newthread("one");
//
//        Newthread obj2 = new Newthread("two");
//
//        try {
//
//        obj1.t.wait();
//
//        System.out.print(obj1.t.isAlive());
//
//        }
//
//        catch(Exception e) {
//
//        System.out.print("Main thread interrupted");
//
//        }
//
//        }
//
//        }
