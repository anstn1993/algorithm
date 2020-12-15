package algorithm.투포인터.longestsubstringwithoutrepeatingcharacter;
/*
 * 출처: leetcode
 * 문제 이름: Longest Substring Without Repeating Characters
 * */
public class Solution {
    /*
    * brute force
    * */
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        StringBuffer sb = new StringBuffer();
        int longestLength = 0;
        //brute force
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                //현재 문자가 만들어진 문자열에 포함이 안 되는 경우 문자열에 추가
                if(!sb.toString().contains(Character.toString(s.charAt(j)))) sb.append(s.charAt(j));
                    //현재 문자가 만들어진 문자열에 포함이 되는 경우
                else {
                    break;
                }
            }
            // longestLength 갱신 및 sb 비우기
            longestLength = Math.max(longestLength, sb.length());
            sb.delete(0, sb.length());
        }
        return longestLength;
    }
    /*
    * sliding window
    * */
//    public int lengthOfLongestSubstring(String s) {
//
//    }
}
