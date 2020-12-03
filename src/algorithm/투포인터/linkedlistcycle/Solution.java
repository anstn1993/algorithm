package algorithm.투포인터.linkedlistcycle;
/*
 * 출처: leetcode
 * 문제 이름: Linked List Cycle
 * */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    //walker, runner 포인터를 활용
    public boolean hasCycle(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        while (runner != null) {
            runner = runner.next;
            if (runner == null) return false;
            runner = runner.next;
            walker = walker.next;
            if (runner == walker) return true;
        }
        return false;
    }
}
