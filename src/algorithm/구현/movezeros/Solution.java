package algorithm.구현.movezeros;
/*
 * 출처: leetcode
 * 문제 이름: Move Zeroes
 * */
public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;//0이 아닌 다른 숫자들 사이의 순서를 지키기 위해서 필요한 index
        //배열의 루프를 돌면서 다음을 확인한다.
        for (int i = 0; i < nums.length; i++) {
            //현재 숫자가 0이 아닌 경우 현재 숫자와 index에 위치한 숫자와 자리를 바꿔주고 index를 한 칸 뒤로 설정
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

    }
}
