package algorithm.동적계획법.금광;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//테스트 케이스 수
        int[] result = new int[t];//결과를 반환할 리스트
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] d = new int[n][m];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    d[r][c] = sc.nextInt();
                }
            }
            for (int c = 1; c < m; c++) {
                for (int r = 0; r < n; r++) {
                    //r이 첫 번째 행인 경우
                    if (r == 0) {
                        d[r][c] = Math.max(d[r][c - 1], d[r + 1][c - 1]) + d[r][c];
                    }
                    //r이 마지막 행인 경우
                    else if (r == n - 1) {
                        d[r][c] = Math.max(d[r - 1][c - 1], d[r][c - 1]) + d[r][c];
                    }
                    //r이 중간에 있는 행인 경우
                    else {
                        d[r][c] = Math.max(Math.max(d[r - 1][c - 1], d[r][c - 1]), d[r + 1][c - 1]) + d[r][c];
                    }
                }
            }
            int max = 0;
            //최대값 찾기
            for (int r = 0; r < n; r++) {
                max = Math.max(d[r][m - 1], max);
            }
            result[i] = max;
        }

        //결과 출력
        for(int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
    }
}
