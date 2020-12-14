package algorithm.셔플알고리듬.fisheryates;

import java.util.ArrayList;
import java.util.List;
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

    //원본 배열을 리스트에 복사해서 리턴
    private List<Integer> getCopiedList() {
        List<Integer> copiedList = new ArrayList<>();
        for (int i = 0; i < original.length; i++) {
            copiedList.add(original[i]);
        }
        return copiedList;
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
        int[] shuffle = new int[original.length];
        List<Integer> list = getCopiedList();
        //리스트에서 난수로 뽑힌 숫자 index에 위치하는 숫자를 하나씩 지워가면서
        //난수의 범위를 줄여나가는 것이 핵심
        for(int i = 0; i < original.length; i++) {
            int removedIndex = rd.nextInt(list.size());
            shuffle[i] = list.get(removedIndex);
            list.remove(removedIndex);
        }
        return shuffle;
    }
}
