package algorithm.구현.minstack;

import java.util.Stack;

class Node {
    int val;
    int min;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
public class MinStack {


    private Stack<Node> stack;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Node node = null;
        if(stack.isEmpty()) {
            node = new Node(x, x);
        }
        else {
            node = new Node(x, stack.peek().min > x ? x : stack.peek().min);
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
