package algorithm.구현.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

//큐 하나로 구현
public class MyStack2 {

    private Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int size = q.size();
        q.offer(x);
        //앞에 있는 값들을 다 뽑아서 방금 push된 값 뒤에 push
        for (int i = 0; i < size; i++) {
            q.offer(q.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}
