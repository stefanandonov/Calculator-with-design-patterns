//package mk.ukim.finki.uvid;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//class CircularList<T> {
//
//}
//
//public class CircularListTest {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        CircularList<Integer> list = new CircularList<Integer>(n);
//        try {
//            list.rotateLeft(2);
//        } catch (InvalidRotationException e) {
//            System.out.println("InvalidRotationException");
//        }
//        for (int i = 0; i < n; ++i) {
//            list.addElement(scanner.nextInt());
//        }
//        System.out.println(list);
//        for (int i = 0; i < m; ++i) {
//            int a = scanner.nextInt();
//            System.out.println("ADD " + a);
//            list.addElement(a);
//            System.out.println(list);
//        }
//        int r = scanner.nextInt();
//        System.out.println("ROTATION LEFT " + r);
//        try {
//            list.rotateLeft(r);
//        } catch (InvalidRotationException e) {
//            System.out.println("InvalidRotationException");
//        }
//        System.out.println(list);
//        r = scanner.nextInt();
//        System.out.println("ROTATION RIGHT " + r);
//        try {
//            list.rotateRight(r);
//        } catch (InvalidRotationException e) {
//            System.out.println("InvalidRotationException");
//        }
//        System.out.println(list);
//        int p = scanner.nextInt();
//        System.out.println("ELEMENT ON POSITION " + p);
//        try {
//            System.out.println(list.getElement(p));
//        } catch (InvalidIndexException e) {
//            System.out.println("InvalidIndexException");
//        }
//        int x = scanner.nextInt();
//        System.out.println("ADD " + x);
//        list.addElement(x);
//        System.out.println(list);
//        System.out.println("ELEMENT ON POSITION " + (p + 1));
//        try {
//            System.out.println(list.getElement(p + 1));
//        } catch (InvalidIndexException e) {
//            System.out.println("InvalidIndexException");
//        }
//    }
//}
//
////вашио код овде