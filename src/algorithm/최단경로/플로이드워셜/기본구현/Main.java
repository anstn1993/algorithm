package algorithm.최단경로.플로이드워셜.기본구현;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int INF = (int) 1e9;//무한을 의미하는 값으로 10억
    //순서대로 노드의 수(노드 최대 500개), 간선의 수
    public static int n, m;
    //2차원 배열 그래프(다이나믹 프로그래밍의 DP테이블과도 같은 역할)
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        //최단 거리 데이터를 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        //자기 자신에서 자기 자신으로 가는 거리는 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        //각 간선에 대한 정보를 입력 받아서 그 값으로 초기화화
        for (int i = 0; i < m; i++) {
            //a에서 b로 가는 비용은 c
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        //보텀업 방식으로 알고르즘 수행
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                //k를 거쳐가야 하는 최단 경로와 기존에 테이블에 있던 값 중 더 작은 값으로 기록한다.
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        //결과 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) {
                    System.out.print("INFINITY ");
                }
                else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
