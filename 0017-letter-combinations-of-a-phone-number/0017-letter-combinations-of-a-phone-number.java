class Solution {
    
    private static Map<Character, String> map = new HashMap<>();
    
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        
        combinate(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private void combinate(String digits, int digitIdx, StringBuilder sb, List<String> list) {
        if (digitIdx >= digits.length()) {
            list.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(digitIdx));
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            combinate(digits, digitIdx + 1, new StringBuilder(sb), list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}