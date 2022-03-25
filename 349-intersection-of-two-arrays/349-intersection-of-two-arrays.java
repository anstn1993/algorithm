class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> temp = new HashSet<>();
        Set<Integer> intersections = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            temp.add(nums1[i]);
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(temp.contains(nums2[i])) {
                intersections.add(nums2[i]);
            }
        }
        
        int[] result = new int[intersections.size()];
        Iterator<Integer> iterator = intersections.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            result[index++] = iterator.next();
        }
        
        return result;
    }
}