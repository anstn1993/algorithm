package algorithm.최단경로.다익스트라.화성탐사;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {

    public static void main(String[] args) {
        int INF = (int) 1e9;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        //상하좌우 정보
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[] result = new int[t];
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int[][] table = new int[n][n];//(0, 0)에서 각 노드로 가는 최단 경로를 저장할 테이블
            //최단 경로를 무한으로 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(table[i], INF);
            }
            PriorityQueue<Node> q = new PriorityQueue<>();
            q.offer(new Node(0, 0, map[0][0]));//우선순위 큐에 (0, 0) 노드 추가
            while (!q.isEmpty()) {
                Node current = q.poll();
                int x = current.getX();
                int y = current.getY();
                int cost = current.getCost();
                if (table[x][y] < cost) {//이미 큐에 들어와서 처리된 노드인 경우 다시 큐에 넣지 않는다.
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    //인접한 노드(오른쪽, 아래쪽 노드) 검사
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(table[nx][ny] > cost + map[nx][ny]) {
                        table[nx][ny] = cost + map[nx][ny];//테이블 값 갱신
                        q.offer(new Node(nx, ny, table[nx][ny]));//큐에 추가
                    }
                }
            }
            result[tc] = table[n - 1][n - 1];
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
