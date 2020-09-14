package algorithm.동적계획법.정수삼각형;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n + 1][n + 1];

        //값 설정
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        //다이나믹 프로그래밍 시작
        for (int row = 2; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                //첫 번째 열인 경우
                if(column == 1) triangle[row][column] = triangle[row - 1][column] + triangle[row][column];
                //마지막 열인 경우
                else if(column == row) triangle[row][column] = triangle[row - 1][column - 1] + triangle[row][column];
                //중간에 위치한 열인 경우
                else triangle[row][column] = Math.max(triangle[row - 1][column - 1], triangle[row - 1][column]) + triangle[row][column];
            }
        }

        //삼각형의 제일 밑에 칸을 순회하면서 최대값을 찾는다.
        int result = -1;
        for(int i = 1; i <= n; i ++) {
            result = Math.max(result, triangle[n][i]);
        }
        System.out.println(result);
    }
}
