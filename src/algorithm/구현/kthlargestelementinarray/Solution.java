package algorithm.구현.kthlargestelementinarray;

import java.util.PriorityQueue;
/*
 * 출처: leetcode
 * 문제 이름: Kth Largest Element in Array
 * */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.offer(num);
        }
        for(int i = 0; i < nums.length - k; i++) {
            pq.poll();
        }
        return pq.peek();
    }
}
