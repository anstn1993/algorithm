package algorithm.bfs.미로탈출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int [][] graph = new int[n][m];

        for(int i = 0; i < n; i ++) {
            String str = sc.nextLine();
            for(int j = 0; j < m; j ++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        //이동할 방향(상하좌우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int result = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int [] position = queue.poll();
            int x = position[0];
            int y = position[1];
            //현재 노드의 상하좌우 노드롤 파악한다.
            for(int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위를 벗어나는 경우 그 칸도 무시
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                //괴물이 있는 곳이면 그 방향은 무시
                if(graph[nx][ny] == 0) {
                    continue;
                }
                //해당 노드를 처음 방문한 경우에만 큐에 노드 좌표를 추가해주고 그 좌표의 노드 값을 현재 노드 값에 + 1한 값으로 바꿔준다.
                if(graph[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    graph[nx][ny] = graph[x][y] + 1;
                }
            }
        }

        result = graph[n - 1][m - 1];
        System.out.println(result);
    }
}
