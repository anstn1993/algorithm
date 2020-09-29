package algorithm.구현.연속된자연수로자연수표현하기;

public class Solution {
    //start부터 연속된 자연수를 더해서 target값을 만들 수 있으면 그 값을 출력하고
    //그렇지 않으면 -1을 출력
    private int addFrom(int start, int target) {
        int result = 0;
        int value = start;
        while(result < target) {
            result += value;
            if(result == target) {
                return result;
            }
            else if(result < target) {
                value ++;
            }
            else {
                return -1;
            }
        }
        return -1;
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if(n == addFrom(i, n)) {
                answer ++;
            }
        }

        return answer;
    }
}
