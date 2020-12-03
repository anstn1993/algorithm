package algorithm.투포인터.linkedlistcycle2;
/*
 * 출처: leetcode
 * 문제 이름: Linked List Cycle 2
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
    /*
    * 문제를 풀기 위해서 변수들 간의 관계를 봐야 한다.
    *
    * A: 시작노드로부터 루프의 시작 노드까지의 길이
    * B: 루프 전체의 길이
    * X: 루프의 처음노드부터 현재 노드까지의 길이
    *
    * 위의 변수를 토대로 walker와 runner의 관계를 보자. 두 노드가 만난 시점에는 runner가 walker의 2배만큼 이동을 했을 것이다.
    * 2 * walker = runner
    * 2A + 2X = A + X + n*B
    * A + X = n*B
    *
    * 그럼 결국 처음 노드에서 출발하는 워커와 X지점에서부터 출발하는 워커를 한칸씩 전진시키면
    * 루프의 처음 노드에서 만나게 된다.
    * */
    public ListNode detectCycle(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        while (runner != null) {
            runner = runner.next;
            if(runner != null) {
                runner = runner.next;
                walker = walker.next;
                if(runner == walker) {
                    break;
                }
            }
            else {
                break;
            }
        }
        if(runner == null) return null;
        ListNode check = head;
        while(check != walker) {
            check = check.next;
            walker = walker.next;
        }
        return check;
    }
}
