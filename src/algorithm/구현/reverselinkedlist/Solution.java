package algorithm.구현.reverselinkedlist;

import java.util.Stack;
/*
 * 출처: leetcode
 * 문제 이름: Reverse Linked List
 * */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        //스택에 쌓아준 후 꺼내면서 붙여준다.
        Stack<ListNode> s = new Stack<>();
        while (head != null) {
            s.push(head);
            head = head.next;
        }
        ListNode reverse = new ListNode(s.pop().val);
        ListNode temp = reverse;
        while (!s.isEmpty()) {
            temp.next = new ListNode(s.pop().val);
            temp = temp.next;
        }
        return reverse;
    }
}
