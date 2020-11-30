package algorithm.비트연산.hammingdistance;

/*
 * 출처: leetcode
 * 문제 이름: Hamming Distance
 * */
public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        //32비트의 이진수를 i만큼 right shift를 하고 1과 and 연산을 하면 xor비트 중 1인 비트만 찾을 수 있다.
        for (int i = 0; i < 32; i++) {
            cnt += (xor >> i) & 1;
        }
        return cnt;
    }
}
