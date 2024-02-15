class Solution {
    private static final Map<Character, Character> pairs = new HashMap<>();
    
    static {
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');
    }
    
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 1) {
            return false;
        }
    
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));            
            } else if (isOpenBracket(stack.peek()) && pairs.get(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty();
    }

    private boolean isOpenBracket(char bracket) {
        return pairs.keySet().contains(bracket);
    }
}