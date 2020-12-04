package algorithm.구현.copylistwithrandompointer;

import java.util.HashMap;
import java.util.Map;

/*
 * 출처: leetcode
 * 문제 이름: Copy List With Random Pointer
 * */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> randomPointer = new HashMap<>();
        Node current = head;
        Node deepCopiedNode = null;//깊은 복사가 될 linked list
        //기존 linked list의 각 노드와 대응되는 새로운 노드를 만들어서 해쉬맵에 저장
        while(current != null) {
            randomPointer.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        deepCopiedNode = randomPointer.get(head);
        while(current != null) {
            //해쉬 맵에 저장된 깊은 복사된 노드를 빼와서 next, random노드로 지정해준다.
            deepCopiedNode.next = randomPointer.get(current.next);
            deepCopiedNode.random = randomPointer.get(current.random);
            deepCopiedNode = deepCopiedNode.next;
            current = current.next;
        }
        return randomPointer.get(head);
    }
}
