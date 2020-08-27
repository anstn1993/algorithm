package algorithm.그리디.큰수의법칙;

import java.util.Scanner;
import java.util.Arrays;
/*
* 가장 큰 수를 k번 더한 후 두 번째로 큰 수를 한 번 더하는 연산을 반복하면 된다.
* */
class LargeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] data = new int[n];
        int answer = 0;
        for(int i = 0; i < n; i ++) {
            data[i] = sc.nextInt();
        }
        //오름차순 정렬
        Arrays.sort(data);
        int first = data[n - 1];//최대값
        int second = data[n - 2];//최소값

        //최대값으로 더해지는 횟수
        int count = (m / (k + 1)) * k + m % (k + 1);

        answer += first * count;
        answer += second * (m - count);

        System.out.print(answer);
    }
}
