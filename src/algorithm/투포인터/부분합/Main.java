package algorithm.투포인터.부분합;

public class Main {
    public static void main(String[] args) {
        int n = 5;//데이터 수
        int m = 5;//부분합
        int[] data = {1, 2, 3, 2, 5};
        int count = 0;//부분합의 수
        int intervalSum = 0;//중간 연산을 위한 값
        int end = 0;
        //start를 기준으로 iteration
        //중간 연산 값이 부분합 m보다 작으면 end를 한 칸 뒤로 이동
        //중간 연산 값이 부분합 m보다 크거나 같으면 start를 한 칸 뒤로 이동
        for (int start = 0; start < n; start++) {
            while(intervalSum < m && end < n) {
                intervalSum += data[end];
                end ++;
            }
            //부분합 m과 intervalSum과 같은 경우
            if(intervalSum == m) count ++;//개수 추가
            //start가 다음 칸으로 이동하기 전에 기존에 더해졌던 start의 값을 빼준다
            intervalSum -= data[start];
        }
        System.out.println(count);
    }
}
