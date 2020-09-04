package algorithm.최단경로.다익스트라.간단한방식;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}

public class Main {
    public static final int INF = (int) 1e9;//무한의 값으로 10억 설정
    //순서대로 노드의 개수, 간선의 개수, 시작 노드 번호
    //노드의 개수는 최대 100000개라고 가정
    public static int n, m, start;
    //각 노드에 연결되어있는 노드에 대한 정보를 담을 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //방문한 적이 있는지 체크하는 배열
    public static boolean[] visited = new boolean[100001];
    //최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;//가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    private static void dijkstra(int start) {
        d[start] = 0;//시작 노드에서 시작 노드로 가는 최단 경로는 0
        visited[start] = true;
        //시작 노드와 연결된 노드들로 갈 수 있는 거리를 테이블에 업데이트해준다.
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }
        //시작 노드를 제외한 n - 1개의 노드에 대해서 반복 작업
        for (int i = 0; i < n; i++) {
            int now = getSmallestNode();
            visited[now] = true;//방문처리
            //현재 노드와 연결된 다른 노드들 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int distance = d[now] + graph.get(now).get(j).getDistance();
                //다른 노드로 가는 거리가 테이블에 저장된 거리보다 짧은 경우 그 값으로 갱신
                if(distance < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = distance;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        //모든 간선 정보 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //a노드에서 b노드로 가는 거리가 c라는 의미다
            graph.get(a).add(new Node(b, c));
        }

        //최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        //다익스트라 알고리즘 수행
        dijkstra(start);

        //모든 노드로 가기 위한 최단 거리 출력
        for (int i = 1; i <= n; i++) {
            //도달할 수 없는 경우 무한이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }
    }
}
