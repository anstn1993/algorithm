package algorithm.두개의stack으로큐만들기;
import java.util.Stack;
public class Queue<T> {
    Stack<T> stackNew, stackOld;

    public Queue(Stack<T> stackNew, Stack<T> stackOld) {
        this.stackNew = stackNew;
        this.stackOld = stackOld;
    }

    public int size() {
        return stackNew.size() + stackOld.size();
    }

    public void add(T value) {
        stackNew.push(value);
    }
    //stack new의 데이터를 모두 stack old로 이동
    private void shiftStacks() {
        if(stackOld.isEmpty()) {
            while(!stackNew.isEmpty()) {
                stackOld.push(stackNew.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOld.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOld.pop();
    }
}
