class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    // 이진 탐색 트리
    private int search(int[] nums, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return startIndex;
        }
        
        int midIndex = (startIndex + endIndex) / 2;
        
        if(target == nums[midIndex]) {
            return midIndex;
        } 
        else if(target > nums[midIndex]) {
            return search(nums, target, midIndex + 1, endIndex);
        }
        else {
            return search(nums, target, startIndex, midIndex - 1);
        }
    }
}