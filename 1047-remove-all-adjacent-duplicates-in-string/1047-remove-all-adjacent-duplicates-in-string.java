class Solution {
    public String removeDuplicates(String s) {
        if (s.length() == 1) {
            return s;
        }
        
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        Character[] chars = new Character[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            chars[i--] = stack.pop();
        }
        
        return Arrays.stream(chars).map(String::valueOf).collect(Collectors.joining());
    }
}