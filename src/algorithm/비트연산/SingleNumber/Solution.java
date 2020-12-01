package algorithm.비트연산.SingleNumber;

import java.util.HashMap;
/*
 * 출처: leetcode
 * 문제 이름: Single Number
 * */
public class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i : nums) {
            if(map.get(i) == 1) return i;
        }
        return 0;
    }
}
