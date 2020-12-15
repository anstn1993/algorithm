package algorithm.구현.intersectionoftwolinkedlists;

import java.util.HashSet;
import java.util.Set;

/*
 * 출처: leetcode
 * 문제 이름: Intersection of Two Linked Lists
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //set을 이용해서 하나의 링크드 리스트 노드를 먼저 다 삽입
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //다른 링크드 리스트를 순회하면서 set에 노드가 겹치는 게 존재하면 그 노드를 return
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
