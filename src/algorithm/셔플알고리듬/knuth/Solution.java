package algorithm.셔플알고리듬.knuth;

import java.util.Arrays;
import java.util.Random;

/*
 * 출처: leetcode
 * 문제 이름: Shuffle an array
 * */
public class Solution {
    private int[] original;
    private Random rd = new Random();

    public Solution(int[] nums) {
        original = nums;
    }


    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] shuffle = Arrays.copyOf(original, original.length);
        for (int i = 0; i < original.length; i++) {
            int targetIndex = rd.nextInt(original.length - i) + i;
            //현재 index와 target index의 숫자 swap
            int temp = shuffle[i];
            shuffle[i] = shuffle[targetIndex];
            shuffle[targetIndex] = temp;
        }
        return shuffle;
    }
}
