package algorithm.backtracking.generateparentheses;

import java.util.ArrayList;
import java.util.List;
/*
* 출처: leetcode
* 문제 이름: generate parentheses
* */
public class Solution {
    //numClosed > numOpend -> invalid
    private void process(int n, int numOpen, int numClosed, String str, List<String> result) {
        //종료 조건
        if(numOpen == n && numClosed == n) {
            result.add(str);
            return;
        }

        //재귀
        //여는 괄호가 n보다 작은 경우에만
        if(numOpen < n) {
            //여는 괄호 추가
            process(n, numOpen + 1, numClosed, str + "(", result);
        }
        //여는 괄호의 개수가 닫는 괄호의 개수보다 많은 경우에만
        if(numOpen > numClosed) {
            //닫는 괄호 추가
            process(n, numOpen, numClosed + 1, str + ")", result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        process(n, 0, 0, "", result);
        return result;
    }
}
