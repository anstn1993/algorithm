package algorithm.정렬.카드정렬하기;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }

        //카드 뭉치가 하나면 비교하지 않기 때문에 0을 출력하고 종료
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int sum = 0;
        while (!q.isEmpty()) {
            int a = q.poll();
            int b = q.poll();
            sum += (a + b);
            if (q.isEmpty()) break;
            q.offer(a + b);
        }
        System.out.println(sum);
    }
}
