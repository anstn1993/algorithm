package algorithm.dfs.유기농배추;

import java.util.Scanner;

public class Main {
    //상하좌우 정보
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int m, n;

    private static void dfs(int x, int y, int[][] arr) {
        //현재 자리의 값을 0으로 교체
        arr[x][y] = 0;

        //상하좌우로 재귀 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //공간 범위 안에 있는 경우
            if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                //배추인 경우
                if(arr[nx][ny] == 1) {
                    dfs(nx, ny, arr);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int[][] arr = new int[m][n];
            int k = sc.nextInt();
            int count = 0;//배추흰지렁이 마리 수
            //배추 위치 초기화
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }
            //dfs탐색 시작
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    //배추가 있는 곳인 경우
                    if (arr[x][y] == 1) {
                        dfs(x, y, arr);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
