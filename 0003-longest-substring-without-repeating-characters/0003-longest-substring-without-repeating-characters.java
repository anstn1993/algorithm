class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        
        Map<Character, Integer> charIndexMap = new HashMap<>();
        
        int begin = 0;
        int end = 0;
        int maxLength = 0;
        
        while (end < s.length()) {
            // 이미 해당 문자가 등장한 경우
            if (charIndexMap.containsKey(s.charAt(end)) && charIndexMap.get(s.charAt(end)) >= begin) {
                begin = charIndexMap.get(s.charAt(end)) + 1;
                charIndexMap.put(s.charAt(end), end);
            } 
            // 해당 문자가 등장하지 않은 경우
            else {
                charIndexMap.put(s.charAt(end), end);
            }
            end++;
            maxLength = maxLength > end - begin ? maxLength : end - begin;
        }
        
        return maxLength;
    }
    
}