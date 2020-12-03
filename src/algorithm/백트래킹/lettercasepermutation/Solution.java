package algorithm.백트래킹.lettercasepermutation;

import java.util.ArrayList;
import java.util.List;

/*
 * 출처: leetcode
 * 문제 이름: Letter Case Permutation
 * */
public class Solution {
    private void process(char[] chars, int index, String mid, List<String> result) {
        if(index >= chars.length) {
            result.add(mid);//완성된 글자를 result에 추가 후 종료
            return;//종료 조건
        }
        if(Character.isLetter(chars[index])) {//현재 index의 문자가 영문자면 mid에 소문자, 대문자를 하나씩 추가 후 재귀 호출
            String lower = mid + Character.toLowerCase(chars[index]);
            String upper = mid + Character.toUpperCase(chars[index]);
            process(chars, index + 1, lower, result);
            process(chars, index + 1, upper, result);
        }
        else {//숫자인 경우 숫자를 붙여서 재귀 호출
            mid += chars[index];
            process(chars, index + 1, mid, result);
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        process(chars, 0,"", result);
        return result;
    }
}
