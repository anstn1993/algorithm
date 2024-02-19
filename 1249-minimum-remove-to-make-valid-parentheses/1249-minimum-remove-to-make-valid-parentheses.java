class Solution {
    
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        char[] charArr = new char[s.length()];
        Stack<Character> parenthesesStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charArr[i] = c;
            if (isCharacter(c)) {
                continue;
            } 
            
            switch (c) {
                case '(':
                    parenthesesStack.push(c);
                    indexStack.push(i);
                    break;
                case ')':
                    if (!parenthesesStack.isEmpty() && parenthesesStack.peek() == '(') {
                        parenthesesStack.pop();
                        indexStack.pop();
                    } else {
                        parenthesesStack.push(c);
                        indexStack.push(i);
                    }
                    break;
            }
        }
        
        while (!indexStack.isEmpty()) {
            charArr[indexStack.pop()] = '0';
        }
        
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != '0') {
                sb.append(charArr[i]);
            }
        }
        
        return sb.toString();
    }
    
    private boolean isCharacter(char c) {
        return c >= 97 && c <= 122;
    }
}