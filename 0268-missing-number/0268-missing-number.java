class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i <= nums.length; i++) {
            result = result ^ i;
        }
        
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        
        return result;
    }
}