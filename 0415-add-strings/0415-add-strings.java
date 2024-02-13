class Solution {
    public String addStrings(String num1, String num2) {
        
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        
        int num1Sub = 0;
        int num2Sub = 0;
        int carry = 0;
        int sum = 0;
        List<Integer> sumArr = new ArrayList<>();
        
        int i = num1Arr.length - 1;
        int j = num2Arr.length - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                num1Sub = num1Arr[i--] - '0';
            }
            
            if (j >= 0) {
                num2Sub = num2Arr[j--] - '0';
            }
            
            sum = (num1Sub + num2Sub + carry) % 10;
            sumArr.add(sum);           
            // 다음 연산을 위한 초기화
            carry = (num1Sub + num2Sub + carry) / 10;
            num1Sub = 0;
            num2Sub = 0;
        }
        
        Collections.reverse(sumArr);
        return sumArr.stream().map(String::valueOf).collect(Collectors.joining());
    }
}