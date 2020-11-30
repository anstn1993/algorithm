package algorithm.구현.mergetwosortedlists;


/*
 * 출처: leetcode
 * 문제 이름: Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        //두 linkedlist의 현재 노드 값을 비교하면서 작은 값을 result에 넣어주고 next 노드로 현재 노드를 설정해준다.
        while(l1 != null || l2 != null) {
            //l2의 원소가 null이거나 l1의 원소가 l2의 원소보다 작거나 같은 경우
            if(l2 == null || (l1 != null && l1.val <= l2.val)) {//l1의 값을 추가
                if(result == null) {
                    result = l1;
                    current = result;
                }
                else {
                    current.next = l1;
                    current = current.next;
                }
                l1 = l1.next;
            }
            else {//l2의 원소를 추가
                if(result == null) {
                    result = l2;
                    current = result;
                }
                else {
                    current.next = l2;
                    current = current.next;
                }
                l2 = l2.next;
            }
        }

        return result;
    }
}
