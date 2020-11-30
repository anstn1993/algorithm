package algorithm.동적계획법.climbingstairs;
/*
 * 출처: leetcode
 * 문제 이름: Climbing Stairs
 * */
public class Solution {
    //한 번에 1칸 혹은 2칸을 오를 수 있는 계단을 오를 때 n칸을 오르는 방법은 n-1칸까지 오르는 가지수에서 1칸을 올라오는 방법과 n-2칸까지 오르는 가지수에서 2칸을 올라오는 방법의 합이기 때문에 결국
    //n칸을 오르는 방법의 수는 n-1칸을 오르는 방법의 수와 n-2칸을 오르는 방법의 수와 같다.

    public int climbStairs(int n) {
        int[] cache = new int[46];
        cache[1] = 1;
        cache[2] = 2;
        for(int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
