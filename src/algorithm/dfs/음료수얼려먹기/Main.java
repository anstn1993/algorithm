package algorithm.dfs.음료수얼려먹기;

import java.util.Scanner;

public class Main {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1 <= n, m <= 1000
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();//버퍼 비우기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //자기 자신을 기준으로 상하좌우 탐색을 재귀적으로 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean dfs(int i, int j) {
        //범위를 벗어난 노드를 탐색하는 경우
        if (i <= -1 || j <= -1 || i >= n || j >= m) {
            return false;
        }
        if (graph[i][j] == 0) {
            //현재 위치의 노드 방문 처리
            graph[i][j] = 1;
            //현재 노드의 좌우상하 노드들에 대한 탐색도 수행
            dfs(i - 1, j);
            dfs(i + 1, j);
            dfs(i, j - 1);
            dfs(i, j + 1);
            return true;
        }
        return false;
    }
}
