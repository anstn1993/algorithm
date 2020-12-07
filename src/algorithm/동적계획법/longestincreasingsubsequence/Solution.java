package algorithm.동적계획법.longestincreasingsubsequence;

/*
 * 출처: leetcode
 * 문제 이름: Longest Increasing Subsequence
 * */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] d = new int[nums.length];
        d[0] = 1;//첫 번째 인덱스의 요소 하나만 subsequence로 가져가면 length는 무조건 1
        int longestLength = d[0];
        //점화식
        //f(x) = x인덱스 요소를 포함해서 가장 긴 subsequence의 길이
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && d[j] > max) max = d[j];
            }
            d[i] = max + 1;
            if(d[i] > longestLength) longestLength = d[i];
        }
        return longestLength;
    }
}
