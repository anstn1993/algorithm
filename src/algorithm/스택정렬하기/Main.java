package algorithm.스택정렬하기;

import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(1);
        s1.push(6);
        s1.push(2);
        s1.push(9);
        sort(s1);
        while(!s1.isEmpty()) {
            System.out.println(s1.pop());
        }
    }

    private static void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Integer value = s1.pop();
            while(!s2.isEmpty() && s2.peek() > value) {
                s1.push(s2.pop());
            }
            s2.push(value);
        }
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
