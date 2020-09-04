package algorithm.최단경로.다익스트라.우선순위큐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
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

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class Main {
    public static final int INF = (int) 1e9;//무한의 값으로 10억 설정
    //순서대로 노드의 개수, 간선의 개수, 시작 노드 번호
    //노드의 개수는 최대 100000개라고 가정
    public static int n, m, start;
    //각 노드에 연결되어있는 노드에 대한 정보를 담을 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //최단 거리 테이블 만들기
    public static int[] d = new int[100001];
    //가장 거리가 짧은 노드 번호를 우선적으로 뽑아낼 수 있는 우선순위 큐
    public static PriorityQueue<Node> q = new PriorityQueue<>();

    private static void dijkstra(int start) {
        //시작 노드의 최단 거리를 0으로 설정하고 큐에 삽입
        d[start] = 0;
        q.offer(new Node(start, 0));
        //우선순위 큐에서 거리가 가까운 노드들을 우선적으로 뽑아서 반복
        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            int dist = currentNode.getDistance();//현재 노드까지의 비용
            int current = currentNode.getIndex();//현재 노드 번호
            //현재 노드가 이미 처리된 노드라면 무시
            if(d[current] < dist) continue;
            //현재 노드에서 갈 수 있는 노드들과의 최단 거리를 테이블에 update해준다.
            for (int i = 0; i < graph.get(current).size(); i++) {
                int distance = d[current] + graph.get(current).get(i).getDistance();
                //현재 노드로 갈 수 있는 최단 경로가 테이블에 있는 최단 경로보다 짧으면 갱신해준다.
                if (distance < d[graph.get(current).get(i).getIndex()]) {
                    d[graph.get(current).get(i).getIndex()] = distance;
                    //우선순위 큐에 해당 노드까지의 거리를 수정해서 추가
                    q.offer(new Node(graph.get(current).get(i).getIndex(), distance));
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
