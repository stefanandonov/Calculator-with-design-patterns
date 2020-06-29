package mk.ukim.finki.memento;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;

interface Visitor <T extends Comparable<T>>{
    String visit (BTNode<T> node);
}

interface Element<T extends Comparable<T>> {
    String accept (Visitor<T> v);
}

class PrintVisitor<T extends Comparable<T>> implements Visitor<T> {

    @Override
    public String visit(BTNode<T> node) {
        if (node.data==null) return "EMPTY";

        String result = ((node.left!=null ? node.left.accept(this) : "")
                + (node.data!=null && node.exists ? node.data.toString()+" " : "")
                + (node.right!=null ? node.right.accept(this) : ""));

        //if (result.charAt(result.length()-1)==' ')
        //	return result.substring(0,result.length());
        //else
        return trimFromEnd(result);
    }

    private String trimFromEnd (String string) {
        int count = 0;
        for (int i=string.length()-1;i>0;i--)
            if (string.charAt(i)==' ')
                ++count;
            else {
                break;
            }

            return string.substring(0,string.length()-count);
    }
}

class BTNode<T extends Comparable<T>> implements Element<T> {
    T data;
    BTNode<T> left, right;
    boolean exists = true;

    public void addElement(T t) {
        if (data!=null && data.compareTo(t)==0) {
            if (!exists)
                exists=true;
            return;
        }
        if (data==null) {
            data = t;
        }
        else if (t.compareTo(data)<0) { //left
            if (left == null)
                left = new BTNode<>();
            left.addElement(t);
        } else if (t.compareTo(data)>0) { //right
            if (right == null)
                right = new BTNode<>();
            right.addElement(t);
        }
    }

    public boolean contains(T element) {
        if (data==null)
            return false;
        if (data.compareTo(element)==0)
            return exists;
        else if (element.compareTo(data)<0) {
            if (left==null)
                return false;
            return left.contains(element);
        }
        else {
            if (right==null)
                return false;
            return right.contains(element);
        }
    }

    @Override
    public String toString() {
        return (left==null && right==null) ? data.toString() : (data.toString()+" ");
    }

    @Override
    public String accept(Visitor<T> v) {
        return v.visit(this);
    }

    public void removeElement(T next) {
        if (data==null)
            return;
        else if (data.compareTo(next)==0) {
            this.exists = false;
            return ;
        }
        if (left!=null && next.compareTo(data)<0) {
            left.removeElement(next);
            return ;
        }
        if (right!=null && next.compareTo(data)>0) {
            right.removeElement(next);
        }

    }
}

class BinaryTreeSet<T extends Comparable<T>> {
    BTNode<T> root;

    BinaryTreeSet() {
        root = new BTNode<T>();
    }

    public void addElement(T t) {
        root.addElement(t);
    }

    public boolean contains(T element) {
        return root.contains(element);
    }

    @Override
    public String toString() {
        return new PrintVisitor<T>().visit(root);
    }

    public void removeElement(T next) {
        root.removeElement(next);
    }
}

public class BinaryTreeSetTest {

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        int t = jin.nextInt();
        if ( t == 0 ) {
            BinaryTreeSet<Integer> ts = new BinaryTreeSet<Integer>();
            while ( jin.hasNextInt() ) {
                ts.addElement(jin.nextInt());
            }
            System.out.println(ts);
        }
        if ( t == 1 ) {
            BinaryTreeSet<String> ts = new BinaryTreeSet<String>();
            while ( true ) {
                String next = jin.next();
                if ( next.equals("stop") ) break;
                ts.addElement(next);
            }
            System.out.println(ts);
        }
        if ( t == 2 ) {
            BinaryTreeSet<Long> ts = new BinaryTreeSet<Long>();
            while ( jin.hasNextLong() ) {
                ts.addElement(jin.nextLong());
            }
            jin.next();
            System.out.println(ts);
            while ( jin.hasNextLong() ) {
                System.out.println(ts.contains(jin.nextLong()));
            }
            System.out.println(ts);
        }
        if ( t == 3 ) {
            BinaryTreeSet<String> ts = new BinaryTreeSet<String>();
            int counter = 0;
            while ( true ) {
                if ( counter % 20 == 0 ) System.out.println(ts);
                ++counter;
                String next = jin.next();
                if ( next.equals("stop") ) break;
                if ( next.equals("add") ) {
                    ts.addElement(jin.next());
                }
                if ( next.equals("remove") ) {
                    ts.removeElement(jin.next());
                }
                if ( next.equals("query") ) {
                    System.out.println(ts.contains(jin.next()));
                }
            }
            System.out.println(ts);
        }
        if ( t == 4 ) {
            BinaryTreeSet<Long> ts = new BinaryTreeSet<Long>();
            TreeSet<Long> control_set = new TreeSet<Long>();
            ArrayList<Long> all = new ArrayList<Long>();
            all.add(5L);
            int n = jin.nextInt();
            boolean exact = true;
            for ( int i = 0 ; exact&&i < n ; ++i ) {
                if ( Math.random() < 0.4 ) {
                    if ( Math.random() < 0.6 ) {
                        long to_add = (long)(Math.random()*98746516548964156L);
                        ts.addElement(to_add);
                        control_set.add(to_add);
                        all.add(to_add);
                    }
                    else {
                        int add_idx = (int)(Math.random()*all.size());
                        long to_add = all.get(add_idx);
                        ts.addElement(to_add);
                        control_set.add(to_add);
                    }
                }
                else {
                    if ( Math.random() < 0.4 ) {
                        if ( Math.random() < 0.1 ) {
                            long to_remove = (long)(Math.random()*98746516548964156L);
                            ts.removeElement(to_remove);
                            control_set.remove(to_remove);
                        }
                        else {
                            int remove_idx = (int)(Math.random()*all.size());
                            long to_remove = all.get(remove_idx);
                            ts.removeElement(to_remove);
                            control_set.remove(to_remove);
                        }
                    }
                    else {
                        if ( Math.random() < 0.3 ) {
                            long to_query = (long)(Math.random()*98746516548964156L);
                            exact &= ts.contains(to_query)==control_set.contains(to_query);
                        }
                        else {
                            int query_idx = (int)(Math.random()*all.size());
                            long to_query = all.get(query_idx);
                            exact &= ts.contains(to_query)==control_set.contains(to_query);
                        }
                    }
                }
            }
            System.out.println(exact);
        }
    }

}
