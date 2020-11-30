package algorithm.구현.validparentheses;

import java.util.Stack;

/*
 * 출처: leetcode
 * 문제 이름: Valid Parentheses
 * */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] brackets = s.toCharArray();
        for(char c : brackets) {
            //여는 괄호의 경우에는 스택에 push
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            else {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
