package algorithm.구현.implementqueueusingstacks;

import java.util.Stack;

/*
 * 출처: leetcode
 * 문제 이름: Implement Queue using Stacks
 * */
public class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        //out스택에 값이 있으면 그 값을 모두 in으로 이동 후에 in에 새로운 값 push
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //in에 있는 값을 모두 out으로 옮겨준다.
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        //in에 있는 값을 모두 out으로로 옮겨준다.
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
