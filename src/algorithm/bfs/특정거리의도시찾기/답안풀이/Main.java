package algorithm.bfs.특정거리의도시찾기.답안풀이;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // 모든 도시에 대한 최단 거리 초기화
    public static int[] d = new int[300001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        //그래프 및 각 그래프에 도달하는 최단 거리 초기화
        for (int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

        //모든 도로 정보 입력 받기
        for(int i = 0; i < m; i ++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph.get(start).add(end);
        }

        //출발 도시까지의 거리는 0으로 설정
        d[x] = 0;

        //너비 우선 탐색 수행
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            //현재 도시에서 이동할 수 있는 모든 도시를 돌면서 확인
            for(int i = 0; i < graph.get(now).size(); i ++) {
                int nextNode = graph.get(now).get(i);
                //아직 방문하지 않은 경우에만 방문 처리
                if(d[nextNode] == -1) {
                    d[nextNode] += d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        boolean check = false;
        for(int i = 1; i <= n; i ++) {
            if(d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        //만약 최단 거리가 k인 도시가 없으면 -1
        if(!check) {
            System.out.println(-1);
        }
    }
}
