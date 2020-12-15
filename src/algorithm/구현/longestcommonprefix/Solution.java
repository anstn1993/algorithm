package algorithm.구현.longestcommonprefix;

/*
 * 출처: leetcode
 * 문제 이름: Longest Common Prefix
 * */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            sb.append(strs[0].charAt(i));
            for(int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(sb.toString())) {
                    sb.delete(sb.length() - 1, sb.length());
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}
