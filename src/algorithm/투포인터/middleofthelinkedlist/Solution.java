package algorithm.투포인터.middleofthelinkedlist;

/*
 * 출처: leetcode
 * 문제 이름: Middle of the Linked List
 * */
class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/*
 * 링크드리스트의 중간 노드를 찾기 위해서는 반복문 두 번을 이용할 수 있다. 첫 반복으로 size를 구하고
 * 그걸 토대로 두 번째 반복에서 중간 노드를 찾는 방식이다.
 *
 * 하지만 그것보다는 워커/러너 테크닉으로 한 번의 반복만으로 바로 중간 노드를 구할 수 있다.
 * walker: 한 번에 한 칸씩 이동
 * runner: 한 번에 두 칸씩 이동
 * runner가 마지막 노드에 도달하면 walker는 중간에 와있게 된다.
 **/
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        //runner를 먼저 한 칸 전진시킨 후 null체크를 해서 null이 아니면 walker, runner를 한 칸씩 전진시킨다.
        //그럼 한 루프에서 walker는 한 칸, runner는 두 칸 이동한다.
        //이 상태에서 runner가 null이면 바로 walker를 return해주면 된다.
        while(runner != null) {
            runner = runner.next;
            if(runner != null) {
                walker = walker.next;
                runner = runner.next;
            }
        }
        return walker;
    }
}
