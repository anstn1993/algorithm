package algorithm.구현.implementstrStr;

/*
 * 출처: leetcode
 * 문제 이름: Implement strStr()
 * */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;//needle이 haystack에 포함되지 않으면 -1 반환
        int length = needle.length();
        for(int i = 0; i < haystack.length(); i++) {
            StringBuffer sb = new StringBuffer();
            //haystack의 현재 인덱스로부터 needle의 길이만큼 문자열을 뽑아내서 needle과 같은지 비교
            for(int j = i; j < i + length; j ++) {
                if(j < haystack.length()) sb.append(haystack.charAt(j));
            }
            //뽑아낸 문자열이 needle과 같으면 현재 index 반환
            if(sb.toString().equals(needle)) return i;
        }
        return 0;
    }
}
