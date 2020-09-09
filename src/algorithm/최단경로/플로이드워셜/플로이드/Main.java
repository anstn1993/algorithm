package algorithm.최단경로.플로이드워셜.플로이드;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int INF = (int) 1e9;
    //각 노드에서 노드로 가는 최단 경로를 저장할 테이블
    public static int[][] d = new int[101][101];
    //시작부터 노드의 수, 간선의 수
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < 101; i++) {
            //최단 경로 테이블 값 세팅
            Arrays.fill(d[i], INF);
        }
        //테이블의 값 설정
        for (int i = 0; i < m; i++) {
            //노드 a에서 b로 가는 비용은 c
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //같은 노선이 복수로 존재할 수 있기 때문에 비용이 가장 짧은 노선만 저장한다.
            if(d[a][b] > c) {
                d[a][b] = c;
            }
        }
        //자기 자신으로 가는 경우는 0으로 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                }
            }
        }

        //플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        //결과 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //도달할 수 없는 곳은 0으로 출력
                if(d[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }
}
