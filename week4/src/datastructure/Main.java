package datastructure;

import java.util.*;

public class Main {

    static Stack<Integer> s = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        s.push(5);
        System.out.print("Output: - Stack: ");
        for(int i=0; i<s.size(); i++) {
            System.out.print(s.get(i) + " ");
        }
        System.out.println();

        s.push(3);
        System.out.print("Output: - Stack: ");
        for(int i=0; i<s.size(); i++) {
            System.out.print(s.get(i) + " ");
        }
        System.out.println();

        try {
            System.out.print("Output: " + s.pop() + " Stack: ");
        } catch(EmptyStackException e) {
            System.out.print("Output: Error Stack: ");
        } finally {
            for(int i=0; i<s.size(); i++) {
                System.out.print(s.get(i) + " ");
            }
            System.out.println();
        }

        s.push(7);
        System.out.print("Output: - Stack: ");
        for(int i=0; i<s.size(); i++) {
            System.out.print(s.get(i) + " ");
        }
        System.out.println();

        try {
            System.out.print("Output: " + s.pop() + " Stack: ");
        } catch(EmptyStackException e) {
            System.out.print("Output: Error Stack: ");
        } finally {
            for(int i=0; i<s.size(); i++) {
                System.out.print(s.get(i) + " ");
            }
            System.out.println();
        }

        System.out.print("Output: " + s.peek() + " Stack: ");
        for(int i=0; i<s.size(); i++) {
            System.out.print(s.get(i) + " ");
        }
        System.out.println();

        try {
            System.out.print("Output: " + s.pop() + " Stack: ");
        } catch(EmptyStackException e) {
            System.out.print("Output: Error Stack: ");
        } finally {
            for(int i=0; i<s.size(); i++) {
                System.out.print(s.get(i) + " ");
            }
            System.out.println();
        }


        try {
            System.out.print("Output: " + s.pop() + " Stack: ");
        } catch(EmptyStackException e) {
            System.out.print("Output: Error Stack: ");
        } finally {
            for(int i=0; i<s.size(); i++) {
                System.out.print(s.get(i) + " ");
            }
            System.out.println();
        }

        System.out.print("Output: " + s.isEmpty() + " Stack: ");
        for(int i=0; i<s.size(); i++) {
            System.out.print(s.get(i) + " ");
        }
        System.out.println();

        System.out.println();


        q.offer(5);
        System.out.print("Output: - Front: ");
        System.out.println(q.element());

        q.offer(3);
        System.out.print("Output: - Front: ");
        System.out.println(q.element());

        System.out.print("Output: " + q.poll() + " Front: ");
        try {
            System.out.println(q.element());
        } catch (NoSuchElementException e) {
            System.out.println();
        }

        q.offer(7);
        System.out.print("Output: - Front: ");
        System.out.println(q.element());

        System.out.print("Output: " + q.poll() + " Front: ");
        try {
            System.out.println(q.element());
        } catch (NoSuchElementException e) {
            System.out.println();
        }

        System.out.print("Output: " + q.poll() + " Front: ");
        try {
            System.out.println(q.element());
        } catch (NoSuchElementException e) {
            System.out.println();
        }

        System.out.print("Output: " + q.isEmpty() + " Front: ");
        try {
            System.out.println(q.element());
        } catch (NoSuchElementException e) {
            System.out.println();
        }


    }
}
