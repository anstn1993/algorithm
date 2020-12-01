package algorithm.구현.twosum;

import java.util.HashMap;

/*
 * 출처: leetcode
 * 문제 이름: Two Sum
 * */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();//key: 배열의 값, value: 배열의 인덱스
        //(target - 배열의 값)에 해당하는 키가 해쉬맵에 존해하면 해당 키의 값과 배열의 값의 합이 target이 되어서 정답
        //하지만 존재하지 않으면 현재 배열의 값을 키로 해서 해쉬 맵에 새롭게 삽입
        for (int i = 0; i < nums.length; i++) {
            //해쉬맵에 존재하는 경우
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            //해쉬맵에 존재하지 않는 경우
            else {
                //해쉬맵에 추가해준다.
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
