package algorithm.그리디.majorityelement;

/*
 * 출처: leetcode
 * 문제 이름: Majority Element
 * */
public class Solution {
    /*
     * 해결 방법
     * 1. HashMap<Integer, Integer>: key-label, value-count
     * 시간: O(n)
     * 공간: O(n)
     * 2. 과반수 득표 알고리즘
     * 시간: O(n)
     * 공간: O(1)
     *
     * 두 변수를 이용해서 해결한다.
     * x = label, cnt=득표 횟수
     * for each element a:
     *   if(cnt == 0) x = a, cnt ++;
     *   else if(x == a) cnt ++;
     *   else cnt --;
     * 위 루프가 종료되면 둘 중 하나가 참이다.
     * - 과반수 득표가 존재하지 않음
     * - 과반수 득표한 label은 변수 x
     *
     * 예1 : 3, 2, 3
     * 3 : x = 3, cnt = 1
     * 2 : x = 3, cnt = 0
     * 3 : x = 3, cnt = 1;
     * => 3
     *
     * 예2 : 3, 2
     * 3: x = 3, cnt = 1;
     * 2: x = 3, cnt = 0;
     * => 3
     * 예2처럼 cnt가 0인 상태로 끝이 나면 진짜 3이 가장 많은 득표를 했는지 루프를 한 번 더 돌면서 파악해야 한다.
     *
     * */
    public int majorityElement(int[] nums) {
        int count = 0;
        int x = 0;
        for (int element : nums) {
            if(count == 0) {
                x = element;
                count ++;
            }
            else if(x == element) count ++;
            else count --;
        }

        return x;
    }
}
