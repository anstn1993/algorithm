package algorithm.최단경로.플로이드워셜.미래도시;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[][] graph = new int[101][101];//모든 노드에서 노드로 갈 수 있는 거리

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int INF = (int) 1e9;//그래프를 초기화할 매우 큰 수
        for(int i = 1; i < 101; i ++) {
            Arrays.fill(graph[i], INF);//그래프 값 초기화
        }
        int n = sc.nextInt();//노드의 수
        int m = sc.nextInt();//간선의 수
        //노드와 노드 사이의 연결 정보 초기화
        for (int i = 0; i < m; i++) {
            //a노드와 b노드는 양방향으로 연결되어 있다.
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        int x = sc.nextInt();//두 번쩨 목적지
        int k = sc.nextInt();//첫 번째 목적지

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //자기 자신에서 자기 자신은 연결되어 있지 않기 때문에 0으로 바꿔준다.
                if (i == j) graph[i][j] = 0;
            }
        }

        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][p] + graph[p][j]);
                }
            }
        }

        //결과 출력
        if(graph[1][k] != INF && graph[k][x] != INF) {
            System.out.println(graph[1][k] + graph[k][x]);
        }
        else {
            System.out.println(-1);
        }
    }
}
