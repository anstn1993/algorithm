class Solution {
    public boolean isPalindrome(int x) {
        char[] xArr = String.valueOf(x).toCharArray();
    
        for (int i = 0, j = xArr.length - 1; i < xArr.length; i++, j--) {
            if (i >= j) {
                return true;
            }
            
            if (xArr[i] != xArr[j]) {
                return false;
            }
        }
        
        return true;
    }
}