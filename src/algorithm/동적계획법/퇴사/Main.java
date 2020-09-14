package algorithm.동적계획법.퇴사;

import java.util.Scanner;

public class Main {

    static int n; // 전체 상담 개수
    static int[] t = new int[15]; // 각 상담을 완료하는데 걸리는 기간
    static int[] p = new int[15]; // 각 상담을 완료했을 때 받을 수 있는 금액
    static int[] dp = new int[16]; // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
    static int maxValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //전체 상담 개수
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();//상담에 걸리는 시간(일)
            p[i] = sc.nextInt();//상담 완료시 받는 보상
        }

        //가장 마지막 상담부터 첫 번째 상담까지 내려가면서 다이나믹 프로그래밍
        for (int i = n - 1; i >= 0; i--) {
            int time = i + t[i];
            //상담이 기간 내에 끝나는 경우
            if(time <= n) {
                dp[i] = Math.max(p[i] + dp[time], maxValue);
                maxValue = dp[i];
            }
            //상담이 기간 내에 끝나지 않는 경우
            else {
                dp[i] = maxValue;
            }
        }

        System.out.println(maxValue);
    }
}
